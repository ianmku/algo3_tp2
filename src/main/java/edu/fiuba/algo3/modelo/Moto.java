package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Moto implements Tipo {

    Vehiculo vehiculo;

    public int atravesarPozo(){
        return 3;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion){
        return 2;
    }

    public int atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.8) return 3;
        return 0;
    }
}