package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Posicion {
    int posicionX;
    int posicionY;

    public Posicion (int coordenadaX, int coordenadaY) {
        this.posicionX = coordenadaX;
        this.posicionY = coordenadaY;
    }

    /*public obtenerPosicion() {
        return (posicionX, posicionY);
    }*/

    public int getPosicionX(){
        return this.posicionX;
    }

    public int getPosicionY(){
        return this.posicionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return posicionX == posicion.posicionX && posicionY == posicion.posicionY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicionX, posicionY);
    }
}
