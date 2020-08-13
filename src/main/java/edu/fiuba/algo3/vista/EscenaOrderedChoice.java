package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaOrderedChoice implements Escena {
    private Pane layout;
    private Pregunta pregunta;
    private ListaOpciones opcionesMostradas;

    public EscenaOrderedChoice(Pregunta unaPregunta, Jugador jugador, Kahoot kahoot, Stage stage, ManejadorDeTurnos manejadorDeTurnos) {

        OrderedChoice orderedChoice = (OrderedChoice)unaPregunta;
        pregunta = unaPregunta;
        opcionesMostradas = new ListaOpciones(orderedChoice.getOpcionesDesordenadas());

        LayoutOrderedChoice layoutOrderedChoice = new LayoutOrderedChoice(pregunta, this, jugador, kahoot, stage, manejadorDeTurnos);
        layout = layoutOrderedChoice.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    public ListaOpciones getOpcionesMostradas() {return opcionesMostradas;}

    public void actualizar(OrderedChoice orderedChoice, EscenaOrderedChoice escenaOrderedChoice, Jugador jugador, Kahoot kahoot, Stage stage, ManejadorDeTurnos manejadorDeTurnos) {

        Pane layout = (new LayoutOrderedChoice(pregunta, this, jugador, kahoot, stage, manejadorDeTurnos)).getLayout();
        stage.setScene(new Scene(layout));
    }
}
