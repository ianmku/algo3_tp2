package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo {

    public void penalizarMovimiento(Vehiculo vehiculo){
        vehiculo.atravesarPiquete();
    }
}
