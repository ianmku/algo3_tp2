package edu.fiuba.algo3.controladores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioVista extends BorderPane {
    private final GPSChallengeControlador controlador;

    public InicioVista(GPSChallengeControlador controlador) {
        this.controlador = controlador;

        VBox vBox = new VBox();
        vBox.getChildren().add(agregarBotonDeInicio());

    }

    private HBox agregarBotonDeInicio() {
        Button botonInicio = new Button("Iniciar Juego");
        botonInicio.setOnMouseClicked((event) -> this.controlador.iniciarPartida());
        botonInicio.setMinWidth(150);
        botonInicio.setStyle("-fx-background-radius: 90;");
        HBox hBox = new HBox(botonInicio);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        return hBox;
    }
}
