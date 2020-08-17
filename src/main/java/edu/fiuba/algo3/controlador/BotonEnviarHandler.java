package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonEnviarHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Respuesta respuesta;
    private ManejadorDeTurnos manejadorDeTurnos;
    private Timeline tiempo;

    public BotonEnviarHandler(Jugador unJugador, Respuesta unaRespuesta, ManejadorDeTurnos unManejadorDeTurnos, Timeline unTiempo) {

        jugador = unJugador;
        respuesta = unaRespuesta;
        manejadorDeTurnos = unManejadorDeTurnos;
        tiempo = unTiempo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tiempo.stop();
        manejadorDeTurnos.getKahoot().setRespuestaJugador(respuesta, jugador);
        manejadorDeTurnos.mostrarSiguientePregunta();
    }
}