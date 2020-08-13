package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaMultipleChoiceParcial implements Escena {
    private Pane layout;

    public EscenaMultipleChoiceParcial(Pregunta pregunta, Jugador jugador, Kahoot kahoot, Stage stage) {

        //LayoutMultipleChoice layoutMultipleChoice = new LayoutMultipleChoice(pregunta, jugador, kahoot, stage);
        //layout = layoutMultipleChoice.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }
}
