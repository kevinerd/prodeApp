package com.kevinjf.prodeapp.entidades;

import java.util.ArrayList;
import java.util.HashMap;

public class Torneo {
    private HashMap <Integer, Equipo> equiposHashMap;
    private HashMap<Integer, Partido> partidosHashMap;
    private ArrayList<Partido> fase1 = new ArrayList();
    private ArrayList<Partido> fase2 = new ArrayList();

    public Torneo() {
        this.partidosHashMap = new HashMap<>();
        this.equiposHashMap = new HashMap<>();
    }

    public HashMap<Integer, Partido> getPartidos() {
        return partidosHashMap;
    }

    public void setPartidos( HashMap<Integer, Partido> partidos ) {
        this.partidosHashMap = partidos;
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

    // Metodo que recibe como argumento un Integer que es valor clave para buscar en esquiposHashMap. 
    // Devuelve un objeto del tipo Equipo.
    public Equipo buscarEquipo( int equipoKey ) {
        Equipo equipoBuscado = new Equipo();
        equipoBuscado = this.equiposHashMap.get(equipoKey);
        return equipoBuscado;
    }
    
    // Metodo que recibe como argumento un Integer que es valor clave para buscar en partidosHashMap. 
    // Devuelve un objeto del tipo Partido.
    public Partido buscarPartido( int partidoKey ) {
        Partido partidoBuscado = new Partido();
        partidoBuscado = this.partidosHashMap.get( partidoKey );
        return partidoBuscado;
    }
}