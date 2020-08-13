package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import edu.fiuba.algo3.vista.LayoutVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMultipX2VoFEventHandler implements EventHandler<ActionEvent> {

    private Pregunta pregunta;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;
    private Escena escena;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonMultipX2VoFEventHandler(Pregunta unaPregunta, Escena unaEscena,Jugador unJugador, ManejadorDeTurnos unManejadorDeTurnos ){
        pregunta = unaPregunta;
        jugador = unJugador;
        kahoot = unManejadorDeTurnos.getKahoot();
        stage = unManejadorDeTurnos.getStage();
        escena = unaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        //No hay manejo de turnos, no deberia solo setearlo al jugador1
        kahoot.agregarMultiplicadorX2(pregunta, jugador);

        Scene scene = new Scene(new LayoutVerdaderoFalso(pregunta, escena , jugador, manejadorDeTurnos).getLayout(), 390, 400);

        stage.setScene(scene);
        stage.show();
    }
}
