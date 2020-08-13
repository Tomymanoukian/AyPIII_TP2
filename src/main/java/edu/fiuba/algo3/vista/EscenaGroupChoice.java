package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaGroupChoice implements Escena {
    private Pane layout;
    private Pregunta pregunta;
    private ListaOpciones opcionesGrupoAMostradas;
    private ListaOpciones opcionesCentroMostradas;
    private ListaOpciones opcionesGrupoBMostradas;


    public EscenaGroupChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) unaPregunta;
        pregunta = unaPregunta;
        opcionesCentroMostradas = new ListaOpciones(groupChoice.getOpcionesGrupoA());
        opcionesCentroMostradas.agregarTodo(groupChoice.getOpcionesGrupoB());
        opcionesCentroMostradas.desordenar();

        LayoutGroupChoice layoutGroupChoice = new LayoutGroupChoice(unaPregunta, this, jugador, manejadorDeTurnos);
        layout = layoutGroupChoice.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

//    public ListaOpciones getOpcionesMostradas() {return opcionesMostradas;}

    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        Pane layout = (new LayoutGroupChoice(pregunta, this, jugador, manejadorDeTurnos)).getLayout();
        manejadorDeTurnos.getStage().setScene(new Scene(layout));
    }
}
