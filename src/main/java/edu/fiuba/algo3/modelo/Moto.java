package edu.fiuba.algo3.modelo;

public class Moto extends Vehiculo {
    public Moto(Posicion pos){
        this.pos = pos;
        this.cantidadDeMovimientos = 0;
    }

    public void mover(Direccion dir){
        this.pos = dir.calcularPosicionSiguiente(this.pos);
        this.cantidadDeMovimientos++;
    }

    public void atravesarPozo(){
        this.cantidadDeMovimientos += 3;
    }


}
