package com.kevinjf.prodeapp.entidades;

import java.util.HashMap;

public class Usuario implements Comparable<Usuario> {
    private HashMap<Integer, Ticket> apuestasTot;
    
    private int dni;
    private String nombre;
    private int puntosTotales;

    public HashMap<Integer, Ticket> getApuestasTot() {
        return apuestasTot;
    }

    public void setApuestasTot( HashMap<Integer, Ticket> apuestasTot ) {
        this.apuestasTot = apuestasTot;
    }

    public int getDni() {
        return dni;
    }

    public void setDni( int dni ) {
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

    public void setPuntosTotales( int puntosTotales ) {
        this.puntosTotales = puntosTotales;
    }

    public Usuario( int dni, String nombre ) {
        this.dni = dni;
        this.puntosTotales = 0;
        this.nombre = nombre;
        this.apuestasTot = new HashMap<>();
    }

    @Override
    public String toString() {
        String msj = "Usuario= "+ dni + " " + nombre + "\n";
        for (Ticket tk : this.apuestasTot.values()) {
            msj += tk.toString() + "\n";
        }
        return msj;
    } 
    
    public void puntosPorRonda( int aciertos ){
        this.puntosTotales += aciertos;
    }
    
    @Override
    public int compareTo( Usuario user ){
        String a = new String(String.valueOf(this.puntosTotales));
        String b = new String(String.valueOf(user.getPuntosTotales()));
        return b.compareTo(a);
    }
}