package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Juego.Juego;

public class VictoriaControlador {

    public void verRankings() {
        Juego.getInstance().mostrarRanking();
        Juego.getInstance().notifyObservers();
    }

    public void volverAlMenu() {
        Juego.getInstance().iniciarMenu();
        Juego.getInstance().notifyObservers();
    }
}
