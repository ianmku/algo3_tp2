package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamionetaTest {
    @Test
    public void TestCamionetaRecienCreadaTieneCeroMovimientos() {
        /* Arrange */
        Camioneta camioneta = new Camioneta(new Mapa());

        /* Act and Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }

    @Test
    public void TestCamionetaMoverModificaSuPosicion() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Camioneta camioneta = new Camioneta(mapa);
        Posicion destino = new Posicion(3, 1);

        /* Act */
        mapa.moverVehiculo(camioneta, new Derecha());

        /* Assert */
        assertEquals(camioneta.getPosicion(), destino);
    }

    @Test
    public void TestCamionetaAtravesarUnPozoNoAumentaSusMovimientos() {
        /* Arrange */
        Camioneta camioneta = new Camioneta(new Mapa());

        /* Act */
        camioneta.atravesarPozo();

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }

    @Test
    public void TestCamionetaAtravesarTresPozosAumentaSusMovimientos() {
        /* Arrange */
        Camioneta camioneta = new Camioneta(new Mapa());

        /* Act */
        camioneta.atravesarPozo();
        camioneta.atravesarPozo();
        camioneta.atravesarPozo();

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 2);
    }

    @Test
    public void TestCamionetaAtravesarPiqueteNoAumentaSusMovimientos() {
        /* Arrange */
        Camioneta camioneta = new Camioneta(new Mapa());

        /* Act */
        camioneta.atravesarPiquete();

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }
}
