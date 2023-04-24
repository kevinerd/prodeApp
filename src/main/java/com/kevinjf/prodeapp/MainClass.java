package com.kevinjf.prodeapp;

import com.kevinjf.prodeapp.entidades.Prode;
import com.kevinjf.prodeapp.entidades.Torneo;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class MainClass {
    public static void main( String[] args ) throws IOException, SQLException, URISyntaxException {
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("BIENVENIDOS A PRODE APP");
        System.out.println("-------------------------");
        System.out.println("INICIANDO EL PROGRAMA");
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        
        // Inicializo una instancia de Torneo y otra de Prode
        Torneo torneo = new Torneo();
        Prode prode = new Prode();
        
        // Conecto la base de datos
        ConexionDB.configDb();
        System.out.println("BASE DE DATOS CONECTADA!");
        System.out.println("-------------------------");
        
        // Busco los usuarios
        ConexionDB.getUsuarios( prode.getUsuarios() );
        
        // Busco los equipos
        ConexionDB.getEquipos( torneo.getEquiposHashMap() );
        
        // Busco los partidos
        ConexionDB.getPartidos( torneo );
        
        // Busco los pronósticos
        ConexionDB.getPronosticos( prode.getUsuarios() );
        
        // Busco
        prode.mostrarCargaApuestas();
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        
        // Calculo los aciertos
        prode.mostrarAciertos( torneo );
        System.out.println("-------------------------");
        
        // Busco el usuario con más aciertos
        prode.usuarioGanador();
        
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("GRACIAS POR USAR PRODE APP");
        System.out.println("-------------------------");
    }
}
