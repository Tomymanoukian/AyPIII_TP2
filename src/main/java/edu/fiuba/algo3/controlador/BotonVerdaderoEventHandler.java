package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaUnica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonVerdaderoEventHandler implements EventHandler<ActionEvent> {

    private Opcion opcionVerdadero;
    private Kahoot kahoot;
    private Stage stage;
    private Jugador jugador;

    public BotonVerdaderoEventHandler(Opcion una0pcionVerdadero, Jugador unJugador, Kahoot unKahoot, Stage unaStage) {

        opcionVerdadero = una0pcionVerdadero;
        kahoot = unKahoot;
        stage = unaStage;
        jugador = unJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.setRespuestaJugador1(new RespuestaUnica(opcionVerdadero));

        Pane vistaBlanco = new Pane();

        Scene scene = new Scene(vistaBlanco, 390, 400);

        stage.setScene(scene);
        stage.show();


    }
}
