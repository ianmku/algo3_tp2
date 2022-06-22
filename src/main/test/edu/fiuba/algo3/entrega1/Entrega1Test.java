package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.Direcciones.Derecha;
import edu.fiuba.algo3.modelo.Escenario.Calle;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Interactuables.Piquete;
import edu.fiuba.algo3.modelo.Interactuables.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Moto moto = new Moto(mapa);
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        moto.mover(new Derecha());
        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Auto auto = new Auto(mapa);

        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        auto.mover(new Derecha());
        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        Mapa mapa = new Mapa();
        Cpc cpc = new Cpc(mapa);
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        cpc.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());

    }

    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaDosMovimientos(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Moto moto = new Moto(mapa);
        int movimientosEsperados = 3;

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        moto.mover(new Derecha());
        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }
    @Test
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Cpc cpc = new Cpc(mapa);
        int movimientosEsperados = 5;

        Pozo pozo1 = new Pozo();
        Pozo pozo2 = new Pozo();
        Pozo pozo3 = new Pozo();

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        cpc.mover(new Derecha());

        cpc.mover(new Derecha());

        cpc.mover(new Derecha());

        /* Assert */
        assertEquals(mapa.getPosicionDelVehiculo(), inicio);
    }

    @Test
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Posicion inicio = new Posicion(1, 1);
        Auto auto = new Auto(mapa);
        Pozo pozo1 = new Pozo();
        calle1.guardarObstaculo(pozo1);
        Pozo pozo2 = new Pozo();
        calle2.guardarObstaculo(pozo2);
        Pozo pozo3 = new Pozo();
        calle3.guardarObstaculo(pozo3);

        mapa.guardarCalle(new Posicion(2,1), calle1);
        mapa.guardarCalle(new Posicion(4,1), calle2);
        mapa.guardarCalle(new Posicion(6,1), calle3);

        /* Act */
        auto.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, camioneta.getMovimientos());
    }


}
