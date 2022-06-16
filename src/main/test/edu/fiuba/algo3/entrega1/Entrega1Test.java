package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Vehiculo camioneta = new Vehiculo(mapa, new Camioneta());
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());

    }

    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaDosMovimientos(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Vehiculo moto = new Vehiculo(mapa, new Moto());
        int movimientosEsperados = 3;

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(moto, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }
    @Test
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Vehiculo auto = new Vehiculo(mapa, new Auto());
        Posicion inicio = new Posicion(1, 1);

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(mapa.getPosicionDelVehiculo(), inicio);
    }

    @Test
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Calle calle3 = new Calle();
        Vehiculo camioneta = new Vehiculo(mapa, new Camioneta());
        int movimientosEsperados = 5;

        Pozo pozo1 = new Pozo();
        calle1.guardarObstaculo(pozo1);
        Pozo pozo2 = new Pozo();
        calle2.guardarObstaculo(pozo2);
        Pozo pozo3 = new Pozo();
        calle3.guardarObstaculo(pozo3);

        mapa.guardarCalle(new Posicion(2,1), calle1);
        mapa.guardarCalle(new Posicion(4,1), calle2);
        mapa.guardarCalle(new Posicion(6,1), calle3);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        mapa.moverVehiculo(camioneta, new Derecha());

        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());
    }


}
