package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

public class Robin implements Tipo {
    private final int PENALIZACION_POZO = 3;
    private Aleatorio aleatorio;
    private final String urlImagen = "https://www.vhv.rs/dpng/d/436-4368499_car-inside-top-png-transparent-png.png";

    public Robin(Aleatorio aleatorio) {
        this.aleatorio = aleatorio;
    }
    public Robin() {
        this.aleatorio = new Aleatorio();
    }
    public int atravesarPozo() {
        return PENALIZACION_POZO;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo) {
        Tipo tipo = aleatorio.obtenerComportamientoRobin();
        return tipo.atravesarPiquete(mapa, direccion, vehiculo);
    }

    public int atravesarControlPolicial(Aleatorio aleatorio) {
        Tipo tipo = aleatorio.obtenerComportamientoRobin();
        return tipo.atravesarControlPolicial(aleatorio);
    }

    @Override
    public Tipo atravesarCambioVehiculo() {
        return new Moto();
    }

    @Override
    public String getUrlImagen() {
        return urlImagen;
    }
}
