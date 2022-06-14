package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Cpc extends Vehiculo {

    private int cantidadDePozosAtravesados;
    public Cpc(Mapa mapa){
        this.mapa = mapa;
        this.cantidadDeMovimientos = 0;
        this.direccion = new Derecha();
    }


    public void atravesarPozo(){
        this.cantidadDePozosAtravesados++;
        if((this.cantidadDePozosAtravesados % 3) == 0){
            this.cantidadDeMovimientos += 2;
        }
    }

    public void atravesarPiquete() {
        this.mapa.cambiarPosicionVehiculo(this, this.direccion.opuesto());
    }

    public void atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.3) this.cantidadDeMovimientos += 3;
    }
}
