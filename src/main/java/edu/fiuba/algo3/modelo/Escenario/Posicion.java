package edu.fiuba.algo3.modelo.Escenario;

import java.util.Objects;

public class Posicion {
    private int posicionX;
    private int posicionY;

    public Posicion (int coordenadaX, int coordenadaY) {
        this.posicionX = coordenadaX;
        this.posicionY = coordenadaY;
    }

    public void sumarX(){
        this.posicionX++;
    }

    public void restarX(){
        this.posicionX--;
    }

    public void sumarY() {
        this.posicionY++;
    }

    public void restarY() {
        this.posicionY--;
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

    public void imprimirPosicion(){
        System.out.println(this.posicionX + "," + this.posicionY);
    }



}
