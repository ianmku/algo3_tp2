package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Auto extends Vehiculo {

    Posicion ultimaPosicion;
    public Auto(Mapa mapa){
        this.mapa = mapa;
        this.cantidadDeMovimientos = 0;
        this.direccion = new Derecha();
    }

    public void atravesarPozo(){
        this.cantidadDeMovimientos += 3;
    }

    public void atravesarPiquete() {
        this.mapa.cambiarPosicionVehiculo(this, this.direccion.opuesto());
    }

    public void atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.5) this.cantidadDeMovimientos += 3;
    }

}
