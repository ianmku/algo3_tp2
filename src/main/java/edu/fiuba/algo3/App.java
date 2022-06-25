package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
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
    }

    public void mostrarMenu(VBox vBox, Juego juego){
        vBox.getChildren().clear();

        Button botonJugar = new Button("Jugar");
        botonJugar.setOnMouseClicked((event) -> juego.iniciarPartida());

        Button botonRanking = new Button("Ver Ranking");
        botonRanking.setOnMouseClicked((event) -> juego.mostrarRanking());

        HBox hBox = new HBox(botonJugar, botonRanking);
        hBox.setAlignment(Pos.BASELINE_CENTER);

        vBox.getChildren().add(hBox);
    }

    public static void main(String[] args) {
        launch();
    }

}