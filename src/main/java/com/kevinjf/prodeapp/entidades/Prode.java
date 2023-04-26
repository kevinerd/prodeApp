package com.kevinjf.prodeapp.entidades;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinjf.prodeapp.enumeracion.ResultadoEnum;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Prode {
    private HashMap<Integer, Usuario> usuarios;
    private static int PUNTOS_POR_ACIERTO = 0;
    private static int PUNTOS_EXTRAS = 0;
    private int mayorPuntaje;
    private int idGanador;

    public Prode() {
        this.usuarios = new HashMap<>();
        this.idGanador = 0;
        this.mayorPuntaje = 0;
        
        ObjectMapper mapper = new ObjectMapper(); /* INSTANCIO EL MAPPER */
        String path = "src\\main\\java\\com\\kevinjf\\prodeapp\\config.json"; /* RUTA DEL JSON */
        File reader = new File( path ); /* CREO EL READER */
        
        try {
            Map<String, Object> map = mapper.readValue( reader, new TypeReference<Map<String,Object>>(){} );
            Prode.PUNTOS_POR_ACIERTO = (int) map.get( "PUNTOS_POR_ACIERTO" );
            Prode.PUNTOS_EXTRAS = (int) map.get( "PUNTOS_EXTRAS" );
        } catch( IOException e ) {
            System.out.println( "ERROR: " + e );
        }
    }
    
    public HashMap<Integer, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios( HashMap<Integer, Usuario> usuarios ) {
        this.usuarios = usuarios;
    }

    public int getMayorPuntaje() {
        return mayorPuntaje;
    }

    public void setMayorPuntaje( int mayorPuntaje ) {
        this.mayorPuntaje = mayorPuntaje;
    }

    public int getIdGanador() {
        return idGanador;
    }

    public void setIdGanador( int idGanador ) {
        this.idGanador = idGanador;
    }
    
    public int contarAciertos( Ronda r ) {
        int aciertos = 0;
        for( Partido p : r.getRondaHashMap().values() ) {
//            ResultadoEnum pronostico = Usuario.apuestasTot.get( p.getId() ).getPronostico();
            ResultadoEnum resultado = p.resultadoPartido();
//            if ( pronostico.equals( resultado ) ) {
//                aciertos += this.PUNTOS_POR_ACIERTO;
//            }
        }
        return aciertos;
    }

    public void mostrarAciertos( Torneo torneo ){
        for ( Usuario user : this.usuarios.values() ) {
            
            for ( Ronda ronda : torneo.getPartidos().values() ) {
                
                System.out.println( "RONDA N°" + ronda.getNumeroRonda() );
                
                int puntosPosibles = ronda.getRondaHashMap().size();
                
                System.out.println( "PUNTOS POSIBLES: " + puntosPosibles );
                
//                int aciertos = user.contarAciertos( ronda );
                
//                if( aciertos == puntosPosibles ) {
//                    aciertos += this.PUNTOS_EXTRAS;
//                    System.out.println(user.getNombre()+" TIENE "+this.PUNTOS_EXTRAS
//                            + " PUNTOS EXTRAS POR GANAR EN UNA RONDA COMPLETA!");
//                }
//                
//                user.puntosPorRonda( aciertos );
//                System.out.println( "------TERMINÓ LA RONDA------" );
            }
            
            if ( user.getPuntosTotales() > this.mayorPuntaje ) {
                this.mayorPuntaje = user.getPuntosTotales();
                this.idGanador = user.getDni();
            }
            
        }
        Usuario ganador = this.usuarios.get( this.idGanador );
        System.out.println("El ganador es "+ ganador.getNombre());
        System.out.println("OBTUVO: "+ganador.getPuntosTotales()+" PUNTOS! FELICIDADES!!");
    }
    
    // Metodo que muestra los datos del array totalApuestas.
    public void mostrarTickets() {
        System.out.println( "--------PRONÓSTICOS-------" );
        System.out.println( "--------------------------" );
        for( Usuario user : this.usuarios.values() ) {
            System.out.println( "USUARIO: " + user.getNombre() + " DNI: " + user.getDni() );
            for ( Ticket ticket : user.getApuestasTot().values() ) {
                System.out.println( ticket.toString() );                
            }
            
            System.out.println("--------------------------");
            System.out.println("--------------------------");
        }
    }
    public void mostrarCargaUsuarios() {
        for ( Usuario user : this.usuarios.values() ) {
            System.out.println( user.toString() );
        }
    }
    public void usuarioGanador() {
        ArrayList<Usuario> ordenGanador = new ArrayList<>();
        for ( Usuario user : this.usuarios.values() ) {
            ordenGanador.add( user ); 
        }
        Collections.sort( ordenGanador );
        for ( Usuario user : ordenGanador ) {
            System.out.println( user.getNombre() +" = "+ user.getPuntosTotales() );
        }
    }
}
