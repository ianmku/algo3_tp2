package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;

import java.util.Observable;

public class Vehiculo extends Observable {
    private int cantidadDeMovimientos;
    private Mapa mapa;
    private Direccion direccion;
    private Tipo tipo;

    private final float MULTIPLICADOR_SORPRESA_FAVORABLE = 0.8F;

    private final float MULTIPLICADOR_SORPRESA_DESFAVORABLE = 1.25F;

    public Vehiculo(Mapa mapa, Tipo tipo) {
        this.mapa = mapa;
        this.tipo = tipo;
        this.cantidadDeMovimientos = 0;
        this.direccion = new Derecha();
        setChanged();
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
        setChanged();
    }

    public void atravesarSorpresaFavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * MULTIPLICADOR_SORPRESA_FAVORABLE);
    }

    public void atravesarSorpresaDesfavorable() {
        this.cantidadDeMovimientos = (int) (this.cantidadDeMovimientos * MULTIPLICADOR_SORPRESA_DESFAVORABLE);
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

    public Mapa obtenerMapa(){
        return this.mapa;
    }

    public int calcularPuntaje() {
        return this.mapa.calcularPuntaje(this.cantidadDeMovimientos);
    }

    public int getAnchoMapa(){
        return this.mapa.getAnchoMapa();
    }

    public int getAltoMapa(){
        return this.mapa.getAltoMapa();
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

    public Posicion posicionDeLlegada() {
        return this.mapa.getPosicionDeLlegada();
    }

    public Tipo getTipo(){
        return this.tipo;
    }
}
