package edu.fiuba.algo3.modelo.InteractuableTest;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Interactuables.SorpresaFavorable;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaFavorableTest {

    @Test
    public void unVehiculoEncuentraSorpresaFavorable() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Vehiculo vehiculo = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = (int) (2 * 0.8);
        SorpresaFavorable sorpresa = new SorpresaFavorable();
        mapa.moverVehiculo(vehiculo, new Derecha());
        mapa.moverVehiculo(vehiculo, new Derecha());

        /* Act */
        sorpresa.interactuarConVehiculo(vehiculo);

        /* Assert */
        assertEquals(movimientosEsperados, vehiculo.getMovimientos());
    }
}
