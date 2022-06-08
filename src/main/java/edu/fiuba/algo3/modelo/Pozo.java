package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Pozo extends Obstaculo {
    private Posicion pos;

    public Pozo(Posicion pos){
        this.pos = pos;
    }

    public void penalizarMovimiento(Vehiculo vehiculo){
        vehiculo.atravesarPozo();
    }
}
