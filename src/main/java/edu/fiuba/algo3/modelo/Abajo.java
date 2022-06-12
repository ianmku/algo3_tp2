package edu.fiuba.algo3.modelo;

public class Abajo extends Direccion{
    public Posicion calcularPosicionSiguiente(Posicion pos){
        return new Posicion(pos.getPosicionX(), pos.getPosicionY()-1);
    }
}
