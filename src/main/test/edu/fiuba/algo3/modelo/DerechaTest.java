package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerechaTest {

    @Test
    public void testCalcularPosicionSiguiente() {

        /* Arrange */
        Derecha der = new Derecha();
        Posicion posInicial = new Posicion(0, 0);
        Posicion posEsperada = new Posicion(1, 0);

        /* Act */
        Posicion posFinal = der.calcularPosicionSiguiente(posInicial);

        /* Assert */
        assertEquals(posFinal, posEsperada);

    }
}
