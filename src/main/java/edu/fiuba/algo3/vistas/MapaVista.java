package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.MapaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MapaVista extends StackPane {
    public MapaVista(Juego juego, MapaControlador mapaControlador){
        Image fondoDePantalla = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/resources/images/mapa_grande.png?raw=true");

        Button btn2 = new Button("Arriba");
        btn2.setCursor(Cursor.HAND);
        btn2.setPrefWidth(70);

        Button btn3 = new Button("Izquierda");
        btn3.setCursor(Cursor.HAND);

        Button btn4 = new Button("Derecha");
        btn4.setCursor(Cursor.HAND);

        Button btn5 = new Button("Abajo");
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
                    rectangulo.setHeight(40);
                    rectangulo.setWidth(40);
                    //rectangulo.setStroke(Color.BLACK);
                    rectangulo.setFill(Color.BLACK);
                    mapa.add(rectangulo,i,j);
                }
                else{
                    var rectangulo = new Rectangle();
                    rectangulo.setFill(Color.WHITE);
                    //rectangulo.setStroke(Color.RED);
                    rectangulo.setHeight(40);
                    rectangulo.setWidth(40);
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

        Image image1 = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/src/main/java/edu/fiuba/algo3/pngegg.png?raw=true");

        ImageView img = new ImageView(image1);

        mapa.add(img,2,2);

        img.setFitHeight(39);
        img.setFitWidth(39);

        //circle.setRadius(20);


        TranslateTransition tt = new TranslateTransition();

        tt.setNode(img);
        tt.setDuration(Duration.seconds(4));

        tt.setToX(80);
        tt.setToY(0);
        tt.setAutoReverse(false);

        tt.play();

        RotateTransition rt = new RotateTransition(Duration.seconds(2), img);
        rt.setByAngle(90);
        rt.setDelay(Duration.seconds(4));
        rt.play();
        rt.setByAngle(180);
        rt.setDelay(Duration.seconds(6));
        rt.play();


        //StackPane sp = new StackPane();

       // sp.setMaxWidth(640);
       // sp.setMaxHeight(520);

        this.getChildren().addAll(mapa,botones);

        this.setAlignment(img, Pos.CENTER_LEFT);

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
