package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    protected int cantidadDeMovimientos;
    protected Mapa mapa;
    protected Direccion direccion;

    public Vehiculo(Mapa mapa) {
        this.mapa = mapa;
        this.cantidadDeMovimientos = 0;
        this.direccion = new Derecha();
    }

    public void aumentarMovimientos(int cantidad){
        this.cantidadDeMovimientos += cantidad;
    }

    public abstract void atravesarPozo();

    public abstract void atravesarPiquete();

    public abstract void atravesarControlPolicial();

    public void atravesarSorpresaFavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * 0.8);
    }

    public void atravesarSorpresaDesfavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * 1.25);
    }

    public int getMovimientos(){
        return cantidadDeMovimientos;
    }

    public Posicion getPosicion(){
        return this.mapa.getPosicionDelVehiculo();
    }
}
