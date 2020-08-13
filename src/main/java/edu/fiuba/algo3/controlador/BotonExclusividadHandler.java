package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonExclusividadHandler implements EventHandler<ActionEvent> {

    private OrderedChoice orderedChoice;
    private EscenaOrderedChoice escenaOrderedChoice;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonExclusividadHandler (OrderedChoice unaOrderedChoice, EscenaOrderedChoice unaEscenaOrderedChoice, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos) {

        orderedChoice = unaOrderedChoice;
        escenaOrderedChoice = unaEscenaOrderedChoice;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        manejadorDeTurnos.getKahoot().agregarExclusividadJugador1(orderedChoice);

        escenaOrderedChoice.actualizar(jugador, manejadorDeTurnos);
    }
}