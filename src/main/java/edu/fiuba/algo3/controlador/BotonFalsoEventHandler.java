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

public class BotonFalsoEventHandler implements EventHandler<ActionEvent> {

    private Opcion opcionFalso;
    private Kahoot kahoot;
    private Stage stage;
    private Jugador jugador;

    public BotonFalsoEventHandler(Opcion unaOpcionFalso,Jugador unJugador, Kahoot unKahoot, Stage unaStage) {

        opcionFalso = unaOpcionFalso;
        kahoot = unKahoot;
        stage = unaStage;
        jugador = unJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.setRespuestaJugador1(new RespuestaUnica(opcionFalso));

        Pane vistaBlanco = new Pane();

        Scene scene = new Scene(vistaBlanco, 390, 400);

        stage.setScene(scene);
        stage.show();
    }
}
