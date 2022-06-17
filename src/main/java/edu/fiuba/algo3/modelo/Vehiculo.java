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

    public boolean estaEnLlegada(){
        return (this.mapa.vehiculoEstaEnLlegada());
    }

    public int obtenerCantidadMovimientos(){
        return this.cantidadDeMovimientos;
    }

    public void atravesarPozo(){
        this.aumentarMovimientos(tipo.atravesarPozo());
    }

    public void atravesarPiquete(){
        this.aumentarMovimientos(tipo.atravesarPiquete(mapa, direccion, this));
    }

    public void atravesarControlPolicial() {
        this.aumentarMovimientos(tipo.atravesarControlPolicial());
    }

    public void aumentarMovimientos(int cantidad){
        this.cantidadDeMovimientos += cantidad;
    }

    public void mover(Direccion unaDireccion){
        this.direccion = unaDireccion;
        this.mapa.moverVehiculo(this, this.direccion);
    }

    public void atravesarSorpresaFavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * 0.8);
    }

    public void atravesarSorpresaDesfavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * 1.25);
    }

    public void atravesarSorpresaCambioDeVehiculo(){
        this.tipo = tipo.atravesarCambioVehiculo();
    }

    public int getMovimientos(){
        return cantidadDeMovimientos;
    }

    public Posicion getPosicion(){
        return this.mapa.getPosicionDelVehiculo();
    }

    public Tipo getTipo(){
        return this.tipo;
    }

    public boolean es(Tipo tipoEsperado) {
        if(this.tipo.getClass() == tipoEsperado.getClass()){
            return true;
        }
        return false;
    }

    public void imprimirPosicion(){
        this.mapa.imprimirPosicion();
    }
}
