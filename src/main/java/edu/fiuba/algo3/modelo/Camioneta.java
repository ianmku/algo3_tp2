package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Camioneta implements Tipo {

    private Vehiculo vehiculo;
    private int cantidadDePozosAtravesados;

    public int atravesarPozo(){
        this.cantidadDePozosAtravesados++;
        if((this.cantidadDePozosAtravesados % 3) == 0){
            return 2;
        }
        return 0;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion) {
        mapa.moverVehiculo(vehiculo, direccion.opuesto());
        return 0;
    }

    public int atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.3) return 3;
        return 0;
    }
}
