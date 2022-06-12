package edu.fiuba.algo3.modelo;

public class Izquierda extends Direccion{
    public Posicion calcularPosicionSiguiente(Posicion pos){
        return new Posicion(pos.getPosicionX()-1, pos.getPosicionY());
    }
}