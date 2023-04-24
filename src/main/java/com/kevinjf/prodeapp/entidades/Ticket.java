package com.kevinjf.prodeapp.entidades;

import com.kevinjf.prodeapp.enumeracion.ResultadoEnum;

public class Ticket {
    private int idPartido;
    private int equipoGanador;
    private ResultadoEnum pronostico;

    public Ticket(int idPartido, int equipoGanador, ResultadoEnum pronostico) {
        this.idPartido = idPartido;
        this.equipoGanador = equipoGanador;
        this.pronostico = pronostico;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(int equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public ResultadoEnum getPronostico() {
        return pronostico;
    }

    public void setPronostico(ResultadoEnum pronostico) {
        this.pronostico = pronostico;
    }

    @Override
    public String toString() {
        return "Ticket { " + "idPartido = " + idPartido + ", pronóstico = " + pronostico + " }";
    }
}
