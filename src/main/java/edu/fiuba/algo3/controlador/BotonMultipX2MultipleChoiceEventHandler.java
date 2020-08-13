package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.VerdaderoFalso;
import edu.fiuba.algo3.vista.LayoutMultipleChoice;
import edu.fiuba.algo3.vista.LayoutVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMultipX2MultipleChoiceEventHandler implements EventHandler<ActionEvent> {

    private MultipleChoiceClasico multipleChoice;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;

    public BotonMultipX2MultipleChoiceEventHandler(MultipleChoiceClasico unMultipleChoice, Jugador unJugador, Kahoot unKahoot, Stage unStage ){
        multipleChoice = unMultipleChoice;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarMultiplicadorX2(multipleChoice, jugador);

        Scene scene = new Scene(new LayoutMultipleChoice(multipleChoice, jugador, kahoot, stage).getLayout(), 390, 400);

        stage.setScene(scene);
        stage.show();
    }
}
