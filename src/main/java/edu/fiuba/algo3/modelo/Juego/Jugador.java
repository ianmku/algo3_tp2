package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Tipo;

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

    /*public void mostrarPosicion(){
        this.vehiculo.imprimirPosicion();
    }*/

    public int obtenerCantidadMovimientos(){
        return this.vehiculo.obtenerCantidadMovimientos();
    }

    public String obtenerPuntajeString() {
        int puntaje = this.vehiculo.calcularPuntaje();
        String resultado = nombre + ": " + puntaje;
        return resultado;
    }

    public Mapa obtenerMapaActual(){
        return this.vehiculo.obtenerMapa();
    }

    public int getAnchoMapa(){
        return this.vehiculo.getAnchoMapa();
    }

    public int getAltoMapa(){
        return this.vehiculo.getAltoMapa();
    }

    public int obtenerPuntajeInt() {
        return this.vehiculo.calcularPuntaje();
    }

    public Posicion posicionDeLlegada() {
        return this.vehiculo.posicionDeLlegada();
    }

    public Tipo obtenerTipoVehiculo() {
        return this.vehiculo.getTipo();
    }
}
