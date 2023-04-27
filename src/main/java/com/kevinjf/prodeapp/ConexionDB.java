package com.kevinjf.prodeapp;

import com.kevinjf.prodeapp.entidades.Equipo;
import com.kevinjf.prodeapp.entidades.Partido;
import com.kevinjf.prodeapp.entidades.Ticket;
import com.kevinjf.prodeapp.entidades.Torneo;
import com.kevinjf.prodeapp.entidades.Usuario;
import com.kevinjf.prodeapp.enumeracion.ResultadoEnum;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ConexionDB {
    static String URL_DB;
    static String USER;
    static String PASS;
    
    public static void configDb() throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper(); /* INSTANCIO EL MAPPER */
        
        String path = "src\\main\\java\\com\\kevinjf\\prodeapp\\config.json"; /* RUTA DEL JSON */
        
        File reader = new File( path ); /* CREO EL READER */
        
        try {
            Map<String, Object> map = mapper.readValue( reader, new TypeReference<Map<String,Object>>(){} );
            
            ConexionDB.URL_DB = (String) map.get( "URL_DB" );
            ConexionDB.USER = (String) map.get( "USER" );
            ConexionDB.PASS = (String) map.get( "PASS" );
        } catch( IOException e ) {
            System.out.println( "ERROR: " + e );
        }
    }
    
    public static void getUsuarios( HashMap<Integer, Usuario> usuarios ) throws SQLException {
        try ( Connection conn = DriverManager.getConnection( URL_DB, USER, PASS ) ) {
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery( "SELECT * FROM usuario" );
            
            while( rs.next() ) {
                Usuario user = new Usuario( rs.getInt( "dni" ), rs.getString( "nombre" ) );
                usuarios.put( user.getDni(), user );
            }
            
            System.out.println( "USUARIOS CARGADOS!" );
            
            rs.close();
            conn.close();
        } catch(Exception e) {
            System.out.println( "ERROR: " + e );
        }
    }

    public static void getEquipos( HashMap<Integer, Equipo> equipos ) throws SQLException {
        try ( Connection conn = DriverManager.getConnection( URL_DB, USER, PASS ) ) {
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery( "SELECT * FROM equipo" );
            
            while( rs.next() ) {
                String nombreEq = rs.getString( "nombre" );
                Equipo eq = new Equipo( rs.getInt( "id" ), nombreEq );
                equipos.put( eq.getId(), eq );
            }
            System.out.println( "EQUIPOS CARGADOS!" );
            
            rs.close();
            conn.close();
        } catch( Exception e ) {
            System.out.println( "ERROR: " + e );
        }
    }
    
    public static void getPartidos( Torneo torneo, HashMap<Integer, Partido> partidos ) throws SQLException {
        try ( Connection conn = DriverManager.getConnection( URL_DB, USER, PASS ) ) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "SELECT * FROM partido ORDER BY num_fase ASC, num_ronda ASC;" );
            
            while( rs.next() ) {
                Equipo equipo1 = torneo.buscarEquipo( rs.getInt( "equipo_id1" ) );
                Equipo equipo2 = torneo.buscarEquipo( rs.getInt( "equipo_id2" ) );
                
                Partido partido = new Partido(
                    rs.getInt( "id" ), rs.getInt( "num_fase" ), 
                    rs.getInt( "num_ronda" ), equipo1, 
                    rs.getInt( "goles_eq1" ), rs.getInt( "goles_eq2" ), 
                    equipo2
                );
                
                if( partido.getNumFase() == 1 ) {
                    torneo.getFase1().add( partido );
                } else {
                    torneo.getFase2().add( partido );
                }
                partidos.put( partido.getId(), partido );
            }
            System.out.println("PARTIDOS CARGADOS!");
        } catch( Exception e ) {
            System.out.println( "ERROR: " + e );
        }
    }
    
    public static void getTickets( HashMap<Integer, Usuario> usuarios, Torneo torneo ) throws SQLException {
        try ( Connection conn = DriverManager.getConnection( URL_DB, USER, PASS ) ) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "SELECT * FROM ticket" );
            
            while( rs.next() ) {
                int ticketId = rs.getInt( "id" );
                Usuario usuario = usuarios.get( rs.getInt( "usuario_dni" ) );
                Partido partido = torneo.buscarPartido( rs.getInt( "partido_id" ) );
                int pronostico = rs.getInt( "pronostico" );
                ResultadoEnum pronosticoEnum;
                
                switch ( pronostico ) {
                    case 1:
                        pronosticoEnum = ResultadoEnum.GANA;
                        break;
                    case 2:
                        pronosticoEnum = ResultadoEnum.EMPATE;
                        break;
                    case 3:
                        pronosticoEnum = ResultadoEnum.PIERDE;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                Ticket ticket = new Ticket( ticketId, usuario, partido, pronosticoEnum );
                usuario.getTicketsUsuarios().put( ticketId, ticket );
            }
            
            System.out.println( "PRONÓSTICOS CARGADOS!" );
            
            rs.close();
            conn.close();
        } catch(Exception e) {
            System.out.println( "ERROR: " + e );
        }
    }
}