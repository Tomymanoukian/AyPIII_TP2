package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonEnviarHandler implements EventHandler<ActionEvent> {

    private OrderedChoice orderedChoice;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;


    public BotonEnviarHandler (OrderedChoice unaOrderedChoice, Jugador unJugador, Kahoot unKahoot, Stage unStage) {

        orderedChoice = unaOrderedChoice;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        kahoot.setRespuestaJugador1(new RespuestaEnLista(orderedChoice.getOpcionesOrdenadas()));

        Pane fondoBlanco = new Pane();

        Scene scene = new Scene(fondoBlanco, 390,400);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();
    }
}