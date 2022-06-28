package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Juego.Juego;

public class GPSChallengeControlador {

    public void iniciarPartida() {
        Juego.getInstance().iniciarPartida();
        Juego.getInstance().notifyObservers();
    }

    public void mostrarRanking() {
        Juego.getInstance().mostrarRanking();
        Juego.getInstance().notifyObservers();
    }
}
