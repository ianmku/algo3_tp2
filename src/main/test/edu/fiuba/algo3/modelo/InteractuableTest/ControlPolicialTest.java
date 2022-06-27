package edu.fiuba.algo3.modelo.InteractuableTest;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Interactuables.ControlPolicial;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ControlPolicialTest {

    @Test
    public void mockVehiculoAtraviesaControlPolicialEsPenalizado() {
        /* Arrange */
        Aleatorio aleatorio = mock(Aleatorio.class);
        when(aleatorio.atravesarControlPolicial(anyFloat())).thenReturn(true);

        ControlPolicial controlPolicial = new ControlPolicial(aleatorio);
        Vehiculo vehiculo = new Vehiculo(new Mapa(TamanioMapa.CHICO, new Aleatorio()), new Auto());

        /* Act */
        controlPolicial.interactuarConVehiculo(vehiculo);

        /* Assert */
        assertEquals(3, vehiculo.getMovimientos());
    }
}
