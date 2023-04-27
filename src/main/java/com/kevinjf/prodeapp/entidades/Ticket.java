package com.kevinjf.prodeapp.entidades;

import com.kevinjf.prodeapp.enumeracion.ResultadoEnum;

public class Ticket {
    private int id;
    private Usuario user;
    private Partido partido;
    private ResultadoEnum pronostico;

    public Ticket() {
    }

    public Ticket( int id, Usuario user, Partido partido, ResultadoEnum pronostico ) {
        this.id = id;
        this.user = user;
        this.partido = partido;
        this.pronostico = pronostico;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser( Usuario user ) {
        this.user = user;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido( Partido partido ) {
        this.partido = partido;
    }

    public ResultadoEnum getPronostico() {
        return pronostico;
    }

    public void setPronostico( ResultadoEnum pronostico ) {
        this.pronostico = pronostico;
    }

    @Override
    public String toString() {
        return "Ticket { " + "id = " + id + " " + user + " " + partido + ", pronostico = " + pronostico + " }";
    }
}