package edu.fiuba.algo3.modelo.InteractuableTest;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Interactuables.Piquete;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {

    @Test
    public void TestPenalizarMovimientoAMoto() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Vehiculo moto = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Moto());

        /* Act */
        piquete.interactuarConVehiculo(moto);

        /* Assert */
        assertEquals(2, moto.getMovimientos());
    }

    @Test
    public void TestPenalizarMovimientoAAuto() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Vehiculo auto = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Auto());

        /* Act */
        piquete.interactuarConVehiculo(auto);

        /* Assert */
        assertEquals(0, auto.getMovimientos());
    }

    @Test
    public void TestPenalizarMovimientoACamioneta() {
        /* Arrange */
        Piquete piquete = new Piquete();
        Vehiculo camioneta = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Camioneta());

        /* Act */
        piquete.interactuarConVehiculo(camioneta);

        /* Assert */
        assertEquals(0, camioneta.getMovimientos());
    }
}
