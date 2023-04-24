package com.kevinjf.prodeapp;

import com.kevinjf.prodeapp.entidades.Equipo;
import com.kevinjf.prodeapp.entidades.Partido;
import com.kevinjf.prodeapp.entidades.Ronda;
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
import java.util.Objects;

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
            
            ResultSet rs = st.executeQuery( "SELECT * FROM usuarios" );
            
            while( rs.next() ) {
                int dni = rs.getInt( "dni" );
                String nombre = rs.getString( "nombre" );
                Usuario user = new Usuario( dni, nombre );
                usuarios.put( user.getDni(), user );
            }
            
            System.out.println( "USUARIOS CARGADOS!" );
            
            rs.close();
            conn.close();
        } catch(Exception e) {
            System.out.println( "ERROR: " + e );
        }
    }

    public static void getEquipos( HashMap<String, Equipo> equipos ) throws SQLException {
        try ( Connection conn = DriverManager.getConnection( URL_DB, USER, PASS ) ) {
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery( "SELECT * FROM equipos" );
            
            while( rs.next() ) {
                String nombreEq = rs.getString( "equipo" );
                int pj = rs.getInt( "partidosJugados" );
                Equipo eq = new Equipo( nombreEq, pj );
                equipos.put( nombreEq, eq );
            }
            
            System.out.println( "EQUIPOS CARGADOS!" );
            
            rs.close();
            conn.close();
        } catch( Exception e ) {
            System.out.println( "ERROR: " + e );
        }
    }
    
    public static void getPartidos( Torneo torneo ) throws SQLException {
        try ( Connection conn = DriverManager.getConnection( URL_DB, USER, PASS ) ) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "SELECT * FROM partidos ORDER BY fase ASC, ronda ASC;" );
            
            Integer countRondas = 1;
            Ronda rondaaa = new Ronda( countRondas );
            
            while( rs.next() ) {
                System.out.println("COUNT RONDAS WHILE: "+ countRondas);
                Integer idPartido = rs.getInt( "idPartido" );
                Integer fase = rs.getInt("fase");
                Integer ronda = rs.getInt("ronda");
                Equipo eq1 = torneo.buscarEquipo( rs.getString( "equipo1" ) );
                Integer golesEq1 = rs.getInt( "golesEq1" );
                Integer golesEq2 = rs.getInt( "golesEq2" );
                Equipo eq2 = torneo.buscarEquipo( rs.getString( "equipo2" ) );
                
                Partido partido = new Partido( idPartido, fase, ronda, eq1, golesEq1, golesEq2, eq2 );
                
                System.out.println("Partido: " + partido.toString());
                if( Objects.equals(ronda, countRondas) ) {
                    System.out.println("EQUALS RONDA: " + Objects.equals(ronda, countRondas));
                    torneo.getPartidos().put( countRondas, rondaaa );
                    System.out.println("COUNT RONDAS IF: " + countRondas);
                    
//                    countRondas++;
//                    rondaaa = new Ronda( countRondas );
                }
                
                rondaaa.getRondaHashMap().put( partido.getIdPartido(), partido );
                System.out.println("RONDAAA IF: " + rondaaa.toString());
                if ( countRondas == torneo.getTOTAL_RONDAS() ) {
                    System.out.println("IF COUNTRONDAS: " + countRondas + rondaaa.toString() );
                    torneo.getPartidos().put( countRondas, rondaaa );
                }
            }
            System.out.println( "PARTIDOS CARGADOS!" );
            
            rs.close();
        } catch( Exception e ) {
            System.out.println( "ERROR: " + e );
        }
    }
    
    public static void getPronosticos( HashMap<Integer, Usuario> usuarios ) throws SQLException {
        try ( Connection conn = DriverManager.getConnection( URL_DB, USER, PASS ) ) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( "SELECT * FROM pronosticos" );
            
            Integer pronosticoUser = 0;
            
            while( rs.next() ) {
                Integer dni = rs.getInt( "dni" );
                Integer idPartido = rs.getInt( "idPartido" );
                Integer pronostico = rs.getInt( "pronostico" );
                
                ResultadoEnum pronosticoEnum;
                
                switch ( pronostico ) {
                    case 1:
                        pronosticoUser = 1;
                        pronosticoEnum = ResultadoEnum.GANA;
                        break;
                    case 2:
                        pronosticoUser = 2;
                        pronosticoEnum = ResultadoEnum.EMPATE;
                        break;
                    case 3:
                        pronosticoUser = 3;
                        pronosticoEnum = ResultadoEnum.PIERDE;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                Usuario usuario = usuarios.get( dni );
                Ticket ticket = new Ticket( idPartido, pronosticoUser, pronosticoEnum );
                usuario.getApuestasTot().put( ticket.getIdPartido(), ticket );
            }
            
            System.out.println( "PRONÓSTICOS CARGADOS!" );
            
            rs.close();
            conn.close();
        } catch(Exception e) {
            System.out.println( "ERROR: " + e );
        }
    }
}