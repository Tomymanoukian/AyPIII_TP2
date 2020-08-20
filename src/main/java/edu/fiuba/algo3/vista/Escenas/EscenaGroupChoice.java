package edu.fiuba.algo3.vista.Escenas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import edu.fiuba.algo3.vista.Layouts.LayoutGroupChoice;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EscenaGroupChoice implements Escena {

    private Pane layout;
    private Pregunta pregunta;
    private ListaOpciones opcionesMostradas;
    private BarraDeMenu barraDeMenu;

    public EscenaGroupChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) unaPregunta;
        pregunta = unaPregunta;
        opcionesMostradas = new ListaOpciones(groupChoice.getOpcionesGrupoA());
        opcionesMostradas.agregarTodo(groupChoice.getOpcionesGrupoB());
        opcionesMostradas.desordenar();
        barraDeMenu = new BarraDeMenu();

        LayoutGroupChoice layoutGroupChoice = new LayoutGroupChoice(pregunta, this, jugador, manejadorDeTurnos);

        layout = new VBox(barraDeMenu, layoutGroupChoice.getLayout());
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    public ListaOpciones getOpcionesMostradas() {return opcionesMostradas;}

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        Pane layout = (new LayoutGroupChoice(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
        VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
        manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
    }
}
