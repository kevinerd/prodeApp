package com.kevinjf.prodeapp.entidades;

import java.util.HashMap;

public class Ronda {
    private Integer numeroRonda;
    
    private HashMap<Integer, Partido> rondaHashMap;

    public Ronda( Integer numeroRonda, HashMap<Integer, Partido> rondaHashMap ) {
        System.out.println("NUMERO RONDA: " + numeroRonda);
        System.out.println("numeroRonda.String: " + rondaHashMap.toString());
        this.numeroRonda = numeroRonda;
        this.rondaHashMap = rondaHashMap;
    }

    public Ronda( Integer numeroRonda ) {
        this.numeroRonda = numeroRonda;
        this.rondaHashMap = new HashMap<>();
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda( Integer numeroRonda ) {
        System.out.println("SET NUMERO RONDA: " + numeroRonda);
        this.numeroRonda = numeroRonda;
    }

    public HashMap<Integer, Partido> getRondaHashMap() {
        return rondaHashMap;
    }

    public void setRondaHashMap( HashMap<Integer, Partido> rondaHashMap ) {
        this.rondaHashMap = rondaHashMap;
    }
    
    public Partido getPartido( Integer idPartido ) {
        Partido partido;
        partido = this.rondaHashMap.get( idPartido );
        return partido;
    }
    
    @Override
    public String toString() {
        return "Ronda{" + "numeroRonda=" + numeroRonda + ", rondaHashMap=" + rondaHashMap + '}';
    }
}