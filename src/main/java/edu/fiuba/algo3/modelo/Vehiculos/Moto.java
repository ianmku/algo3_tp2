package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Moto implements Tipo {

    public int atravesarPozo(){
        return 3;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo){
        return 2;
    }

    public int atravesarControlPolicial() {
        Aleatorio random = new Aleatorio();
        if(random.atravesarControlPolicial(0.8F)) return 3;
        return 0;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Auto();
    }

}