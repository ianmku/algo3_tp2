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
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 0);

        /* Act */
        Posicion posFinal = abajo.calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);

    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Abajo abajo = new Abajo();
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 2);

        /* Act */
        Posicion posFinal = abajo.opuesto().calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);
    }
}
