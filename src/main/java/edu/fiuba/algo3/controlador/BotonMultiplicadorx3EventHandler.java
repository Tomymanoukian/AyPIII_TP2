package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.vista.Escena;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMultiplicadorx3EventHandler implements EventHandler<ActionEvent> {

    private Pregunta pregunta;
    private Escena escena;
    private Jugador jugador;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonMultiplicadorx3EventHandler(Pregunta unaPregunta, Escena unaEscena, Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos){
        pregunta = unaPregunta;
        escena = unaEscena;
        jugador = unJugador;
        manejadorDeTurnos = unManejadorDeTurnos;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        manejadorDeTurnos.getKahoot().agregarMultiplicadorX3(pregunta, jugador);

        escena.actualizar(jugador, manejadorDeTurnos);

    }
}