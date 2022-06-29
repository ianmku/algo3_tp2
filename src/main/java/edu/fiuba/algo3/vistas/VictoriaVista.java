package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VictoriaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VictoriaVista extends StackPane {

    private final VictoriaControlador controlador;

    public VictoriaVista(Juego juego, VictoriaControlador controlador) {
        this.controlador = controlador;
        VBox vBox = new VBox();
        vBox.setSpacing(20);

        Image image = new Image("https://github.com/ianmku/algo3_tp2/blob/manuel/src/main/java/edu/fiuba/algo3/menu_principal.png?raw=true");
        ImageView img = new ImageView(image);

        Label titulo = new Label("FELICITACIONES!!");
        titulo.setFont(Font.font("Arial", 40));
        titulo.setStyle("-fx-font-weight: bold;" + "-fx-text-fill: white;");
        vBox.getChildren().add(titulo);

        Label subTitulo = new Label("Has ganado la partida!");
        subTitulo.setFont(Font.font("Arial", 40));
        subTitulo.setStyle("-fx-text-fill: white;");
        vBox.getChildren().add(subTitulo);

        Jugador jugador = juego.getJugadorActual();

        Label movimientos = new Label("Movimientos realizados: " + jugador.obtenerCantidadMovimientos());
        movimientos.setFont(Font.font("Arial", 20));
        movimientos.setStyle("-fx-text-fill: white;");
        vBox.getChildren().add(movimientos);

        Label puntaje = new Label("Tu puntaje: " + jugador.obtenerPuntajeInt());
        puntaje.setFont(Font.font("Arial", 20));
        puntaje.setStyle("-fx-text-fill: white;");
        vBox.getChildren().add(puntaje);

        DropShadow shadow = new DropShadow();
        titulo.setEffect(shadow);
        subTitulo.setEffect(shadow);
        movimientos.setEffect(shadow);
        puntaje.setEffect(shadow);

        vBox.getChildren().add(agregarBotonRanking());
        vBox.getChildren().add(agregarBotonSalir());

        // vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setPadding(new Insets(0, 0, 0, 0));
        vBox.setAlignment(Pos.CENTER);
        this.getChildren().addAll(img, vBox);
        this.setAlignment(vBox, Pos.BOTTOM_CENTER);
    }

    private HBox agregarBotonRanking() {
        Button ranking = new Button("Ver rankings");
        ranking.setOnMouseClicked((event) -> this.controlador.verRankings());
        ranking.setMinWidth(120);
        ranking.setStyle("-fx-background-radius: 90;");
        HBox hBox1 = new HBox(ranking);
        hBox1.setAlignment(Pos.CENTER);
        return hBox1;
    }

    private HBox agregarBotonSalir() {
        Button btnSalir = new Button("Volver al menú");
        btnSalir.setOnMouseClicked((event) -> this.controlador.volverAlMenu());
        btnSalir.setMinWidth(120);
        btnSalir.setStyle("-fx-background-radius: 90;");
        HBox hBox2 = new HBox(btnSalir);
        hBox2.setAlignment(Pos.CENTER);
        return hBox2;
    }
}
