package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Direcciones.Abajo;
import edu.fiuba.algo3.modelo.Direcciones.Arriba;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Izquierda;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vistas.VehiculoVista;

public class MapaControlador {

    public MapaControlador(){

    }

    public void moverDerecha(VehiculoVista vv){
        Juego.getInstance().moverVehiculo(new Derecha(), Juego.getInstance().getJugadorActual());
        vv.moverDerecha();
        Juego.getInstance().notifyObservers();
    }

    public void moverIzquierda(VehiculoVista vv){
        Juego.getInstance().moverVehiculo(new Izquierda(), Juego.getInstance().getJugadorActual());
        vv.moverIzquierda();
        Juego.getInstance().notifyObservers();
    }

    public void moverArriba(VehiculoVista vv){
        Juego.getInstance().moverVehiculo(new Arriba(), Juego.getInstance().getJugadorActual());
        vv.moverArriba();
        Juego.getInstance().notifyObservers();
    }

    public void moverAbajo(VehiculoVista vv){
        Juego.getInstance().moverVehiculo(new Abajo(), Juego.getInstance().getJugadorActual());
        vv.moverAbajo();
        Juego.getInstance().notifyObservers();
    }
}
