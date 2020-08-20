package edu.fiuba.algo3.vista.Escenas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import edu.fiuba.algo3.vista.Layouts.LayoutOrderedChoice;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EscenaOrderedChoice implements Escena {

    private Pane layout;
    private Pregunta pregunta;
    private ListaOpciones opcionesMostradas;
    private BarraDeMenu barraDeMenu;

    public EscenaOrderedChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        OrderedChoice orderedChoice = (OrderedChoice)unaPregunta;
        pregunta = unaPregunta;
        opcionesMostradas = new ListaOpciones(orderedChoice.getOpcionesDesordenadas());
        barraDeMenu = new BarraDeMenu(manejadorDeTurnos.getStage());

        LayoutOrderedChoice layoutOrderedChoice = new LayoutOrderedChoice(pregunta, this, jugador, manejadorDeTurnos);
        layout = new VBox(barraDeMenu, layoutOrderedChoice.getLayout());
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    public ListaOpciones getOpcionesMostradas() {return opcionesMostradas;}

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        Pane layout = (new LayoutOrderedChoice(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
        VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
        manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
    }
}
