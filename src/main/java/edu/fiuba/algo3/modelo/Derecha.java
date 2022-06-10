package edu.fiuba.algo3.modelo;

public class Derecha extends Direccion{
    public Posicion calcularPosicionSiguiente(Posicion pos){
        return new Posicion(pos.getPosicionX()+1, pos.getPosicionY());
    }
}