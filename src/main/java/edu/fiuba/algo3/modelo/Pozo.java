package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Pozo extends Obstaculo {

    public void penalizarMovimiento(Vehiculo vehiculo){
        vehiculo.atravesarPozo();
    }
}
