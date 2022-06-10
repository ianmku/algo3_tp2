package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

    @Test
    public void motoEncuentraUnPozoEsPenalizadaTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Moto moto = new Moto(new Posicion(1,1));
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        moto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void autoEncuentraPozoEsPenalizadoTresMovimientos() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Auto auto = new Auto(new Posicion(1,1));
        int movimientosEsperados = 4;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        auto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, auto.getMovimientos());
    }

    @Test
    public void cuatroPorCuatroEncuentraPozoNoEsPenalizada() {

        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Cpc cpc = new Cpc(new Posicion(1,1));
        int movimientosEsperados = 1;

        Pozo pozo = new Pozo();
        calle.guardarObstaculo(pozo);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        cpc.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());

    }
    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaDosMovimientos(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Moto moto = new Moto(new Posicion(1,1));
        int movimientosEsperados = 3;

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2,1), calle);

        /* Act */
        moto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle1 = new Calle();
        Calle calle2 = new Calle();
        Calle calle3 = new Calle();
        Cpc cpc = new Cpc(new Posicion(1,1));
        int movimientosEsperados = 5;

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
        cpc.mover(mapa, new Derecha());

        cpc.mover(mapa, new Derecha());

        cpc.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());
    }

    @Test
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Calle calle = new Calle();
        Posicion inicio = new Posicion(1, 1);
        Auto auto = new Auto(inicio);

        Piquete piquete = new Piquete();
        calle.guardarObstaculo(piquete);
        mapa.guardarCalle(new Posicion(2, 1), calle);

        /* Act */
        auto.mover(mapa, new Derecha());

        /* Assert */
        assertEquals(auto.getPosicion(), inicio);
    }

}
