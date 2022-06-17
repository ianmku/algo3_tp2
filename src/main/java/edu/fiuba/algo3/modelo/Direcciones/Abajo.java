package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public class Abajo extends Direccion {
    public Posicion calcularPosicionSiguiente(Posicion pos){
        pos.restarY();
        return pos;
    }

    public Direccion opuesto(){
        return new Arriba();
    }
}