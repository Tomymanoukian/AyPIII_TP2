package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutMultipleChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonExclusividadMultipleChoiceEventHandler implements EventHandler<ActionEvent> {

    private MultipleChoice multipleChoice;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;
    private ManejadorDeTurnos manejadorDeTurnos;


    public BotonExclusividadMultipleChoiceEventHandler(MultipleChoice unMultipleChoice, Jugador unJugador, Kahoot unKahoot, Stage unStage, ManejadorDeTurnos unManejadorDeTurnos ){
        multipleChoice = unMultipleChoice;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarExclusividad(multipleChoice, jugador);

        Scene scene = new Scene(new LayoutMultipleChoice(multipleChoice, jugador, manejadorDeTurnos).getLayout(), 390, 400);

        stage.setScene(scene);
        stage.show();

    }
}
