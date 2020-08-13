package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonEnviarGroupChoiceHandler implements EventHandler<ActionEvent> {

    private GroupChoice groupChoice;
    private RespuestaDeGrupos respuesta;
    private Kahoot kahoot;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonEnviarGroupChoiceHandler(GroupChoice unGroupChoice, RespuestaDeGrupos unaRespuesta, Kahoot unKahoot, ManejadorDeTurnos unManejadorDeTurnos) {

        groupChoice = unGroupChoice;
        respuesta = unaRespuesta;
        kahoot = unKahoot;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        kahoot.setRespuestaJugador1(respuesta);
        manejadorDeTurnos.mostrarSiguientePregunta();
    }
}