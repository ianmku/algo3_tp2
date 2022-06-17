package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Auto implements Tipo {
   // Vehiculo vehiculo;

    public int atravesarPozo(){
        return 3;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo) {
        mapa.moverVehiculo(vehiculo, direccion.opuesto());
        return 0;
    }

    public int atravesarControlPolicial() {
        Random rand = new Random();
        float random = rand.nextFloat();
        if(random <= 0.5) return 3;
        return 0;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Camioneta();
    }

}
