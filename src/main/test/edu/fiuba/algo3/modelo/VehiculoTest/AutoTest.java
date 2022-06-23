package edu.fiuba.algo3.modelo.VehiculoTest;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AutoTest {

    @Test
    public void TestAutoRecienCreadoTieneCeroMovimientos() {
        /* Arrange */
        Vehiculo auto = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Auto());

        /* Act and Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

    @Test
    public void TestAutoMoverModificaSuPosicion() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        Posicion destino = new Posicion(4, 3);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(auto.getPosicion(), destino);
    }

    @Test
    public void TestAutoAtravesarPozoAumentaSusMovimientos() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Vehiculo auto = new Vehiculo(new Mapa(TamanioMapa.CHICO, aleatorio), new Auto());

        /* Act */
        auto.atravesarPozo();

        /* Assert */
        assertEquals(auto.getMovimientos(), 3);
    }

    @Test
    public void TestAutoAtravesarPiqueteNoAumentaUnMovimientos() {
        /* Arrange */
        Vehiculo auto = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Auto());

        /* Act */
        auto.atravesarPiquete();

        /* Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

}
