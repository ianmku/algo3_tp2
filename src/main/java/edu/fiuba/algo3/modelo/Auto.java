package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Auto implements Tipo {
    Vehiculo vehiculo;

    public int atravesarPozo(){
        return 3;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion) {
        mapa.moverVehiculo(vehiculo, direccion.opuesto());
        return 0;
    }

    public int atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.5) return 3;
        return 0;
    }

    public void atravesarCambioDeVehiculo() {

    }

}
