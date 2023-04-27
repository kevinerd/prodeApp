package com.kevinjf.prodeapp.entidades;

import java.util.HashMap;

public class Usuario {
    private HashMap<Integer, Ticket> ticketsUsuarios;
    private int dni;
    private String nombre;
    private int puntosTotales;

    public Usuario() {
    }
    
    public Usuario( int dni, String nombre ) {
        this.dni = dni;
        this.puntosTotales = 0;
        this.nombre = nombre;
        this.ticketsUsuarios = new HashMap<>();
    }

    public Usuario(HashMap<Integer, Ticket> ticketsUsuarios, int dni, String nombre, int puntosTotales) {
        this.ticketsUsuarios = ticketsUsuarios;
        this.dni = dni;
        this.nombre = nombre;
        this.puntosTotales = puntosTotales;
    }

    public HashMap<Integer, Ticket> getTicketsUsuarios() {
        return ticketsUsuarios;
    }

    public void setTicketsUsuarios( HashMap<Integer, Ticket> ticketsUsuarios ) {
        this.ticketsUsuarios = ticketsUsuarios;
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
    
    public void puntosPorRonda( int aciertos ){
        this.puntosTotales += aciertos;
    }
    
    @Override
    public String toString() {
        return "Usuario { " + "dni = " + dni + ", nombre = " + nombre + "}";
    }
}