package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaUnica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVerdaderoEventHandler implements EventHandler<ActionEvent> {
    Opcion opcionVerdadero;
    Kahoot kahoot;
    public BotonVerdaderoEventHandler(Opcion una0pcionVerdadero, Kahoot unKahoot) {
        opcionVerdadero = una0pcionVerdadero;
        kahoot = unKahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.setRespuestaJugador1(new RespuestaUnica(opcionVerdadero));
    }
}
