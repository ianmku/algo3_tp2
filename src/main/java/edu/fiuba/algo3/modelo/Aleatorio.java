package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

import java.util.Random;

import static java.lang.Math.abs;

public class Aleatorio {

    Random rand = new Random();

    public boolean atravesarControlPolicial(float chance) {
        Random rand = new Random();
        float random = rand.nextFloat();
        return (random <= chance);
    }

    public int generarCoordenadaY(int coordenadaX, int alto) {
        int coordenadaY = rand.nextInt(alto/2);
        if(coordenadaX % 2 == 0) {
            coordenadaY = abs((coordenadaY * 2) - 1);
        }else{
            coordenadaY *= 2;
        }
    }

    public Posicion crearPosicionAleatoria(int ancho, int alto) {
        int coordenadaX = rand.nextInt(ancho);
        int coordenadaY = generarCoordenadaY(coordenadaX, alto);
        return new Posicion(coordenadaX, coordenadaY);
    }
}
