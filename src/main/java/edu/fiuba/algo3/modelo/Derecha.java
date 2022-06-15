package edu.fiuba.algo3.modelo;

public class Derecha extends Direccion{
    public Posicion calcularPosicionSiguiente(Posicion pos){
        pos.sumarX();
        return pos;
    }

    public Direccion opuesto(){
        return new Izquierda();
    }
}