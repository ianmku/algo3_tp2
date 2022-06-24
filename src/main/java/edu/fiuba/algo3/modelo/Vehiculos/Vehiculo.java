package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;

public class Vehiculo {
    private int cantidadDeMovimientos;
    private Mapa mapa;
    private Direccion direccion;
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

    public void atravesarControlPolicial(Aleatorio aleatorio) {
        this.aumentarMovimientos(tipo.atravesarControlPolicial(aleatorio));
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

    public int calcularPuntaje() {
        return this.mapa.calcularPuntaje(this.cantidadDeMovimientos);
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
