package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonEnviarOrderedChoiceHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private RespuestaEnLista respuesta;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonEnviarOrderedChoiceHandler(Jugador unJugador, RespuestaEnLista unaRespuesta, ManejadorDeTurnos unManejadorDeTurnos) {

        jugador = unJugador;
        respuesta = unaRespuesta;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        manejadorDeTurnos.getKahoot().setRespuestaJugador(respuesta, jugador);
        manejadorDeTurnos.mostrarSiguientePregunta();
    }
}