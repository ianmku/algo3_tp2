package edu.fiuba.algo3.modelo.Escenario;


import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Interactuables.*;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Hashtable;

public class Mapa {

    private final int ANCHO_CHICO = 7;
    private final int ALTO_CHICO = 7;
    private final int ANCHO_MEDIANO = 11;
    private final int ALTO_MEDIANO = 11;
    private final int ANCHO_GRANDE = 17;
    private final int ALTO_GRANDE = 17;

    private final int OBSTACULOS_CHICO = 7;
    private final int OBSTACULOS_MEDIANO = 10;
    private final int OBSTACULOS_GRANDE = 13;

    private final int SORPRESAS_CHICO = 3;
    private final int SORPRESAS_MEDIANO = 5;
    private final int SORPRESAS_GRANDE = 7;

    private int ancho;
    private int alto;

    private int multiplicadorPuntaje;

    private Posicion posicionDelVehiculo;

    private final int COORDENADA_X_VEHICULO = 2;
    private Posicion Llegada;
    private Hashtable<Posicion, Calle> calles;


    public void guardarCalle(Posicion posicion, Calle calle) {
        calles.put(posicion, calle);
    }

    public boolean vehiculoEstaEnLlegada(){
        return (this.posicionDelVehiculo.equals(this.Llegada));
    }

    public void moverVehiculo(Vehiculo vehiculo, Direccion direccion){

        direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        Calle calle = calles.get(posicionDelVehiculo);
        if(!posicionDelVehiculo.estaEnLimites(this.ancho, this.alto)) {
            direccion.opuesto().calcularPosicionSiguiente(posicionDelVehiculo);
            return;
        }

        vehiculo.aumentarMovimientos(1);
        if(calle != null){
            calle.atravesarCalle(vehiculo);
        }

        direccion.calcularPosicionSiguiente(posicionDelVehiculo);

    }

    public Posicion getPosicionDelVehiculo(){
        return this.posicionDelVehiculo;
    }

    public void colocarInteractuable(int cantidad, Interactuable interactuable, Aleatorio aleatorio) {
        for(int i=0; i<cantidad; i++){
            Posicion posicion = aleatorio.crearPosicionAleatoria(ancho, alto);
            Calle calle = calles.get(posicion);
            if(calle == null){
                calle = new Calle();
                calles.put(posicion, calle);
            }
            calle.guardarInteractuable(interactuable);
        }
    }

    public Mapa(TamanioMapa tamanio, Aleatorio aleatorio){
        calles = new Hashtable<>();
        switch(tamanio){
            case CHICO:
                this.ancho = ANCHO_CHICO;
                this.alto = ALTO_CHICO;
                this.multiplicadorPuntaje = 1;
                colocarInteractuable(OBSTACULOS_CHICO, new Pozo(), aleatorio);
                colocarInteractuable(OBSTACULOS_CHICO, new Piquete(), aleatorio);
                colocarInteractuable(OBSTACULOS_CHICO, new ControlPolicial(aleatorio), aleatorio);
                colocarInteractuable(SORPRESAS_CHICO, new SorpresaFavorable(), aleatorio);
                colocarInteractuable(SORPRESAS_CHICO, new SorpresaDesfavorable(), aleatorio);
                colocarInteractuable(SORPRESAS_CHICO, new SorpresaCambioVehiculo(), aleatorio);
                break;
            case MEDIANO:
                this.ancho = ANCHO_MEDIANO;
                this.alto = ALTO_MEDIANO;
                this.multiplicadorPuntaje = 2;
                colocarInteractuable(OBSTACULOS_MEDIANO, new Pozo(), aleatorio);
                colocarInteractuable(OBSTACULOS_MEDIANO, new Piquete(), aleatorio);
                colocarInteractuable(OBSTACULOS_MEDIANO, new ControlPolicial(aleatorio), aleatorio);
                colocarInteractuable(SORPRESAS_MEDIANO, new SorpresaFavorable(), aleatorio);
                colocarInteractuable(SORPRESAS_MEDIANO, new SorpresaDesfavorable(), aleatorio);
                colocarInteractuable(SORPRESAS_MEDIANO, new SorpresaCambioVehiculo(), aleatorio);
                break;
            case GRANDE:
                this.ancho = ANCHO_GRANDE;
                this.alto = ALTO_GRANDE;
                this.multiplicadorPuntaje = 3;
                colocarInteractuable(OBSTACULOS_GRANDE, new Pozo(), aleatorio);
                colocarInteractuable(OBSTACULOS_GRANDE, new Piquete(), aleatorio);
                colocarInteractuable(OBSTACULOS_GRANDE, new ControlPolicial(aleatorio), aleatorio);
                colocarInteractuable(SORPRESAS_GRANDE, new SorpresaFavorable(), aleatorio);
                colocarInteractuable(SORPRESAS_GRANDE, new SorpresaDesfavorable(), aleatorio);
                colocarInteractuable(SORPRESAS_GRANDE, new SorpresaCambioVehiculo(), aleatorio);
                break;
        }
        this.posicionDelVehiculo = new Posicion(COORDENADA_X_VEHICULO,(this.alto - 1) / 2);
        this.Llegada = aleatorio.generarPosicionDeLlegada(this.ancho, this.alto);
        this.Llegada.imprimirPosicion();
    }

    public int calcularPuntaje(int cantidadDeMovimientos) {
        return cantidadDeMovimientos * this.multiplicadorPuntaje;
    }
    
}
