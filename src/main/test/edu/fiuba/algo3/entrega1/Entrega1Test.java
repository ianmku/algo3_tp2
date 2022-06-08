package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Vehiculo moto = new Moto(new Posicion(1,1));
        int movimientosEsperados = 4;

        Obstaculo obstaculo = new Obstaculo(new Posicion(2,1));

        obstaculo.penalizarMovimiento(moto);
        /* Act */


        /* Assert */
        assertEquals(movimientosEsperados, movimientos + 3);

    }

    @Test
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        vehiculo auto = new auto();
        int movimientos = auto.movimientos();

        /* Act */
        auto_encuentra_pozo();

        /* Assert */
        assertEquals(auto.movimientos, movimientos + 3);
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        vehiculo cpc = new cpc();
        int movimientos = cpc.movimientos();

        /* Act */
        cpc_encuentra_pozo();

        /* Assert */
        assertEquals(cpc.movimientos, movimientos);

    }

    @Test
    public void casoDeUsoAlterno01() {

    }

    @Test
    public void casoDeUsoAlterno02() {

    }
}
