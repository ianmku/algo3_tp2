package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {

    @Test
    public void TestPenalizarMovimientoAMoto() {
        /* Arrange */
        Pozo pozo = new Pozo();
        Vehiculo moto = new Vehiculo(new Mapa(), new Moto());

        /* Act */
        pozo.interactuarConVehiculo(moto);

        /* Assert */
        assertEquals(moto.getMovimientos(), 3);

    }

    @Test
    public void TestPenalizarMovmientoAAuto() {
        /* Arange */
        Pozo pozo = new Pozo();
        Vehiculo auto = new Vehiculo(new Mapa(), new Auto());

        /* Act */
        pozo.interactuarConVehiculo(auto);

        /* Assert */
        assertEquals(auto.getMovimientos(), 3);
    }

    @Test
    public void TestPenalizarMovmientoACpcQueNoEncontroPozos() {
        /* Arange */
        Pozo pozo = new Pozo();
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());

        /* Act */
        pozo.interactuarConVehiculo(camioneta);

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }

    @Test
    public void testPenalizarMovimientoTresVecesACamioneta() {
        /* Arange */
        Pozo pozo = new Pozo();
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());

        /* Act */
        pozo.interactuarConVehiculo(camioneta);
        pozo.interactuarConVehiculo(camioneta);
        pozo.interactuarConVehiculo(camioneta);

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 2);
    }
}
