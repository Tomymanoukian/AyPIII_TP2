package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.LayoutOrderedChoice;
import edu.fiuba.algo3.vista.LayoutVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonExclusividadVoFEventHandler implements EventHandler<ActionEvent> {

    private Pregunta pregunta;
    private Jugador jugador;
    private Kahoot kahoot;
    private Stage stage;
    private ManejadorDeTurnos manejadorDeTurnos;

    public BotonExclusividadVoFEventHandler(Pregunta unaPregunta, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos){
        pregunta = unaPregunta;
        jugador = unJugador;
        kahoot = manejadorDeTurnos.getKahoot();
        stage = manejadorDeTurnos.getStage();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarExclusividad(pregunta, jugador);

        Scene scene = new Scene(new LayoutVerdaderoFalso(pregunta, jugador, manejadorDeTurnos).getLayout(), 390, 400);

        stage.setScene(scene);
        stage.show();

    }
}
