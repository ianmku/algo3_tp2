package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    protected int cantidadDeMovimientos;
    protected Mapa mapa;
    protected Direccion direccion;

    public void mover(Direccion dir) {
        this.direccion = dir;
        mapa.cambiarPosicionVehiculo(this,dir);
        this.cantidadDeMovimientos++;
    }

    public abstract void atravesarPozo();

    public abstract void atravesarPiquete();

    public abstract void atravesarControlPolicial();

    public int getMovimientos(){
        return cantidadDeMovimientos;
    }

    public Posicion getPosicion(){
        return this.mapa.getPosicionDelVehiculo();
    }
}
