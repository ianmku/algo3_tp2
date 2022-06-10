package edu.fiuba.algo3.modelo;

public class Calle {
    Obstaculo obstaculo;
    Sorpresa sorpresa;

    public void guardarObstaculo(Obstaculo unObstaculo) {
        obstaculo = unObstaculo;
    }

    public void atravesarCalle(Vehiculo vehiculo) {
        obstaculo.penalizarMovimiento(vehiculo);
    }
}