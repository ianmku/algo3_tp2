package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Auto extends Vehiculo {

    Posicion ultimaPosicion;
    public Auto(Posicion pos){
        this.pos = pos;
        this.cantidadDeMovimientos = 0;
    }

    @Override
    public void mover(Mapa mapa, Direccion dir) {
        ultimaPosicion = this.pos;
        this.pos = dir.calcularPosicionSiguiente(this.pos);
        mapa.atravesarObstaculo(this);
        if(pos != ultimaPosicion) this.pos = dir.calcularPosicionSiguiente(this.pos);
        this.cantidadDeMovimientos++;
    }
    public void atravesarPozo(){
        this.cantidadDeMovimientos += 3;
    }

    public void atravesarPiquete() {
        pos = ultimaPosicion;
    }

    public void atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.5) this.cantidadDeMovimientos += 3;
    }

}
