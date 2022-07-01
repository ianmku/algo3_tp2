package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Calle;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Interactuables.Piquete;
import edu.fiuba.algo3.modelo.Interactuables.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(any(int.class),any(int.class))).thenReturn(new Posicion(0, 0));
        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarInteractuable(pozo);
        mapa.guardarCalle(new Posicion(3,2), calle);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(any(int.class),any(int.class))).thenReturn(new Posicion(0, 0));
        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarInteractuable(pozo);
        mapa.guardarCalle(new Posicion(3,2), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(any(int.class),any(int.class))).thenReturn(new Posicion(0, 0));
        Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
        Calle calle = new Calle();
        Vehiculo camioneta = new Vehiculo(mapa, new Camioneta());
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo();
        calle.guardarInteractuable(pozo);
        mapa.guardarCalle(new Posicion(3,2), calle);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());

    }

    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaDosMovimientos(){
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(any(int.class),any(int.class))).thenReturn(new Posicion(0, 0));
        Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = 3;

        Piquete piquete = new Piquete();
        calle.guardarInteractuable(piquete);
        mapa.guardarCalle(new Posicion(3,2), calle);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }
    @Test
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(any(int.class),any(int.class))).thenReturn(new Posicion(0, 0));
        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        Posicion inicio = new Posicion(2, 2);

        Piquete piquete = new Piquete();
        calle.guardarInteractuable(piquete);
        mapa.guardarCalle(new Posicion(3,2), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(mapa.getPosicionDelVehiculo(), inicio);
    }

    @Test
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.crearPosicionAleatoria(any(int.class),any(int.class))).thenReturn(new Posicion(0, 0));

        Mapa mapa = new Mapa(TamanioMapa.CHICO, aleatorio);
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Calle calle3 = new Calle();
        Vehiculo camioneta = new Vehiculo(mapa, new Camioneta());
        int movimientosEsperados = 5;

        Pozo pozo1 = new Pozo();
        calle1.guardarInteractuable(pozo1);
        Pozo pozo2 = new Pozo();
        calle2.guardarInteractuable(pozo2);
        Pozo pozo3 = new Pozo();
        calle3.guardarInteractuable(pozo3);

        mapa.guardarCalle(new Posicion(3,4), calle1);
        mapa.guardarCalle(new Posicion(5,4), calle2);
        mapa.guardarCalle(new Posicion(7,4), calle3);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        mapa.moverVehiculo(camioneta, new Derecha());

        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());
    }


}
