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

    private Posicion posicionDelVehiculo;
    private Posicion Llegada;
    private Hashtable<Posicion, Calle> calles;

    private LimiteMapa limite;


    public void guardarCalle(Posicion posicion, Calle calle) {
        calles.put(posicion, calle);
    }

    public boolean vehiculoEstaEnLlegada(){
        return (this.posicionDelVehiculo.equals(this.Llegada));
    }

    public void moverVehiculo(Vehiculo vehiculo, Direccion direccion){
        imprimirPosicion();
        posicionDelVehiculo = direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        posicionDelVehiculo = direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        if(!posicionDelVehiculo.estaEnLimites(this.ancho, this.alto)){
            posicionDelVehiculo = direccion.opuesto().calcularPosicionSiguiente(posicionDelVehiculo);
            posicionDelVehiculo = direccion.opuesto().calcularPosicionSiguiente(posicionDelVehiculo);
            return;
        }
        Calle calle = calles.get(posicionDelVehiculo);
        if(calle != null){
            calle.atravesarCalle(vehiculo);
        }
        vehiculo.aumentarMovimientos(1);
    }

    public Posicion getPosicionDelVehiculo(){
        return this.posicionDelVehiculo;
    }

    public void colocarInteractuable(int cantidad, Interactuable interactuable) {
        Aleatorio random = new Aleatorio();
        for(int i=0; i<cantidad; i++){
            Posicion posicion = random.crearPosicionAleatoria(ancho, alto);
            Calle calle = calles.get(posicion);
            if(calle == null){
                calle = new Calle();
                calles.put(posicion, calle);
            }
            calle.guardarInteractuable(interactuable);
        }
    }

    public Mapa(TamanioMapa tamanio){
        calles = new Hashtable<>();
        switch(tamanio){
            case CHICO:
                this.ancho = ANCHO_CHICO;
                this.alto = ALTO_CHICO;
                colocarInteractuable(OBSTACULOS_CHICO, new Pozo());
                colocarInteractuable(OBSTACULOS_CHICO, new Piquete());
                colocarInteractuable(OBSTACULOS_CHICO, new ControlPolicial());
                colocarInteractuable(SORPRESAS_CHICO, new SorpresaFavorable());
                colocarInteractuable(SORPRESAS_CHICO, new SorpresaDesfavorable());
                colocarInteractuable(SORPRESAS_CHICO, new SorpresaCambioVehiculo());
                break;
            case MEDIANO:
                this.ancho = ANCHO_MEDIANO;
                this.alto = ALTO_MEDIANO;
                colocarInteractuable(OBSTACULOS_MEDIANO, new Pozo());
                colocarInteractuable(OBSTACULOS_MEDIANO, new Piquete());
                colocarInteractuable(OBSTACULOS_MEDIANO, new ControlPolicial());
                colocarInteractuable(SORPRESAS_MEDIANO, new SorpresaFavorable());
                colocarInteractuable(SORPRESAS_MEDIANO, new SorpresaDesfavorable());
                colocarInteractuable(SORPRESAS_MEDIANO, new SorpresaCambioVehiculo());
                break;
            case GRANDE:
                this.ancho = ANCHO_GRANDE;
                this.alto = ALTO_GRANDE;
                colocarInteractuable(OBSTACULOS_GRANDE, new Pozo());
                colocarInteractuable(OBSTACULOS_GRANDE, new Piquete());
                colocarInteractuable(OBSTACULOS_GRANDE, new ControlPolicial());
                colocarInteractuable(SORPRESAS_GRANDE, new SorpresaFavorable());
                colocarInteractuable(SORPRESAS_GRANDE, new SorpresaDesfavorable());
                colocarInteractuable(SORPRESAS_GRANDE, new SorpresaCambioVehiculo());
                break;
        }
        this.limite = new LimiteMapa();
        this.posicionDelVehiculo = new Posicion(2,(this.alto - 1) / 2);
        this.Llegada = new Posicion(ancho - 1,this.alto / 2);
    }

    public void imprimirPosicion(){
        this.posicionDelVehiculo.imprimirPosicion();
    }


}
