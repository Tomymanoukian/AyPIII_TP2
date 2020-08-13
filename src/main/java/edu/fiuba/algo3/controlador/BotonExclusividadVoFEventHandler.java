package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.VerdaderoFalso;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import edu.fiuba.algo3.vista.LayoutVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonExclusividadVoFEventHandler implements EventHandler<ActionEvent> {

    private VerdaderoFalso verdaderoFalso;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;

    public BotonExclusividadVoFEventHandler(VerdaderoFalso unVerdaderoFalse, Jugador unJugador, Kahoot unKahoot, Stage unStage){
        verdaderoFalso = unVerdaderoFalse;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarExclusividadJugador1(verdaderoFalso);

        Scene scene = new Scene(new LayoutVerdaderoFalso(verdaderoFalso, jugador, kahoot, stage).getLayout(), 390, 400);

        stage.setScene(scene);
        stage.show();

    }
}
