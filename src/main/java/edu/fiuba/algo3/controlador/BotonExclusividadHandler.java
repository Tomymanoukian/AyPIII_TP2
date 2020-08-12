package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonExclusividadHandler implements EventHandler<ActionEvent> {

    private OrderedChoice orderedChoice;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;


    public BotonExclusividadHandler (OrderedChoice unaOrderedChoice, Jugador unJugador, Kahoot unKahoot, Stage unStage) {

        orderedChoice = unaOrderedChoice;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        kahoot.agregarExclusividadJugador1(orderedChoice);

        Scene scene = new Scene(new LayoutOrderedChoice(orderedChoice, jugador, kahoot, stage).getLayout(), 390, 375);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();
    }
}