package com.kevinjf.prodeapp.entidades;

import java.util.HashMap;

public class Torneo {
    
    private HashMap<Integer, Ronda> partidos;
    private final int TOTAL_RONDAS = 4;
    private HashMap <String, Equipo> equiposHashMap;

    public Torneo() {
        this.partidos = new HashMap<>();
        this.equiposHashMap = new HashMap<>();
    }

    public HashMap<Integer, Ronda> getPartidos() {
        return partidos;
    }

    public void setPartidos( HashMap<Integer, Ronda> partidos ) {
        this.partidos = partidos;
    }

    public HashMap<String, Equipo> getEquiposHashMap() {
        return equiposHashMap;
    }

    public void setEquiposHashMap(HashMap<String, Equipo> equiposHashMap) {
        this.equiposHashMap = equiposHashMap;
    }

    // Metodo privado que recibe como argumento un String que es valor clave para buscar en esquiposHashMap. 
    // Devuelve un objeto del tipo Equipo.
    public Equipo buscarEquipo(String equipoKey){
        Equipo equipoBuscado = new Equipo();
        equipoBuscado = this.equiposHashMap.get(equipoKey);
        return equipoBuscado;
    }
    
    public Ronda buscarRonda(int rondaKey){
        return this.partidos.get(rondaKey);
    }
    
    public int getTOTAL_RONDAS() {
        return TOTAL_RONDAS;
    }
}
