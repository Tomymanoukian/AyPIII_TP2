package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaMultipleChoice implements Escena {
    private Pane layout;
    private Pregunta pregunta;
    private ListaOpciones opcionesMostradas;

    public EscenaMultipleChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        MultipleChoice multipleChoice = (MultipleChoice) unaPregunta;
        pregunta = unaPregunta;
        opcionesMostradas = new ListaOpciones(multipleChoice.getOpcionesCorrectas());
        opcionesMostradas.agregarTodo(multipleChoice.getOpcionesIncorrectas());
        opcionesMostradas.desordenar();

        LayoutMultipleChoice layoutMultipleChoice = new LayoutMultipleChoice(pregunta, this, jugador, manejadorDeTurnos);
        layout = layoutMultipleChoice.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    public ListaOpciones getOpcionesMostradas() {return opcionesMostradas;}

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        Pane layout = (new LayoutMultipleChoice(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
        manejadorDeTurnos.getStage().setScene(new Scene(layout));
    }
}
