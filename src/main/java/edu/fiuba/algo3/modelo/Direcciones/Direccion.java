package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public abstract class Direccion {

    public abstract void calcularPosicionSiguiente(Posicion pos);
    public abstract Direccion opuesto();
}