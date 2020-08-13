package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.EscenaOrderedChoice;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonExclusividadHandler implements EventHandler<ActionEvent> {

    private OrderedChoice orderedChoice;
    private EscenaOrderedChoice escenaOrderedChoice;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonExclusividadHandler (OrderedChoice unaOrderedChoice, EscenaOrderedChoice unaEscenaOrderedChoice, Jugador unJugador, Kahoot unKahoot, Stage unStage, ManejadorDeTurnos unManejadorDeTurnos) {

        orderedChoice = unaOrderedChoice;
        escenaOrderedChoice = unaEscenaOrderedChoice;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
        manejadorDeTurnos = unManejadorDeTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        kahoot.agregarExclusividadJugador1(orderedChoice);

        Scene scene = new Scene(new LayoutOrderedChoice(orderedChoice, escenaOrderedChoice, jugador, kahoot, stage, manejadorDeTurnos).getLayout(), 390, 400);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();
    }
}