package com.kevinjf.prodeapp.entidades;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinjf.prodeapp.enumeracion.ResultadoEnum;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prode {
    private HashMap<Integer, Usuario> usuariosHashMap;
    private static int PUNTOS_POR_ACIERTO = 0;
    private static int PUNTOS_EXTRAS = 0;
    private int mayorPuntaje;
    private ArrayList<Integer> puntosUsuarios;
    private Usuario ganador;

    public Prode() {
        this.usuariosHashMap = new HashMap<>();
        this.ganador = new Usuario();
        this.puntosUsuarios = new ArrayList();
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
    
    public HashMap<Integer, Usuario> getUsuariosHashMap() {
        return usuariosHashMap;
    }

    public void setUsuarios( HashMap<Integer, Usuario> usuariosHashMap ) {
        this.usuariosHashMap = usuariosHashMap;
    }

    public int getMayorPuntaje() {
        return mayorPuntaje;
    }

    public void setMayorPuntaje( int mayorPuntaje ) {
        this.mayorPuntaje = mayorPuntaje;
    }

    public ArrayList<Integer> getPuntosUsuarios() {
        return puntosUsuarios;
    }

    public void setIdUsuarios(ArrayList<Integer> puntosUsuarios) {
        this.puntosUsuarios = puntosUsuarios;
    }

    public Usuario getGanador() {
        return ganador;
    }

    public void setGanador(Usuario ganador) {
        this.ganador = ganador;
    }

    public static int getPUNTOS_POR_ACIERTO() {
        return PUNTOS_POR_ACIERTO;
    }

    public static void setPUNTOS_POR_ACIERTO(int PUNTOS_POR_ACIERTO) {
        Prode.PUNTOS_POR_ACIERTO = PUNTOS_POR_ACIERTO;
    }

    public static int getPUNTOS_EXTRAS() {
        return PUNTOS_EXTRAS;
    }

    public static void setPUNTOS_EXTRAS(int PUNTOS_EXTRAS) {
        Prode.PUNTOS_EXTRAS = PUNTOS_EXTRAS;
    }
    
    // Método que muestra los datos del array totalApuestas.
    public void mostrarTickets() {
        System.out.println( "---------TICKETS----------" );
        System.out.println( "--------------------------" );
        for( Usuario user : this.usuariosHashMap.values() ) {
            for ( Ticket ticket : user.getTicketsUsuarios().values() ) {
                System.out.println(ticket.toString());       
            }
        }
    }
    
    public void calcularPuntaje( Torneo torneo ) {
        for ( Map.Entry<Integer, Partido> partido : torneo.getPartidos().entrySet() ) {
            // Obtengo los partidos y voy analizando los resultados de cada uno.
            ResultadoEnum resultadoPartido = null;
            int golesEq1 = partido.getValue().getGolesEq1();
            int golesEq2 = partido.getValue().getGolesEq2();
            
            if( golesEq1 < golesEq2 ) {
                resultadoPartido = ResultadoEnum.PIERDE;
            }
            if ( golesEq1 > golesEq2 ) {
                    resultadoPartido = ResultadoEnum.GANA;
            }
            if ( Objects.equals( golesEq1, golesEq2 ) ) {
                resultadoPartido = ResultadoEnum.EMPATE;
            }
            
            for ( Map.Entry<Integer, Usuario> usuario : this.usuariosHashMap.entrySet() ) {
                // Recorro los usuarios y busco los tickets que le corresponden
                HashMap<Integer, Ticket> ticketsHashMap = usuario.getValue().getTicketsUsuarios();
                int puntosUsuario = usuario.getValue().getPuntosTotales();
                
                for ( Map.Entry<Integer, Ticket> ticket : ticketsHashMap.entrySet() ) {
                    // Recorro los tickets de cada usuario y busco el partido que corresponde a cada ticket
                    ticketsHashMap.get(partido.getValue().getId());
                    
                    // Verifico que el id de los partidos coincidan
                    if ( ticket.getValue().getPartido().getId() == partido.getValue().getId() ) {
                        // Obtengo el pronóstico del usuario y le asigno el valor del ResultadoEnum
                        ResultadoEnum pronosticoUsuario = null;
                        switch( ticket.getValue().getPronostico() ) {
                            case GANA: {
                                pronosticoUsuario = ResultadoEnum.GANA;
                                break;
                            }
                            case EMPATE: {
                                pronosticoUsuario = ResultadoEnum.EMPATE;
                                break;
                            }
                            case PIERDE: {
                                pronosticoUsuario = ResultadoEnum.PIERDE;
                                break;
                            }
                        }
                        if ( pronosticoUsuario == resultadoPartido ) {
                            // Comparo los resultados y asigno los puntos si son iguales.
                            puntosUsuario += Prode.PUNTOS_POR_ACIERTO;
                        }
                    }
                }
                // Le seteo los puntos al usuario.
                usuario.getValue().setPuntosTotales(puntosUsuario);
                
                // Comparo para buscar el puntaje mayor.
                if ( puntosUsuario > mayorPuntaje ) {
                    mayorPuntaje = puntosUsuario;
                    ganador = usuario.getValue();
                }
            }
        }
        System.out.println("El ganador es "+ ganador.getNombre());
        System.out.println("OBTUVO: "+ganador.getPuntosTotales()+" PUNTOS! FELICIDADES!!");
    }
    
    public void listaPosicionesUsuarios() {
        ArrayList<Usuario> ordenGanador = new ArrayList<>();
        for ( Usuario user : this.usuariosHashMap.values() ) {
            ordenGanador.add( user );
        }
        // Acá quise ordenar por puntos, pero no supe como hacerlo bien.
//        Collections.sort( ordenGanador );
        for ( Usuario user : ordenGanador ) {
            System.out.println( user.getNombre() +" = "+ user.getPuntosTotales() );
        }
    }
}