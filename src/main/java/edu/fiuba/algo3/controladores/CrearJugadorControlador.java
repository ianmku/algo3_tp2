package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Vehiculos.Tipo;

public class CrearJugadorControlador {

    public void iniciarPartida(String nombre, Tipo tipo, Mapa mapa) {
        Juego.getInstance().crearJugador(nombre, tipo, mapa);
        Juego.getInstance().notifyObservers();
    }
}
