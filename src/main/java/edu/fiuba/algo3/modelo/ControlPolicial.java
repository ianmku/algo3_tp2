package edu.fiuba.algo3.modelo;

public class ControlPolicial extends Obstaculo {

    public void penalizarMovimiento(Vehiculo vehiculo){
        vehiculo.atravesarControlPolicial();
    }
}