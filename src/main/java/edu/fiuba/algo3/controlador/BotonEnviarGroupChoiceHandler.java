package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonEnviarGroupChoiceHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private RespuestaDeGrupos respuesta;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonEnviarGroupChoiceHandler(Jugador unJugador, RespuestaDeGrupos unaRespuesta, ManejadorDeTurnos unManejadorDeTurnos) {

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