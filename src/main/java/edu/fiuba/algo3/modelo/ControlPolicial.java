package edu.fiuba.algo3.modelo;

public class ControlPolicial extends Obstaculo {
    public ControlPolicial(Posicion pos){
        this.pos = pos;
    }

    public void penalizarMovimiento(Vehiculo vehiculo){
        vehiculo.atravesarControlPolicial();
    }
}
