package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Juego.Juego;

public class RankingControlador {

    public void volverAlMenu() {
        Juego.getInstance().iniciarMenu();
        Juego.getInstance().notifyObservers();
    }
}
