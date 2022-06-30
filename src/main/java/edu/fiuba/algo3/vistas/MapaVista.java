package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.MapaControlador;
import edu.fiuba.algo3.modelo.Escenario.Calle;
import edu.fiuba.algo3.modelo.Escenario.Posicion;
import edu.fiuba.algo3.modelo.Interactuables.ControlPolicial;
import edu.fiuba.algo3.modelo.Interactuables.Piquete;
import edu.fiuba.algo3.modelo.Interactuables.Pozo;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Interactuables.Interactuable;
import java.util.Map.Entry;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.ImageInput;
import javafx.scene.layout.HBox;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Hashtable;

public class MapaVista extends StackPane {
    public MapaVista(Juego juego, MapaControlador mapaControlador){
        Image fondoDePantalla = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/mapa_grande.png?raw=true");

        Button btn2 = new Button("Arriba");
        //btn2.setOnMouseClicked((event) -> mapaControlador.moverArriba());
        btn2.setCursor(Cursor.HAND);
        btn2.setPrefWidth(70);

        Button btn3 = new Button("Izquierda");
        btn3.setCursor(Cursor.HAND);
        //btn3.setOnMouseClicked((event) -> mapaControlador.moverIzquierda());

        Button btn4 = new Button("Derecha");
        btn4.setCursor(Cursor.HAND);
        //btn3.setOnMouseClicked((event) -> mapaControlador.moverDerecha());

        Button btn5 = new Button("Abajo");
        //btn3.setOnMouseClicked((event) -> mapaControlador.moverAbajo());
        btn5.setCursor(Cursor.HAND);
        btn5.setPrefWidth(70);

        GridPane botones = new GridPane();
        botones.setAlignment(Pos.BOTTOM_RIGHT);

        botones.add(btn2, 0,0);
        botones.add(btn3, 0,1);
        botones.add(btn4, 1,1);
        botones.add(btn5, 0,2);

        botones.setMargin(btn2, new Insets(0,0,5,0));
        botones.setMargin(btn5, new Insets(5,0,0,0));

        botones.setColumnSpan(btn2,2);
        botones.setColumnSpan(btn5,2);


        botones.setHalignment(btn2, HPos.CENTER);
        botones.setHalignment(btn5, HPos.CENTER);

        int anchoMapa = juego.getAnchoMapa();

        int altoMapa = juego.getAltoMapa();

        GridPane mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);
        mapa.setPrefWidth(640);
        mapa.setPrefHeight(520);

        /*for(int i=0; i < anchoMapa; i++){
            ColumnConstraints columna = new ColumnConstraints(40);
            mapa.getColumnConstraints().add(columna);
        }*/

        for(int i=0; i < anchoMapa; i++){
            for(int j=0; j < altoMapa; j++){
                if((i%2 != 0) && (j%2 != 0)){
                    var rectangulo = new Rectangle();
                    rectangulo.setHeight(100);
                    rectangulo.setWidth(100);
                    //rectangulo.setStroke(Color.BLACK);
                    rectangulo.setFill(Color.BLACK);
                    mapa.add(rectangulo,i,j);
                }
                else{
                    var rectangulo = new Rectangle();
                    rectangulo.setFill(Color.WHITE);
                    //rectangulo.setStroke(Color.RED);
                    rectangulo.setHeight(100);
                    rectangulo.setWidth(100);
                    mapa.add(rectangulo,i,j);
                }
            }
        }

        Image imagenLlegada = new Image("https://i.pinimg.com/564x/f9/60/6b/f9606ba052600841c02b9a96e357841e.jpg");
        ImageView llegada = new ImageView(imagenLlegada);

        mapa.add(llegada, juego.posicionDeLlegada().getPosicionX(), juego.posicionDeLlegada().getPosicionY() );

        llegada.setFitWidth(39);
        llegada.setFitHeight(39);

        ImageView fondoView = new ImageView(fondoDePantalla);

        VehiculoVista vehiculoVista = new VehiculoVista(juego);
        btn2.setOnMousePressed((event) -> mapaControlador.moverArriba(vehiculoVista));
        btn4.setOnMousePressed((event) -> mapaControlador.moverDerecha(vehiculoVista));
        btn3.setOnMousePressed((event) -> mapaControlador.moverIzquierda(vehiculoVista));
        btn5.setOnMousePressed((event) -> mapaControlador.moverAbajo(vehiculoVista));

        mapa.add(vehiculoVista,2,2);

        //img.setFitHeight(39);
        //img.setFitWidth(39);

        //circle.setRadius(20);

        Hashtable<Posicion, Calle> hash = juego.getMapaActual().obtenerCalles();

        for (Entry<Posicion, Calle> entry : hash.entrySet()){
            Posicion posicion = entry.getKey();
            Calle calle = entry.getValue();
            var contenedorInteractuables = new HBox();


            for(Interactuable i: calle.getInteractuables()){
                //Rectangle rectangulo = new Rectangle();
                Image imagenInteractuable;
                ImageView imgInteractuable;


                if(i.getClass() == Piquete.class){
                    //rectangulo.setFill(Color.RED);
                    imagenInteractuable = new Image ("https://t2.uc.ltmcdn.com/es/posts/7/7/5/como_hacer_choripan_42577_orig.jpg");
                    imgInteractuable = new ImageView(imagenInteractuable);
                }
                else if(i.getClass() == Pozo.class){
                    //rectangulo.setFill(Color.BLUE);
                    imagenInteractuable = new Image ("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/pozo.png?raw=true");
                    imgInteractuable = new ImageView(imagenInteractuable);
                }
                else if(i.getClass() == ControlPolicial.class){
                    //rectangulo.setFill(Color.GREEN);
                    imagenInteractuable = new Image ("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/control_policial.png?raw=true");
                    imgInteractuable = new ImageView(imagenInteractuable);
                }
                else{
                    //rectangulo.setFill(Color.PURPLE);
                    imagenInteractuable = new Image ("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/sorpresa.png?raw=true");
                    imgInteractuable = new ImageView(imagenInteractuable);
                }


                //rectangulo.setHeight(10);
                //rectangulo.setWidth(10);
                imgInteractuable.setFitHeight(40);
                imgInteractuable.setFitWidth(40);


                contenedorInteractuables.getChildren().add(imgInteractuable);
            }

            mapa.add(contenedorInteractuables, posicion.getPosicionX(),posicion.getPosicionY());
            contenedorInteractuables.setAlignment(Pos.CENTER);
        }

        /*TranslateTransition tt = new TranslateTransition();

        tt.setNode(vehiculoVista);
        tt.setDuration(Duration.seconds(4));

        tt.setToX(85);
        tt.setToY(0);
        tt.setAutoReverse(false);

        tt.play();

        RotateTransition rt = new RotateTransition(Duration.seconds(2), vehiculoVista);
        rt.setByAngle(90);
        //rt.setDelay(Duration.seconds(4));
        rt.play();
        //rt.setByAngle(180);
        //rt.setDelay(Duration.seconds(6));
        //rt.play();

        TranslateTransition tt1 = new TranslateTransition();
        tt1.setNode(vehiculoVista);
        tt1.setDuration(Duration.seconds(4));


        tt1.setToY(85);
        tt1.setAutoReverse(false);
        tt1.play();*/

        //vehiculoVista.moverDerecha();

        //StackPane sp = new StackPane();

       // sp.setMaxWidth(640);
       // sp.setMaxHeight(520);

        this.getChildren().addAll(mapa,botones);

        this.setAlignment(vehiculoVista, Pos.CENTER_LEFT);

        this.setAlignment(mapa, Pos.CENTER);

        this.setAlignment(botones, Pos.BOTTOM_RIGHT);

        this.setMargin(botones, new Insets(0,0,20,10));

        this.setPrefWidth(640);
        this.setMaxHeight(520);
        /*sp.setMaxSize(640,520);

        this.setCenter(sp);
        this.setMaxWidth(640);
        this.setMaxWidth(520);*/
    }
}
