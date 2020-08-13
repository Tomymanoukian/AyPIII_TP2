package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.VerdaderoFalso;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import edu.fiuba.algo3.vista.LayoutVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMultipX2VoFEventHandler implements EventHandler<ActionEvent> {

    private VerdaderoFalso verdaderoFalso;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;

    public BotonMultipX2VoFEventHandler(VerdaderoFalso unVerdaderoFalso, Jugador unJugador, Kahoot unKahoot, Stage unStage ){
        verdaderoFalso = unVerdaderoFalso;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        //No hay manejo de turnos, no deberia solo setearlo al jugador1
        kahoot.agregarMultiplicadorX2Jugador1(verdaderoFalso);

        Scene scene = new Scene(new LayoutVerdaderoFalso(verdaderoFalso, jugador, kahoot, stage).getLayout(), 390, 400);

        stage.setScene(scene);
        stage.show();
    }
}
