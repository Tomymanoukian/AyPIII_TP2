package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaUnica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonFalsoEventHandler implements EventHandler<ActionEvent> {
    private Opcion opcionFalso;
    private Kahoot kahoot;

    public BotonFalsoEventHandler(Opcion opcionFalso, Kahoot kahoot) {
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.setRespuestaJugador1(new RespuestaUnica(opcionFalso));
    }
}
