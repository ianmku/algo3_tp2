package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Direcciones.Abajo;
import edu.fiuba.algo3.modelo.Direcciones.Arriba;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vistas.VehiculoVista;
import javafx.scene.layout.GridPane;

public class MapaControlador {

    public void moverDerecha(){
        Juego.getInstance().moverVehiculo(new Derecha());
        Juego.getInstance().notifyObservers();
    }

    public void moverIzquierda(){
        Juego.getInstance().moverVehiculo(new Izquierda());
        Juego.getInstance().notifyObservers();
    }

    public void moverArriba(){
        Juego.getInstance().moverVehiculo(new Arriba());
        Juego.getInstance().notifyObservers();
    }

    public void moverAbajo(){
        Juego.getInstance().moverVehiculo(new Abajo());
        Juego.getInstance().notifyObservers();
    }
}
