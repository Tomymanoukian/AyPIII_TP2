package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonExclusividadHandler implements EventHandler<ActionEvent> {

    private Pregunta pregunta;
    private Escena escena;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonExclusividadHandler (Pregunta unaPregunta, Escena unaEscena, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos) {

        pregunta = unaPregunta;
        escena = unaEscena;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        manejadorDeTurnos.getKahoot().agregarExclusividad(pregunta, jugador);

        escena.actualizar(jugador, manejadorDeTurnos);
    }
}