package com.kevinjf.prodeapp.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Prode {
    private HashMap<Integer, Usuario> usuarios;
    private final int PUNTOS_EXTRA = 2;
    private Integer mayorPuntaje;
    private Integer idGanador;

    public Prode() {
        this.usuarios = new HashMap<>();
        this.idGanador = 0;
        this.mayorPuntaje = 0;
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

    public void setMayorPuntaje( Integer mayorPuntaje ) {
        this.mayorPuntaje = mayorPuntaje;
    }

    public int getIdGanador() {
        return idGanador;
    }

    public void setIdGanador( Integer idGanador ) {
        this.idGanador = idGanador;
    }

    public void mostrarAciertos( Torneo torneo ){
        for ( Usuario user : this.usuarios.values() ) {
            
            for ( Ronda ronda : torneo.getPartidos().values() ) {
                
                System.out.println( "RONDA N°" + ronda.getNumeroRonda() );
                
                Integer puntosPosibles = ronda.getRondaHashMap().size();
                
                System.out.println( "PUNTOS POSIBLES: " + puntosPosibles );
                
                Integer aciertos = user.contarAciertos( ronda );
                
                if( aciertos == puntosPosibles ) {
                    aciertos += this.PUNTOS_EXTRA;
                    System.out.println(user.getNombre()+" TIENE "+this.PUNTOS_EXTRA
                            + " PUNTOS EXTRAS POR GANAR EN UNA RONDA COMPLETA!");
                }
                
                user.puntosPorRonda( aciertos );
                System.out.println( "------TERMINÓ LA RONDA------" );
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
    public void mostrarCargaApuestas() {
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
