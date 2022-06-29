package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Interactuables.Interactuable;
import edu.fiuba.algo3.modelo.Vehiculos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import static edu.fiuba.algo3.modelo.Escenario.TamanioMapa.*;

public class Juego extends Observable {

    private static Juego instance;
    private List<Jugador> jugadores;
    private Jugador jugadorActual;
    private String estado;

    public Juego(){
        this.jugadores = new ArrayList<>();
        this.estado = "MENU";

    }
    public void iniciarMenu() {
        this.estado = "MENU";
        setChanged();
    }
    public void iniciarLobby(){
        this.estado = "INICIAR_LOBBY";
        setChanged();
    }

    public int getAnchoMapa(){
        return this.jugadorActual.getAnchoMapa();
    }

    public int getAltoMapa(){
        return this.jugadorActual.getAltoMapa();
    }
    public void crearJugador(String nombre, Tipo tipo, Mapa mapa) {
        this.jugadorActual = new Jugador(nombre, new Vehiculo(mapa, tipo));

        this.estado = "INICIAR_PARTIDA";

        setChanged();

        /*while(!this.jugadorActual.ganoPartida()){
            Direccion direccion = this.pedirDireccion();
            moverVehiculo(direccion, this.jugadorActual);
        }
        this.terminarPartida();*/

    }
    public void mostrarRanking() {
        this.estado = "MOSTRAR_RANKING";
        setChanged();
    }
    public void terminarPartida(){
        this.jugadores.add(this.jugadorActual);
        System.out.println("Cantidad de movimientos: " + this.jugadorActual.obtenerCantidadMovimientos());
        this.estado = "PARTIDA_TERMINADA";
        setChanged();
    }

    public Posicion posicionDeLlegada(){
        return jugadorActual.posicionDeLlegada();
    }

//    public void menu(){
//
//        boolean salir = false;
//
//        while(!salir){
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("J (Jugar), R (Ranking) ");
//            String opcionElegida = scanner.nextLine();
//
//            switch(opcionElegida){
//                case "j":
//                case "J":
//                    iniciarLobby();
//                    break;
//                case "r":
//                case "R":
//                    mostrarRanking();
//                    break;
//                case "e":
//                case "E":
//                    salir = true;
//                    break;
//            }
//        }
//    }

    public static Juego getInstance() {
        if (instance == null) instance = new Juego();
        return instance;
    }
    public void moverVehiculo(Direccion direccion, Jugador jugador){
        jugador.moverVehiculo(direccion);
    }

    public String obtenerEstado() {
        return this.estado;
    }

    public List<Jugador> obtenerJugadores() {
        return this.jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
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

//    public Vehiculo obtenerVehiculoElegido(Mapa unMapa){
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Elige un vehiculo: (A, M, C) ");
//        String opcionElegida = scanner.nextLine();
//        Vehiculo vehiculo = new Vehiculo(unMapa, new Auto());
//
//        switch(opcionElegida){
//            case "a":
//            case "A":
//                vehiculo = new Vehiculo(unMapa, new Auto());
//            case "m":
//            case "M":
//                vehiculo = new Vehiculo(unMapa, new Moto());
//            case "c":
//            case "C":
//                vehiculo = new Vehiculo(unMapa, new Camioneta());
//        }
//        return vehiculo;
//    }
//    public Jugador pedirInformacionDelUsuario(){
//
//        Mapa unMapa = new Mapa(CHICO, new Aleatorio());
//        System.out.println("Inserte su nombre: ");
//        Scanner scanner = new Scanner(System.in);
//        String nombreDelJugador = scanner.nextLine();
//
//        Vehiculo vehiculoDelJugador = obtenerVehiculoElegido(unMapa);
//
//        Jugador unJugador = new Jugador(nombreDelJugador, vehiculoDelJugador);
//
//        return unJugador;
//    }
}
