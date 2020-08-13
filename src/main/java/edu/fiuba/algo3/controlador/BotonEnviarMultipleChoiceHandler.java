package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonEnviarMultipleChoiceHandler implements EventHandler<ActionEvent> {

    private MultipleChoiceClasico multipleChoice;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;
    private ListaOpciones opcionesElegidas;

    public BotonEnviarMultipleChoiceHandler (MultipleChoiceClasico unMultipleChoice, Jugador unJugador, ListaOpciones unasOpcionesElegidas, Kahoot unKahoot, Stage unStage) {

        multipleChoice = unMultipleChoice;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
        opcionesElegidas = unasOpcionesElegidas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.setRespuestaJugador1(new RespuestaEnLista(opcionesElegidas));

        Pane fondoBlanco = new Pane();

        Scene scene = new Scene(fondoBlanco, 390,400);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();

    }
}
