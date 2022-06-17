package edu.fiuba.algo3.modelo;

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
}
