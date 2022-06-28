package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.GPSChallengeControlador;
import edu.fiuba.algo3.controladores.RankingControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class RankingVista extends BorderPane {

    private final RankingControlador controlador;
    public RankingVista(Juego juego, RankingControlador controlador) {
        this.controlador = controlador;
        VBox vBox = new VBox();
        vBox.setSpacing(5);

        Label titulo = new Label("RANKINGS");
        titulo.setFont(Font.font("Arial", 30));
        titulo.setStyle("-fx-font-weight: bold;");
        vBox.getChildren().add(titulo);

        juego.obtenerJugadores().forEach((jugador) -> {
            String puntaje = jugador.obtenerPuntajeString();
            Label labelPuntaje = new Label(puntaje);
            labelPuntaje.setStyle("-fx-text-fill: black;" +
                    "-fx-font-size: 30;"

            );
            labelPuntaje.setWrapText(true);

            HBox hBox = new HBox();
            hBox.getChildren().add(labelPuntaje);
            hBox.setMaxWidth(400);

            vBox.getChildren().add(hBox);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
        });

        Button btnSalir = new Button("Volver al menú");
        btnSalir.setOnMouseClicked((event) -> this.controlador.volverAlMenu());
        btnSalir.setMinWidth(120);
        btnSalir.setStyle("-fx-background-radius: 90;");
        HBox salir = new HBox(btnSalir);
        salir.setAlignment(Pos.CENTER);
        vBox.getChildren().add(salir);

        this.setTop(vBox);
    }
}
