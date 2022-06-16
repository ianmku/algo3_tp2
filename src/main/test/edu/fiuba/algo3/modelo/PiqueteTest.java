package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {

    @Test
    public void TestPenalizarMovimientoAMoto() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Vehiculo moto = new Vehiculo(new Mapa(), new Moto());

        /* Act */
        piquete.interactuarConVehiculo(moto);

        /* Assert */
        assertEquals(moto.getMovimientos(), 2);
    }

    @Test
    public void TestPenalizarMovimientoAAuto() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Vehiculo auto = new Vehiculo(new Mapa(), new Moto());

        /* Act */
        piquete.interactuarConVehiculo(auto);

        /* Assert */
        assertEquals(auto.getMovimientos(), 0);
    }

    @Test
    public void TestPenalizarMovimientoACamioneta() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Vehiculo camioneta = new Vehiculo(new Mapa(), new Camioneta());

        /* Act */
        piquete.interactuarConVehiculo(camioneta);

        /* Assert */
        assertEquals(camioneta.getMovimientos(), 0);
    }
}
