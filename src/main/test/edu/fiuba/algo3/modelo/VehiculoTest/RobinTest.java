package edu.fiuba.algo3.modelo.VehiculoTest;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RobinTest {

    @Test
    public void testRobinNoAtraviesaPiqueteSiendoAuto() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.obtenerComportamientoRobin()).thenReturn(new Auto());
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));
        Vehiculo robin = new Vehiculo(new Mapa(TamanioMapa.CHICO, aleatorio), new Robin(aleatorio));
        int movimientosEsperados = 0;

        /* Act */
        robin.atravesarPiquete();

        /* Assert */
        assertEquals(movimientosEsperados, robin.getMovimientos());
    }

    @Test
    public void testRobinAtraviesaPiqueteSiendoMoto() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.obtenerComportamientoRobin()).thenReturn(new Moto());
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));
        Vehiculo robin = new Vehiculo(new Mapa(TamanioMapa.CHICO, aleatorio), new Robin(aleatorio));
        int movimientosEsperados = 2;

        /* Act */
        robin.atravesarPiquete();

        /* Assert */
        assertEquals(movimientosEsperados, robin.getMovimientos());
    }

    @Test
    public void testRobinAtraviesaControlPolicialSiendoAuto() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.obtenerComportamientoRobin()).thenReturn(new Auto());
        when(aleatorio.crearPosicionAleatoria(anyInt(), anyInt())).thenReturn(new Posicion(0,0));
        when(aleatorio.atravesarControlPolicial(anyFloat())).thenReturn(true);
        Vehiculo robin = new Vehiculo(new Mapa(TamanioMapa.CHICO, aleatorio), new Robin(aleatorio));
        int movimientosEsperados = 3;

        /* Act */
        robin.atravesarControlPolicial(aleatorio);

        /* Assert */
        assertEquals(movimientosEsperados, robin.getMovimientos());
    }
}
