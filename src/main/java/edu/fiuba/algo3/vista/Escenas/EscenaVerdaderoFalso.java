package edu.fiuba.algo3.vista.Escenas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import edu.fiuba.algo3.vista.Layouts.LayoutVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.vista.Layouts.LayoutVerdaderoFalsoSinPenalidad;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EscenaVerdaderoFalso implements Escena {

    private Pane layout;
    private Pregunta pregunta;
    private BarraDeMenu barraDeMenu;

    public EscenaVerdaderoFalso(Pregunta unaPregunta, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos){

        pregunta = unaPregunta;
        barraDeMenu = new BarraDeMenu();

        if(pregunta.getClass().getSimpleName().equals(VerdaderoFalsoClasico.class.getSimpleName())) {
            LayoutVerdaderoFalsoSinPenalidad layoutVerdaderoFalso = new LayoutVerdaderoFalsoSinPenalidad(pregunta, this, unJugador, manejadorDeTurnos);
            layout = new VBox(barraDeMenu, layoutVerdaderoFalso.getLayout());
        }
        if(pregunta.getClass().getSimpleName().equals(VerdaderoFalsoConPenalidad.class.getSimpleName())) {
            LayoutVerdaderoFalsoConPenalidad layoutVerdaderoFalso = new LayoutVerdaderoFalsoConPenalidad(pregunta, this, unJugador, manejadorDeTurnos);
            layout = new VBox(barraDeMenu, layoutVerdaderoFalso.getLayout());
        }
    }

    @Override
    public Scene getEscena() { return (new Scene(layout));}

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        if(pregunta.getClass().getSimpleName().equals(VerdaderoFalsoClasico.class.getSimpleName())) {
            Pane layout = (new LayoutVerdaderoFalsoSinPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            manejadorDeTurnos.getStage().setScene(new Scene(layout));
        }
        if(pregunta.getClass().getSimpleName().equals(VerdaderoFalsoConPenalidad.class.getSimpleName())) {
            Pane layout = (new LayoutVerdaderoFalsoConPenalidad(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
            VBox layoutConBarraDeMenu = new VBox(barraDeMenu, layout);
            manejadorDeTurnos.getStage().setScene(new Scene(layoutConBarraDeMenu));
        }
    }
}
