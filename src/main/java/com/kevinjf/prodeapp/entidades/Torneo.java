package com.kevinjf.prodeapp.entidades;

import java.util.ArrayList;
import java.util.HashMap;

public class Torneo {
    private HashMap <Integer, Equipo> equiposHashMap;
    private HashMap<Integer, Ronda> partidos;
    private ArrayList<Partido> fase1 = new ArrayList();
    private ArrayList<Partido> fase2 = new ArrayList();
//    private final int TOTAL_RONDAS = 4;
    

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

    public HashMap<Integer, Equipo> getEquiposHashMap() {
        return equiposHashMap;
    }

    public void setEquiposHashMap(HashMap<Integer, Equipo> equiposHashMap) {
        this.equiposHashMap = equiposHashMap;
    }

    public ArrayList<Partido> getFase1() {
        return fase1;
    }

    public void setFase1(ArrayList<Partido> fase1) {
        this.fase1 = fase1;
    }

    public ArrayList<Partido> getFase2() {
        return fase2;
    }

    public void setFase2(ArrayList<Partido> fase2) {
        this.fase2 = fase2;
    }
    
    

    // Metodo privado que recibe como argumento un Integer que es valor clave para buscar en esquiposHashMap. 
    // Devuelve un objeto del tipo Equipo.
    public Equipo buscarEquipo(Integer equipoKey){
        Equipo equipoBuscado = new Equipo();
        equipoBuscado = this.equiposHashMap.get(equipoKey);
        return equipoBuscado;
    }
    
    public Ronda buscarRonda(int rondaKey){
        return this.partidos.get(rondaKey);
    }
    
//    public int getTOTAL_RONDAS() {
//        return TOTAL_RONDAS;
//    }
}
