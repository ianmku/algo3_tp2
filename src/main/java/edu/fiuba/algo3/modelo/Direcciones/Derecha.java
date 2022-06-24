package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public class Derecha extends Direccion{
    public void calcularPosicionSiguiente(Posicion pos){
        pos.sumarX();
    }

    public Direccion opuesto(){
        return new Izquierda();
    }
}