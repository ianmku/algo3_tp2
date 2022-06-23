package edu.fiuba.algo3.modelo.DireccionTest;

import edu.fiuba.algo3.modelo.Direcciones.Abajo;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbajoTest {

    @Test
    public void testCalcularPosicionSiguiente() {

        /* Arrange */
        Abajo abajo = new Abajo();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 0);

        /* Act */
        abajo.calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);

    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Abajo abajo = new Abajo();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 2);

        /* Act */
        abajo.opuesto().calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);
    }
}
