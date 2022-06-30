package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Juego.Juego;

public class VehiculoControlador {

    public void terminarPartida() {
        Juego.getInstance().terminarPartida();
        Juego.getInstance().notifyObservers();
    }
}
