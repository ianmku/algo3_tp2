package edu.fiuba.algo3.modelo.Escenario;


import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Interactuables.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Hashtable;

public class Mapa {

    private int ancho;
    private int largo;
    private Posicion posicionDelVehiculo;
    private Posicion Llegada;
    private Hashtable<Posicion, Calle> calles;


    public void guardarCalle(Posicion posicion, Calle calle) {
        calles.put(posicion, calle);
    }

    public boolean vehiculoEstaEnLlegada(){
        return (this.posicionDelVehiculo.equals(this.Llegada));
    }

    public void moverVehiculo(Vehiculo vehiculo, Direccion direccion){
        posicionDelVehiculo = direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        Calle calle = calles.get(posicionDelVehiculo);
        if(calle != null){
            calle.atravesarCalle(vehiculo);
        }
        posicionDelVehiculo = direccion.calcularPosicionSiguiente(posicionDelVehiculo);
        vehiculo.aumentarMovimientos(1);
    }

    public Posicion getPosicionDelVehiculo(){
        return this.posicionDelVehiculo;
    }

    public Mapa(){
        this.ancho = 10;
        this.largo = 10;
        calles = new Hashtable<>();
        this.posicionDelVehiculo = new Posicion(1,1);
        this.Llegada = new Posicion(9,5);

    }

    public void imprimirPosicion(){
        this.posicionDelVehiculo.imprimirPosicion();
    }


}
