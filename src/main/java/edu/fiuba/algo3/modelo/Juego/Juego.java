package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import edu.fiuba.algo3.modelo.Vehiculos.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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

    public void crearJugador(String nombre, Tipo tipo, Mapa mapa) {
        this.jugadorActual = new Jugador(nombre, new Vehiculo(mapa, tipo));

        this.estado = "INICIAR_PARTIDA";
        setChanged();
    }
    public void mostrarRanking() {
        this.estado = "MOSTRAR_RANKING";
        setChanged();
    }
    public void terminarPartida(){
        this.jugadores.add(this.jugadorActual);
        this.estado = "PARTIDA_TERMINADA";
        setChanged();
    }

    public Posicion posicionDeLlegada(){
        return jugadorActual.posicionDeLlegada();
    }

    public Mapa getMapaActual(){
        return jugadorActual.obtenerMapaActual();
    }
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
    public int getAnchoMapa(){
        return this.jugadorActual.getAnchoMapa();
    }
    public int getAltoMapa(){
        return this.jugadorActual.getAltoMapa();
    }

}
