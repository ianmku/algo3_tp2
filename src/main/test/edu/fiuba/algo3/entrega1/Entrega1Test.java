package edu.fiuba.algo3.entrega1;

import org.junit.jupiter.api.Test;

public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        vehiculo moto = new Vehiculo(TipoVehiculo.MOTO);
        int movimientos = moto.getMovimientos();

        /* Act */
        moto.mover(DERECHA);

        /* Assert */
        assertEquals(moto.movimientos, movimientos + 3);

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
