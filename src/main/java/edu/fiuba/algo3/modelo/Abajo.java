package edu.fiuba.algo3.modelo;

public class Abajo extends Direccion {
    public Posicion calcularPosicionSiguiente(Posicion pos){
        pos.restarY();
        return pos;
    }

    public Direccion opuesto(){
        return new Arriba();
    }
}
