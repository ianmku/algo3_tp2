package edu.fiuba.algo3.modelo;

public class Arriba extends Direccion{
    public Posicion calcularPosicionSiguiente(Posicion pos){
        return new Posicion(pos.getPosicionX(), pos.getPosicionY()+1);
    }
}
