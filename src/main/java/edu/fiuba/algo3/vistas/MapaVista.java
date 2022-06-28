package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.MapaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MapaVista extends StackPane {
    public MapaVista(Juego juego, MapaControlador mapaControlador){
        Image image = new Image("https://thumbs.dreamstime.com/z/ejemplo-del-vector-del-juego-de-herramientas-del-mapa-de-la-ciudad-37184410.jpg");

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

        ImageView img1 = new ImageView(image);

        //StackPane sp = new StackPane();

       // sp.setMaxWidth(640);
       // sp.setMaxHeight(520);

        this.getChildren().addAll(img1,botones);

        this.setAlignment(img1, Pos.CENTER);

        this.setAlignment(botones, Pos.BOTTOM_RIGHT);

        this.setMargin(botones, new Insets(0,0,20,0));

        this.setPrefWidth(640);
        this.setMaxHeight(520);
        /*sp.setMaxSize(640,520);

        this.setCenter(sp);
        this.setMaxWidth(640);
        this.setMaxWidth(520);*/
    }
}
