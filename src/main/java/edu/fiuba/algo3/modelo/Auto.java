package edu.fiuba.algo3.modelo;

public class Auto extends Vehiculo {
    public Auto(Posicion pos){
        this.pos = pos;
        this.cantidadDeMovimientos = 0;
    }
    public void mover(){

    }
    public void atravesarPozo(){
        this.cantidadDeMovimientos += 3;
    }

}
