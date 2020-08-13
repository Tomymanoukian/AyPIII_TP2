package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonEnviarOrderedChoiceHandler implements EventHandler<ActionEvent> {

    private OrderedChoice orderedChoice;
    private Kahoot kahoot;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonEnviarOrderedChoiceHandler(OrderedChoice unaOrderedChoice, Kahoot unKahoot, ManejadorDeTurnos unManejadorDeTurnos) {

        orderedChoice = unaOrderedChoice;
        kahoot = unKahoot;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        kahoot.setRespuestaJugador1(new RespuestaEnLista(orderedChoice.getOpciones()));
        manejadorDeTurnos.mostrarSiguientePregunta();
    }
}