package edu.fiuba.algo3.modelo.VehiculoTest;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MotoTest {

    @Test
    public void TestMotoRecienCreadaTieneCeroMovimientos() {
        /* Arrange */
        Vehiculo moto = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Moto());

        /* Act and Assert */
        assertEquals(moto.getMovimientos(), 0);
    }

    @Test
    public void TestMotoMoverModificaSuPosicion() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        Posicion destino = new Posicion(4, 6);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(moto.getPosicion(), destino);
    }

    @Test
    public void TestMotoAtravesarPozoAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo moto = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Moto());

        /* Act */
        moto.atravesarPozo();

        /* Assert */
        assertEquals(moto.getMovimientos(), 3);
    }

    @Test
    public void TestMotoAtravesarPiqueteAumentaSusMovimientos() {
        /* Arrange */
        Vehiculo moto = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Moto());

        /* Act */
        moto.atravesarPiquete();

        /* Assert */
        assertEquals(moto.getMovimientos(), 2);
    }

}
