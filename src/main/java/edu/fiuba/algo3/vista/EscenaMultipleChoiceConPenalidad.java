package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaMultipleChoiceConPenalidad implements Escena{
    private Pane layout;

    public EscenaMultipleChoiceConPenalidad(Pregunta pregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        LayoutMultipleChoice layoutMultipleChoice = new LayoutMultipleChoice(pregunta, jugador, manejadorDeTurnos);
        layout = layoutMultipleChoice.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

    }
}
