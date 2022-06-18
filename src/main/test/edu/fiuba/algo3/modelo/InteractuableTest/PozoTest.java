package edu.fiuba.algo3.modelo.InteractuableTest;

import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Interactuables.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
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
