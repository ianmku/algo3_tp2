package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Interactuables.Interactuable;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import static edu.fiuba.algo3.modelo.Escenario.TamanioMapa.*;

public class Juego extends Observable {

    private static Juego instance;
    private List<Jugador> jugadores;

    private String estado;

    public Juego(){
        this.jugadores = new ArrayList<>();
        this.estado = "MENU";
    }

    public void menu(){

        boolean salir = false;

        while(!salir){

            Scanner scanner = new Scanner(System.in);
            System.out.println("J (Jugar), R (Ranking) ");
            String opcionElegida = scanner.nextLine();

            switch(opcionElegida){
                case "j":
                case "J":
                    iniciarPartida();
                    break;
                case "r":
                case "R":
                    mostrarRanking();
                    break;
                case "e":
                case "E":
                    salir = true;
                    break;
            }
        }
    }

    public static Juego getInstance() {
        if (instance == null) instance = new Juego();
        return instance;
    }

    public void moverVehiculo(Direccion direccion, Jugador jugador){
        jugador.moverVehiculo(direccion);
    }

    public void iniciarPartida(){

        Jugador unJugador = pedirInformacionDelUsuario();

        while(!unJugador.ganoPartida()){
           Direccion direccion = this.pedirDireccion();
           moverVehiculo(direccion, unJugador);
        }

        this.terminarPartida(unJugador);
    }

    public void terminarPartida(Jugador unJugador){
        this.jugadores.add(unJugador);
        System.out.println("Cantidad de movimientos: " + unJugador.obtenerCantidadMovimientos());
    }

    public void mostrarRanking() {
        this.estado = "MOSTRAR_RANKING";
        setChanged();
//        for(Jugador j: jugadores){
//            j.mostrarRanking();
//        }
    }

    public String obtenerEstado() {
        return this.estado;
    }

    public List<Jugador> obtenerJugadores() {
        return this.jugadores;
    }

    public Direccion pedirDireccion(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige una direccion: (W, A, S, D) ");
        String opcionElegida = scanner.nextLine();
        Direccion direccion = new Izquierda();

        switch(opcionElegida){
            case "w":
            case "W":
                direccion =  new Arriba();
                break;
            case "a":
            case "A":
                direccion =  new Izquierda();
                break;
            case "s":
            case "S":
                direccion =  new Abajo();
                break;
            case "d":
            case "D":
                direccion =  new Derecha();
                break;
        }
        return direccion;
    }

    public Vehiculo obtenerVehiculoElegido(Mapa unMapa){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige un vehiculo: (A, M, C) ");
        String opcionElegida = scanner.nextLine();
        Vehiculo vehiculo = new Vehiculo(unMapa, new Auto());

        switch(opcionElegida){
            case "a":
            case "A":
                vehiculo = new Vehiculo(unMapa, new Auto());
            case "m":
            case "M":
                vehiculo = new Vehiculo(unMapa, new Moto());
            case "c":
            case "C":
                vehiculo = new Vehiculo(unMapa, new Camioneta());
        }
        return vehiculo;
    }
    public Jugador pedirInformacionDelUsuario(){

        Mapa unMapa = new Mapa(CHICO, new Aleatorio());
        System.out.println("Inserte su nombre: ");
        Scanner scanner = new Scanner(System.in);
        String nombreDelJugador = scanner.nextLine();

        Vehiculo vehiculoDelJugador = obtenerVehiculoElegido(unMapa);

        Jugador unJugador = new Jugador(nombreDelJugador, vehiculoDelJugador);

        return unJugador;
    }
}
