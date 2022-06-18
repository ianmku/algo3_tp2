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
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 2);

        /* Act */
        Posicion posFinal = arriba.calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);
    }

    @Test
    public void testPosicionSiguienteDeDireccionOpuesta() {

        /* Arrange */
        Arriba arriba = new Arriba();
        Posicion posInicial = new Posicion(1, 1);
        Posicion posEsperada = new Posicion(1, 0);

        /* Act */
        Posicion posFinal = arriba.opuesto().calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);
    }
}
