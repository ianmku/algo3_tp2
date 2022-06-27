package edu.fiuba.algo3.modelo.DireccionTest;

import edu.fiuba.algo3.modelo.Direcciones.Arriba;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArribaTest {

    @Test
    public void TestCalcularPosicionSiguiente() {

        /* Arrange */
        Arriba arriba = new Arriba();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 2);

        /* Act */
        arriba.calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);
    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Arriba arriba = new Arriba();
        Posicion posicion = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 0);

        /* Act */
        arriba.opuesto().calcularPosicionSiguiente(posicion);

        /* Assert */
        assertEquals(posicion, posEsperada);
    }
}
