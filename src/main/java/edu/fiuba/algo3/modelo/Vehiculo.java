package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    protected int cantidadDeMovimientos;
    protected Posicion pos;

    public void mover(Mapa mapa, Direccion dir) {
        this.pos = dir.calcularPosicionSiguiente(this.pos);
        mapa.atravesarObstaculo(this);
        this.pos = dir.calcularPosicionSiguiente(this.pos);
        this.cantidadDeMovimientos++;
    }

    public abstract void atravesarPozo();

    public abstract void atravesarPiquete();

    public abstract void atravesarControlPolicial();

    public int getMovimientos(){
        return cantidadDeMovimientos;
    }

    public Posicion getPosicion() {
        return pos;
    }
}
