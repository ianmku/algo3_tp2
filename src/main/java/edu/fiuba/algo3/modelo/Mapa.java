package edu.fiuba.algo3.modelo;


import java.util.Hashtable;

public class Mapa {

    int ancho;
    int largo;
    Hashtable<Posicion, Calle> ht;

    {
        ht = new Hashtable<Posicion, Calle>();
    }

    /*public Mapa (TamanioMapa tamanio) {
        switch (tamanio) {
            case CHICO:
                ancho = 7;
                largo = 6;
                break;
            case MEDIANO:
                ancho = 12;
                largo = 11;
                break;
            case GRANDE:
                ancho = 16;
                largo = 15;
                break;
        }
        for (int i=0; i<2*ancho-1; i++) {
            if(i % 2 == 0){
                for (int j=0; j<2*largo-1; j++) {
                    Posicion posicion = new Posicion(i, j);
                    if(j % 2 == 0){
                        Esquina esquina = new Esquina();
                        ht.put(posicion, esquina);
                    }else{
                        Calle calle = new Calle();
                        ht.put(posicion, calle);
                    }
                }
            }
            else{
                for(int j=0; j<2*largo-1; j += 2){
                    Posicion posicion = new Posicion(i, j);
                    Calle calle = new Calle();
                    ht.put(posicion, calle);
                }
            }
        }

    }*/
}
