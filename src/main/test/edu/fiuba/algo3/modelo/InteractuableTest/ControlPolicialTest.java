package edu.fiuba.algo3.modelo.InteractuableTest;

import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Interactuables.ControlPolicial;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class ControlPolicialTest {

    @Test
    public void mockVehiculoAtraviesaControlPolicialEsPenalizado() {
        /* Arrange */
        ControlPolicial controlPolicial = mock(ControlPolicial.class);
        Vehiculo vehiculo = new Vehiculo(new Mapa(), new Auto());

        /* Act */
        doAnswer(invocation -> {
            vehiculo.aumentarMovimientos(3);
            return null;
        }).when(controlPolicial).interactuarConVehiculo(any(Vehiculo.class));
        controlPolicial.interactuarConVehiculo(vehiculo);

        /* Assert */
        assertEquals(3, vehiculo.getMovimientos());
    }
}
