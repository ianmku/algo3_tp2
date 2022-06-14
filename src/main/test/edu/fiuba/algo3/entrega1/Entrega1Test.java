package edu.fiuba.algo3.entrega1;

import edu.fiuba.algo3.modelo.*;
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
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

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
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

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
        mapa.guardarObstaculo(new Posicion(2,1), pozo);

        /* Act */
        cpc.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());

    }

    @Test
    public void motoEncuentraUnPiqueteEsPenalizadaDosMovimientos(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Moto moto = new Moto(mapa);
        int movimientosEsperados = 3;
        Piquete piquete = new Piquete();
        mapa.guardarObstaculo(new Posicion(2,1), piquete);

        /* Act */
        moto.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, moto.getMovimientos());

    }

    @Test
    public void cuatroPorCuatroEncuentraTresPozosEsPenalizado(){
        /* Arrange */
        Mapa mapa = new Mapa();
        Cpc cpc = new Cpc(mapa);
        int movimientosEsperados = 5;

        Pozo pozo1 = new Pozo();
        Pozo pozo2 = new Pozo();
        Pozo pozo3 = new Pozo();

        mapa.guardarObstaculo(new Posicion(2,1), pozo1);
        mapa.guardarObstaculo(new Posicion(4,1), pozo2);
        mapa.guardarObstaculo(new Posicion(6,1), pozo3);

        /* Act */
        cpc.mover(new Derecha());

        cpc.mover(new Derecha());

        cpc.mover(new Derecha());

        /* Assert */
        assertEquals(movimientosEsperados, cpc.getMovimientos());
    }


    @Test
    public void autoNoAtraviesaPiquete() {
        /* Arrange */
        Mapa mapa = new Mapa();
        Posicion inicio = new Posicion(1, 1);
        Auto auto = new Auto(mapa);

        Piquete piquete = new Piquete();
        mapa.guardarObstaculo(new Posicion(2, 1), piquete);

        /* Act */
        auto.mover(new Derecha());

        /* Assert */
        assertEquals(auto.getPosicion(), inicio);
    }

}