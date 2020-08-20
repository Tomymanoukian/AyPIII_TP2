package edu.fiuba.algo3.vista.Escenas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import edu.fiuba.algo3.vista.Layouts.LayoutGroupChoice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vista.Constantes.COLOR_FONDO;

public class EscenaGroupChoice implements Escena {

    private VBox layout;
    private Pregunta pregunta;
    private ListaOpciones opcionesMostradas;
    private BarraDeMenu barraDeMenu;

    public EscenaGroupChoice(Pregunta unaPregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) unaPregunta;
        pregunta = unaPregunta;
        opcionesMostradas = new ListaOpciones(groupChoice.getOpcionesGrupoA());
        opcionesMostradas.agregarTodo(groupChoice.getOpcionesGrupoB());
        opcionesMostradas.desordenar();
        barraDeMenu = new BarraDeMenu(manejadorDeTurnos.getStage());

        LayoutGroupChoice layoutGroupChoice = new LayoutGroupChoice(pregunta, this, jugador, manejadorDeTurnos);

        layout = new VBox(barraDeMenu, layoutGroupChoice.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.TOP_CENTER);
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
        layoutConBarraDeMenu.setBackground(new Background(new BackgroundFill(Color.web(COLOR_FONDO), CornerRadii.EMPTY, Insets.EMPTY)));
        layoutConBarraDeMenu.setAlignment(Pos.TOP_CENTER);
        manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
    }
}
