package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Cpc extends Vehiculo {

    Posicion ultimaPosicion;
    private int cantidadDePozosAtravesados;
    public Cpc(Posicion pos){
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
        this.cantidadDePozosAtravesados++;
        if((this.cantidadDePozosAtravesados % 3) == 0){
            this.cantidadDeMovimientos += 2;
        }
    }

    public void atravesarPiquete() {
        pos = ultimaPosicion;
    }

    public void atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.3) this.cantidadDeMovimientos += 3;
    }
}
