package edu.fiuba.algo3.modelo;

public class Vehiculo {
    int movimientos;
    int pozosAtravesados;
    protected TipoVehiculo tipo;

    public Vehiculo(TipoVehiculo unTipo) {
        tipo = unTipo;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public int getMovimientos() { return movimientos; }

    public int getPozosAtravesados() { return pozosAtravesados }

    public void aumentarMovimientos(int cantidad) {
        movimientos += cantidad;
    }

    public void aumentarPozosAtravesados(int cantidad) {
        pozosAtravesados += cantidad;
    }
}

public class Moto implements Vehiculo {

}

public class Auto implements Vehiculo {

}

public class CpC implements Vehiculo {


}


