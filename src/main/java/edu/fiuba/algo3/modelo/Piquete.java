package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo {

    public Piquete(Posicion pos){
        this.pos = pos;
    }

    public void penalizarMovimiento(Vehiculo vehiculo){
        vehiculo.atravesarPiquete();
    }
}
