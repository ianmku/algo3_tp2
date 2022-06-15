package edu.fiuba.algo3.modelo;

public abstract class Direccion {

    public abstract Posicion calcularPosicionSiguiente(Posicion pos);
    public abstract Direccion opuesto();
}