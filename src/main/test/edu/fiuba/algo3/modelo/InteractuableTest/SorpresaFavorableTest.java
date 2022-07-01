package edu.fiuba.algo3.modelo.InteractuableTest;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Interactuables.SorpresaFavorable;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SorpresaFavorableTest {

    @Test
    public void unVehiculoEncuentraSorpresaFavorable() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
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
