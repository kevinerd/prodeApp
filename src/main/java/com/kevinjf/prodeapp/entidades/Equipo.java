package com.kevinjf.prodeapp.entidades;

public class Equipo {
    private String nombreEquipo;
    private int partidosJugados; 
    
    public Equipo() {
    }
    
    public Equipo( String nombreEquipo, int partidosJugados ) {
        this.nombreEquipo = nombreEquipo;
        this.partidosJugados = partidosJugados;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo( String nombreEquipo ) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados( int partidosJugados ) {
        this.partidosJugados = partidosJugados;
    }
    
    @Override
    public String toString() {
        return "Equipo {" + " nombreEquipo = " + nombreEquipo + ", partidosJugados = " + partidosJugados + " }";
    }
}

