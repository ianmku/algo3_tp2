package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Pozo extends Obstaculo {


    public Pozo(Posicion pos){
        this.pos = pos;
    }

    public void penalizarMovimiento(Vehiculo vehiculo){
        vehiculo.atravesarPozo();
    }
}
