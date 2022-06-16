package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Vehiculo {
    protected int cantidadDeMovimientos;
    protected Mapa mapa;
    protected Direccion direccion;
    private Tipo tipo;

    public Vehiculo(Mapa mapa, Tipo tipo) {
        this.mapa = mapa;
        this.tipo = tipo;
        this.cantidadDeMovimientos = 0;
        this.direccion = new Derecha();
    }

    public void atravesarPozo(){
        this.aumentarMovimientos(tipo.atravesarPozo());
    }

    public void atravesarPiquete(){
        this.aumentarMovimientos(tipo.atravesarPiquete(mapa, direccion));
    }

    public void atravesarControlPolicial() {
        this.aumentarMovimientos(tipo.atravesarControlPolicial());
    }

    public void aumentarMovimientos(int cantidad){
        this.cantidadDeMovimientos += cantidad;
    }



    public void atravesarSorpresaFavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * 0.8);
    }

    public void atravesarSorpresaDesfavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * 1.25);
    }

    public void atravesarSorpresaCambioDeVehiculo(){

    }

    public int getMovimientos(){
        return cantidadDeMovimientos;
    }

    public Posicion getPosicion(){
        return this.mapa.getPosicionDelVehiculo();
    }
}
