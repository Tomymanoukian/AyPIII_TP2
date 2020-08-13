package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaMultipleChoice implements Escena {
    private Pane layout;
    private Pregunta pregunta;

    public EscenaMultipleChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        pregunta = unaPregunta;

        LayoutMultipleChoice layoutMultipleChoice = new LayoutMultipleChoice(pregunta, this, jugador, manejadorDeTurnos);
        layout = layoutMultipleChoice.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        Pane layout = (new LayoutMultipleChoice(pregunta, this, jugador, manejadorDeTurnos)).getLayout();
        manejadorDeTurnos.getStage().setScene(new Scene(layout));
    }
}
