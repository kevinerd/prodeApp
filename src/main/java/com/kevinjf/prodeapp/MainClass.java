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
        ConexionDB.getUsuarios( prode.getUsuariosHashMap() );
        
        // Busco los equipos
        ConexionDB.getEquipos( torneo.getEquiposHashMap() );
        
        // Busco los partidos
        ConexionDB.getPartidos( torneo, torneo.getPartidos() );
        
        // Busco los pronósticos
        ConexionDB.getTickets( prode.getUsuariosHashMap(), torneo );
        
        // Busco los tickets
        prode.mostrarTickets();
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        
        // Calculo los aciertos y busco el usuario ganador
        prode.calcularPuntaje( torneo );
        System.out.println("-------------------------");
        
        // Muestro la tabla de posiciones de los usuarios -- NO FUNCIONA BIEN
        prode.listaPosicionesUsuarios();
        
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("GRACIAS POR USAR PRODE APP");
        System.out.println("-------------------------");
        System.out.println("DESARROLLADO POR KEVIN J. H. FIRMANI");
    }
}
