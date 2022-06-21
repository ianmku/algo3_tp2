package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public class Derecha extends Direccion{
    public Posicion calcularPosicionSiguiente(Posicion pos){
        pos.sumarX();
        return pos;
    }

    public Direccion opuesto(){
        return new Izquierda();
    }
}