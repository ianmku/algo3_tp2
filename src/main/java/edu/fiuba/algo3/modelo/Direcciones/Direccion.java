package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public interface Direccion {

    void calcularPosicionSiguiente(Posicion pos);
    Direccion opuesto();
}