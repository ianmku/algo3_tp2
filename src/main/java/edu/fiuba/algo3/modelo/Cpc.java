package edu.fiuba.algo3.modelo;

public class Cpc extends Vehiculo {
    private int cantidadDePozosAtravesados;
    public Cpc(Posicion pos){
        this.pos = pos;
        this.cantidadDeMovimientos = 0;
    }
    public void mover(Direccion dir){
        this.pos = dir.calcularPosicionSiguiente(this.pos);
        this.cantidadDeMovimientos++;
    }
    public void atravesarPozo(){
        this.cantidadDePozosAtravesados++;
        if((this.cantidadDePozosAtravesados % 3) == 0){
            this.cantidadDeMovimientos += 2;
        }
    }
}
