package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public class Abajo implements Direccion {
    public void calcularPosicionSiguiente(Posicion pos){
        pos.restarY();
    }

    public Direccion opuesto(){
        return new Arriba();
    }
}