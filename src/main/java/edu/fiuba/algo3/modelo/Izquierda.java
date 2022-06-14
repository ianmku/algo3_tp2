package edu.fiuba.algo3.modelo;

public class Izquierda extends Direccion {
    public Posicion calcularPosicionSiguiente(Posicion pos){
        pos.restarX();
        return pos;
    }

    public Direccion opuesto(){
        return new Derecha();
    }
}
