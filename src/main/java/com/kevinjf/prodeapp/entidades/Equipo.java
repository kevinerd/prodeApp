package com.kevinjf.prodeapp.entidades;

public class Equipo {
    private int id;
    private String nombreEquipo;
    
    public Equipo() {
    }

    public Equipo( int id, String nombreEquipo ) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }
    
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    
    public void setNombreEquipo( String nombreEquipo ) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public String toString() {
        return "Equipo { " + "id = " + id + ", nombre del Equipo = " + nombreEquipo + " }";
    }
}