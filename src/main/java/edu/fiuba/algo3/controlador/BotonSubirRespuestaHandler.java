package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonSubirRespuestaHandler implements EventHandler<ActionEvent> {

    private int posicion;
    private OrderedChoice orderedChoice;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;

    public BotonSubirRespuestaHandler (int unaPosicion, OrderedChoice unaOrderedChoice, Jugador unJugador, Kahoot unKahoot, Stage unStage) {
        posicion = unaPosicion;
        orderedChoice = unaOrderedChoice;
        jugador = unJugador;
        kahoot = unKahoot;
        stage = unStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Opcion opcionVaso = new Opcion(orderedChoice.getOpciones().obtener(posicion).getOpcion());
        orderedChoice.getOpciones().establecer(posicion, orderedChoice.getOpciones().obtener(posicion-1));
        orderedChoice.getOpciones().establecer(posicion-1, opcionVaso);

        Scene scene = new Scene(new LayoutOrderedChoice(orderedChoice, jugador, kahoot, stage).getLayout(), 390, 400);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();
    }
}
