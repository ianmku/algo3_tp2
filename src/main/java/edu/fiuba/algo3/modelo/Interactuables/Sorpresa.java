package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public abstract class Sorpresa implements Interactuable {
    private final String urlImagen = "https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/sorpresa.png?raw=true";
    public abstract void interactuarConVehiculo(Vehiculo vehiculo);
    public String getUrlImagen() {
        return urlImagen;
    }
}
