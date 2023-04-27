package com.kevinjf.prodeapp.entidades;

public class Partido {
    private int id;
    private int numFase;
    private int numRonda;
    private Equipo equipo1;
    private int golesEq1;
    private int golesEq2;
    private Equipo equipo2;

    public Partido() {
    }

    public Partido( int id, int numFase, int numRonda, Equipo equipo1, int golesEquipo1, int golesEquipo2, Equipo equipo2 ) {
        this.id = id;
        this.numFase = numFase;
        this.numRonda = numRonda;
        this.equipo1 = equipo1;
        this.golesEq1 = golesEquipo1;
        this.golesEq2 = golesEquipo2;
        this.equipo2 = equipo2;
    }
    
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getNumFase() {
        return numFase;
    }

    public void setNumFase( int numFase ) {
        this.numFase = numFase;
    }

    public int getNumRonda() {
        return numRonda;
    }

    public void setNumRonda( int numRonda ) {
        this.numRonda = numRonda;
    }
    
    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1( Equipo equipo1 ) {
        this.equipo1 = equipo1;
    }

    public int getGolesEq1() {
        return golesEq1;
    }

    public void setGolesEq1( int golesEquipo1 ) {
        this.golesEq1 = golesEquipo1;
    }

    public int getGolesEq2() {
        return golesEq2;
    }

    public void setGolesEq2( int golesEq2 ) {
        this.golesEq2 = golesEq2;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2( Equipo equipo2 ) {
        this.equipo2 = equipo2;
    }
    
    @Override
    public String toString() {
        return "[ Partido = "+id+" "+equipo1.getNombreEquipo()
        +" = "+golesEq1+" - "+golesEq2+" = "+equipo2.getNombreEquipo()+" ]";
    }
}