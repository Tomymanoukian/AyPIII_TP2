package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

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

        if(pregunta.getClass().getSimpleName().equals(MultipleChoiceClasico.class.getSimpleName())) {
            LayoutMultipleChoiceSinPenalidad layoutMultipleChoice = new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos);
            layout = layoutMultipleChoice.getLayout();
        }
        if(pregunta.getClass().getSimpleName().equals(MultipleChoiceParcial.class.getSimpleName())) {
            LayoutMultipleChoiceSinPenalidad layoutMultipleChoice = new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos);
            layout = layoutMultipleChoice.getLayout();
        }
        if(pregunta.getClass().getSimpleName().equals(MultipleChoiceConPenalidad.class.getSimpleName())) {
            LayoutMultipleChoiceConPenalidad layoutMultipleChoice = new LayoutMultipleChoiceConPenalidad(pregunta, this, jugador, manejadorDeTurnos);
            layout = layoutMultipleChoice.getLayout();
        }

    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    public ListaOpciones getOpcionesMostradas() {return opcionesMostradas;}

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        if(pregunta.getClass().getSimpleName().equals(MultipleChoiceClasico.class.getSimpleName())) {
            Pane layout = (new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            manejadorDeTurnos.getStage().setScene(new Scene(layout));
        }
        if(pregunta.getClass().getSimpleName().equals(MultipleChoiceParcial.class.getSimpleName())) {
            Pane layout = (new LayoutMultipleChoiceSinPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            manejadorDeTurnos.getStage().setScene(new Scene(layout));
        }
        if(pregunta.getClass().getSimpleName().equals(MultipleChoiceConPenalidad.class.getSimpleName())) {
            Pane layout = (new LayoutMultipleChoiceConPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            manejadorDeTurnos.getStage().setScene(new Scene(layout));
        }
    }
}
