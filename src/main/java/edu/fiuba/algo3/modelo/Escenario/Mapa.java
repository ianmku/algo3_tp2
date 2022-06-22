package edu.fiuba.algo3.modelo.Escenario;


import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Interactuables.*;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Hashtable;

public class Mapa {

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
        Posicion proximaPosicion = direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        if(!limite.verificarLimite(proximaPosicion)){
            return;
        }
        Calle calle = calles.get(posicionDelVehiculo);
        if(calle != null){
            calle.atravesarCalle(vehiculo);
        }
        posicionDelVehiculo = direccion.calcularPosicionSiguiente(proximaPosicion);
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

    public void definirLimites(int ancho, int alto) {

    }

    public Mapa(){
        this.ancho = 10;
        this.alto = 10;
        this.limite = new LimiteMapa();
        calles = new Hashtable<>();
        colocarInteractuable(12, new Pozo());
        colocarInteractuable(10, new Piquete());
        colocarInteractuable(9, new ControlPolicial());
        colocarInteractuable(6, new SorpresaFavorable());
        colocarInteractuable(4, new SorpresaDesfavorable());
        colocarInteractuable(5, new SorpresaCambioVehiculo());
        this.posicionDelVehiculo = new Posicion(1,5);
        this.Llegada = new Posicion(9,5);

    }

    public void imprimirPosicion(){
        this.posicionDelVehiculo.imprimirPosicion();
    }


}
