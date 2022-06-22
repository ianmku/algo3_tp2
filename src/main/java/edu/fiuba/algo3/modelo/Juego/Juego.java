package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.fiuba.algo3.modelo.Escenario.TamanioMapa.MEDIANO;

public class Juego {

    private List<Jugador> jugadores;

    public Juego(){
        this.jugadores = new ArrayList<>();
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
                    break;
                case "e":
                case "E":
                    salir = true;
                    break;
            }
        }
    }

    public void iniciarPartida(){

        Jugador unJugador = pedirInformacionDelUsuario();

        while(!unJugador.ganoPartida()){
            Direccion direccion = this.pedirDireccion();
            unJugador.moverVehiculo(direccion);
            unJugador.mostrarPosicion();
        }

        this.terminarPartida(unJugador);
    }

    public void terminarPartida(Jugador unJugador){
        this.jugadores.add(unJugador);
        System.out.println("Cantidad de movimientos: " + unJugador.obtenerCantidadMovimientos());
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

        Mapa unMapa = new Mapa(MEDIANO);
        System.out.println("Inserte su nombre: ");
        Scanner scanner = new Scanner(System.in);
        String nombreDelJugador = scanner.nextLine();

        Vehiculo vehiculoDelJugador = obtenerVehiculoElegido(unMapa);

        Jugador unJugador = new Jugador(nombreDelJugador, vehiculoDelJugador);

        return unJugador;
    }
}
