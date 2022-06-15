package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoTest {

    @Test
    public void TestAutoRecienCreadoTieneCeroMovimientos() {
        /* Arrange */
        Auto auto = new Auto(new Mapa());

        /* Act and Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

    @Test
    public void TestAutoMoverModificaSuPosicion() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Auto auto = new Auto(mapa);
        Posicion destino = new Posicion(3, 1);

        /* Act */
        mapa.moverVehiculo(auto, new Derecha());

        /* Assert */
        assertEquals(auto.getPosicion(), destino);
    }

    @Test
    public void TestAutoAtravesarPozoAumentaSusMovimientos() {
        /* Arrange */
        Auto auto = new Auto(new Mapa());

        /* Act */
        auto.atravesarPozo();

        /* Assert */
        assertEquals(auto.getMovimientos(), 3);
    }

    @Test
    public void TestAutoAtravesarPiqueteNoAumentaUnMovimientos() {
        /* Arrange */
        Auto auto = new Auto(new Mapa());

        /* Act */
        auto.atravesarPiquete();

        /* Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

}
