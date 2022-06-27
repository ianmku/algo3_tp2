package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.Vista.MapaVista;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    /*@Override
    public void start(Stage stage) {
        Juego juego = new Juego();
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout);

        VBox vBox = new VBox();

        Button botonInicio = new Button("Iniciar juego");
        botonInicio.setOnMouseClicked((event) -> mostrarMenu(vBox, juego));
        botonInicio.setMinWidth(150);
        HBox hBox = new HBox(botonInicio);
        hBox.setAlignment(Pos.BASELINE_CENTER);

        vBox.getChildren().add(hBox);

        layout.getChildren().add(vBox);

        stage.setScene(scene);
        stage.setTitle("GPS Challenge");
        stage.show();
    }*/

    @Override
    public void start(Stage stage) {
        Mapa mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
        GridPane layout = new GridPane();
        for(int i = 0; i < 10; i++) {
            ColumnConstraints column = new ColumnConstraints(40);
            layout.getColumnConstraints().add(column);
        }

        for(int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints(40);
            layout.getRowConstraints().add(row);
        }
        Circle circle = new Circle(10);
        Circle circle1 = new Circle(10);
        layout.setHalignment(circle, HPos.CENTER);
        layout.setHalignment(circle1, HPos.CENTER);




        layout.add(circle,5,5);
        layout.add(circle1,9,5);


        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

        Scene scene = new Scene(layout, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("GPS Challenge");
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }

}