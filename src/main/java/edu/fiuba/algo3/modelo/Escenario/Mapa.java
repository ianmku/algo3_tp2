package edu.fiuba.algo3.modelo.Escenario;


import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Interactuables.Sorpresa;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Hashtable;

public class Mapa {

    int ancho;
    int largo;
    private Posicion posicionDelVehiculo;
    private Posicion ultimaPosicion;
    private Posicion Llegada;
    private Hashtable<Posicion, Calle> calles;


    public void guardarCalle(Posicion posicion, Calle calle) {
        calles.put(posicion, calle);
    }

    public void guardarSorpresa(Posicion posicion, Sorpresa sorpresa) {
        Calle calle = calles.get(posicion);
        calle.guardarSorpresa(sorpresa);
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
        calles = new Hashtable<Posicion, Calle>();
        this.posicionDelVehiculo = new Posicion(1,1);
        this.Llegada = new Posicion(9,5);

    }

    public void imprimirPosicion(){
        this.posicionDelVehiculo.imprimirPosicion();
    }


}
