package edu.fiuba.algo3.modelo;

public class Calle {
    Obstaculo obstaculo;
    Sorpresa sorpresa;

    public void guardarObstaculo(Obstaculo unObstaculo) {
        obstaculo = unObstaculo;
    }

    public void guardarSorpresa(Sorpresa unaSorpresa) {
        sorpresa = unaSorpresa;
    }

    public void atravesarCalle(Vehiculo vehiculo) {
        if(obstaculo != null) obstaculo.penalizarMovimiento(vehiculo);
        if(sorpresa != null) sorpresa.sorprenderVehiculo(vehiculo);
    }
}