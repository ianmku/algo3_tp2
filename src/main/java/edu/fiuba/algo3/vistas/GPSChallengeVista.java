package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.GPSChallengeControlador;
import edu.fiuba.algo3.controladores.MapaControlador;
import edu.fiuba.algo3.controladores.RankingControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
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
        this.getChildren().clear();
        this.getChildren().add(vista);
    }

    public String obtenerTitulo() {
        return "GPS Challenge";
    }

    @Override
    public void update(Observable juego, Object arg) {
        var gpsChallenge = (Juego) juego;

        var estado = gpsChallenge.obtenerEstado();

        switch(estado){
            case "MENU":
                iniciar();
                break;
            case "INICIAR_LOBBY":
                mostrar(new CrearJugadorVista());
                break;
            case "MOSTRAR_RANKING":
                mostrar(new RankingVista(gpsChallenge, new RankingControlador()));
                break;

            case "INICIAR_PARTIDA" :
                mostrar(new MapaVista(gpsChallenge, new MapaControlador()));
        }
    }
}
