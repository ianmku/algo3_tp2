package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.GPSChallengeControlador;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.Observable;
import java.util.Observer;

public class GPSChallengeVista extends StackPane implements Observer {
    private final GPSChallengeControlador controlador;

    public GPSChallengeVista(GPSChallengeControlador controlador) {
        super();
        this.controlador = controlador;
        iniciar();
    }

    private void iniciar() {
        mostrar(new InicioVista(this.controlador));
    }

    private void mostrar(Pane vista) {
        vista.getChildren().clear();
        vista.getChildren().add(vista);
    }

    public String obtenerTitulo() {
        return "GPS Challenge";
    }

    @Override
    public void update(Observable juego, Object arg) {

    }
}
