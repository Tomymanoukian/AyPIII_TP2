package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class EscenaGroupChoice implements Escena {

    private Pane layout;
    private Pregunta pregunta;
    private ListaOpciones opcionesMostradas;

    public EscenaGroupChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) unaPregunta;
        pregunta = unaPregunta;
        opcionesMostradas = new ListaOpciones(groupChoice.getOpcionesGrupoA());
        opcionesMostradas.agregarTodo(groupChoice.getOpcionesGrupoB());
        opcionesMostradas.desordenar();

        LayoutGroupChoice layoutGroupChoice = new LayoutGroupChoice(pregunta, this, jugador, manejadorDeTurnos);
        layout = layoutGroupChoice.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    public ListaOpciones getOpcionesMostradas() {return opcionesMostradas;}

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        Pane layout = (new LayoutGroupChoice(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
        manejadorDeTurnos.getStage().setScene(new Scene(layout));
    }
}
