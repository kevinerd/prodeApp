package com.kevinjf.prodeapp.entidades;

import com.kevinjf.prodeapp.enumeracion.ResultadoEnum;
import java.util.HashMap;

public class Usuario implements Comparable<Usuario> {
    private HashMap<Integer, Ticket> apuestasTot;
    
    private Integer dni;
    private String nombre;
    private Integer puntosTotales;
    private final Integer PUNTOS_POR_ACIERTO = 1;

    public HashMap<Integer, Ticket> getApuestasTot() {
        return apuestasTot;
    }

    public void setApuestasTot( HashMap<Integer, Ticket> apuestasTot ) {
        this.apuestasTot = apuestasTot;
    }

    public int getDni() {
        return dni;
    }

    public void setDni( Integer dni ) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales( Integer puntosTotales ) {
        this.puntosTotales = puntosTotales;
    }

    public Usuario( Integer dni, String nombre ) {
        this.dni = dni;
        this.puntosTotales = 0;
        this.nombre = nombre;
        this.apuestasTot = new HashMap<>();
    }   

    
    public int contarAciertos( Ronda r ) {
        int aciertos = 0;
        for( Partido p : r.getRondaHashMap().values() ) {
            ResultadoEnum pronostico = this.apuestasTot.get( p.getIdPartido() ).getPronostico();
            ResultadoEnum resultado = p.resultadoPartido();
            if ( pronostico.equals( resultado ) ) {
                aciertos += this.PUNTOS_POR_ACIERTO;
            }
        }
        return aciertos;
    }

    @Override
    public String toString() {
        String msj = "Usuario= "+ dni + " " + nombre + "\n";
        for (Ticket tk : this.apuestasTot.values()) {
            msj += tk.toString() + "\n";
        }
        return msj;
    } 
    
    public void puntosPorRonda( Integer aciertos ){
        this.puntosTotales += aciertos;
    }
    
    @Override
    public int compareTo( Usuario user ){
        String a = new String(String.valueOf(this.puntosTotales));
        String b = new String(String.valueOf(user.getPuntosTotales()));
        return b.compareTo(a);
    }
}