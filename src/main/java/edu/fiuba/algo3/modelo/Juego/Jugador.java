package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Jugador {

    private String nombre;
    private Vehiculo vehiculo;


    public Jugador(String unNombre, Vehiculo unVehiculo){
        this.nombre = unNombre;
        this.vehiculo = unVehiculo;
    }

    public void moverVehiculo(Direccion unaDireccion){
        this.vehiculo.mover(unaDireccion);
    }
    public boolean ganoPartida(){
        return this.vehiculo.estaEnLlegada();
    }

    public void mostrarPosicion(){
        this.vehiculo.imprimirPosicion();
    }

    public int obtenerCantidadMovimientos(){
        return this.vehiculo.obtenerCantidadMovimientos();
    }

    public void mostrarRanking() {
        int puntaje = this.vehiculo.calcularPuntaje();
        System.out.println(nombre + ": " + puntaje);
    }
}
