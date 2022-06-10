package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Moto extends Vehiculo {

    public Moto(Posicion pos){
        this.pos = pos;
        this.cantidadDeMovimientos = 0;
    }

    public void atravesarPozo(){
        this.cantidadDeMovimientos += 3;
    }

    public void atravesarPiquete(){
        this.cantidadDeMovimientos += 2;
    }

    public void atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.8) this.cantidadDeMovimientos += 3;
    }
}
