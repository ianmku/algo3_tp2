package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Auto extends Vehiculo {

    public Auto(Mapa mapa){
        super(mapa);
    }

    public void atravesarPozo(){
        this.cantidadDeMovimientos += 3;
    }

    public void atravesarPiquete() {
        this.mapa.moverVehiculo(this, this.direccion.opuesto());
    }

    public void atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.5) this.cantidadDeMovimientos += 3;
    }

}
