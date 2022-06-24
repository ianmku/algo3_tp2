package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

import java.util.Random;

import static java.lang.Math.abs;

public class Aleatorio {

    Random rand;

    public Aleatorio(){
        this.rand = new Random();
    }

    public boolean atravesarControlPolicial(float chance) {
        float random = this.rand.nextFloat();
        return (random <= chance);
    }

    public Posicion generarPosicionDeLlegada(int ancho, int alto){
        int coordenadaX = ancho-1;
        int coordenadaY = rand.nextInt(alto);
        while(coordenadaY % 2 == 0){
            coordenadaY = rand.nextInt(alto);
        }

        return new Posicion(coordenadaX, coordenadaY);
    }

    public int generarCoordenadaY(int coordenadaX, int alto) {
        int coordenadaY = this.rand.nextInt(alto/2);
        if(coordenadaX % 2 == 0) {
            coordenadaY = abs((coordenadaY * 2) - 1);
        }else{
            coordenadaY *= 2;
        }
        return coordenadaY;
    }

    public Posicion crearPosicionAleatoria(int ancho, int alto) {
        int coordenadaX = this.rand.nextInt(ancho);
        int coordenadaY = generarCoordenadaY(coordenadaX, alto);
        return new Posicion(coordenadaX, coordenadaY);
    }
}
