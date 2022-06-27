package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.GPSChallengeControlador;
import javafx.geometry.Insets;
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
        vBox.setSpacing(5);
        vBox.getChildren().add(agregarBotonDeInicio());
        vBox.getChildren().add(agregarBotonDeRanking());
        vBox.setPadding(new Insets(0, 0, 70, 0));
        this.setBottom(vBox);
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

    private HBox agregarBotonDeRanking() {
        Button botonRanking = new Button("Mostrar Ranking");
        botonRanking.setOnMouseClicked((event) -> this.controlador.mostrarRanking());
        botonRanking.setMinWidth(150);
        botonRanking.setStyle("-fx-background-radius: 90;");
        HBox hBox = new HBox(botonRanking);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        return hBox;
    }
}
