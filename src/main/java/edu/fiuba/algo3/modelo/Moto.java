package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Moto extends Vehiculo {

    public Moto(Mapa mapa){
        this.mapa = mapa;
        this.cantidadDeMovimientos = 0;
        this.direccion = new Derecha();
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
