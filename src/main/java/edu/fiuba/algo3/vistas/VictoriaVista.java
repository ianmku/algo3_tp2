package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VictoriaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VictoriaVista extends BorderPane {

    private final VictoriaControlador controlador;

    public VictoriaVista(Juego juego, VictoriaControlador controlador) {
        this.controlador = controlador;
        VBox vBox = new VBox();

        Label titulo = new Label("FELICITACIONES!!");
        titulo.setFont(Font.font("Arial", 30));
        titulo.setStyle("-fx-font-weight: bold;");
        vBox.getChildren().add(titulo);

        Label subTitulo = new Label("Has ganado la partida");
        titulo.setFont(Font.font("Arial", 15));
        vBox.getChildren().add(subTitulo);

        Jugador jugador = juego.getJugadorActual();

        Label movimientos = new Label("Movimientos realizados: " + jugador.obtenerCantidadMovimientos());
        movimientos.setFont(Font.font("Arial", 15));
        vBox.getChildren().add(movimientos);

        Label puntaje = new Label("Tu puntaje: " + jugador.obtenerPuntajeInt());
        puntaje.setFont(Font.font("Arial", 15));
        vBox.getChildren().add(puntaje);

        Button ranking = new Button("Ver rankings");
        ranking.setOnMouseClicked((event) -> this.controlador.verRankings());
        ranking.setMinWidth(120);
        ranking.setStyle("-fx-background-radius: 90;");
        HBox hBox1 = new HBox(ranking);
        hBox1.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().add(hBox1);

        Button btnSalir = new Button("Volver al menú");
        btnSalir.setOnMouseClicked((event) -> this.controlador.volverAlMenu());
        btnSalir.setMinWidth(120);
        btnSalir.setStyle("-fx-background-radius: 90;");
        HBox hBox2 = new HBox(btnSalir);
        hBox2.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().add(hBox2);

        this.setTop(vBox);
    }

}
