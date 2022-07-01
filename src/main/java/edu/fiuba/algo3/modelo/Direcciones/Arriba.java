package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public class Arriba implements Direccion{
    public void calcularPosicionSiguiente(Posicion pos){
        pos.sumarY();
    }

    public Direccion opuesto(){
        return new Abajo();
    }
}