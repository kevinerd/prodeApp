package com.kevinjf.prodeapp.entidades;

import com.kevinjf.prodeapp.enumeracion.ResultadoEnum;
import java.util.Objects;

public class Partido {
    private Integer idPartido;
    private Integer fase;
    private Integer ronda;
    private Integer numPartido;
    private Equipo equipo1;
    private Integer golesEquipo1;
    private Integer golesEquipo2;
    private Equipo equipo2;

    public Partido() {
    }

    public Partido( Integer idPartido, Integer fase, Integer ronda, Equipo equipo1, Integer golesEquipo1, Integer golesEquipo2, Equipo equipo2 ) {
        this.idPartido = idPartido;
        this.fase = fase;
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.equipo2 = equipo2;
    }
    
    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido( Integer idPartido ) {
        this.idPartido = idPartido;
    }

    public Integer getFase() {
        return fase;
    }

    public void setFase( Integer fase ) {
        this.fase = fase;
    }

    public Integer getRonda() {
        return ronda;
    }

    public void setRonda( Integer ronda ) {
        this.ronda = ronda;
    }

    public Integer getNumPartido() {
        return numPartido;
    }

    public void setNumPartido( Integer numPartido ) {
        this.numPartido = numPartido;
    }
    
    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1( Equipo equipo1 ) {
        this.equipo1 = equipo1;
    }

    public Integer getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1( Integer golesEquipo1 ) {
        this.golesEquipo1 = golesEquipo1;
    }

    public Integer getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2( Integer golesEquipo2 ) {
        this.golesEquipo2 = golesEquipo2;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2( Equipo equipo2 ) {
        this.equipo2 = equipo2;
    }
    
    // PROCESO EL RESULTADO DE CADA PARTIDO PARA SABER QUIÉN GANÓ
    public ResultadoEnum resultadoPartido() { 
        ResultadoEnum resultadoPartido = null;
        if (golesEquipo1 > golesEquipo2) {
            resultadoPartido = ResultadoEnum.GANA;
        }
        if (golesEquipo1 < golesEquipo2) {
            resultadoPartido = ResultadoEnum.PIERDE;
        }
        if (Objects.equals(golesEquipo1, golesEquipo2)) {
            resultadoPartido = ResultadoEnum.EMPATE;
        }
        return resultadoPartido;
    }
    
    @Override
    public String toString() {
        return "[ Partido = "+idPartido+" "+equipo1.getNombreEquipo()
        +" = "+golesEquipo1+" - "+golesEquipo2+" = "+equipo2.getNombreEquipo()+" ]";
    }
}

