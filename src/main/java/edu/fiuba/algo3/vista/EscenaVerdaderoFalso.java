package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.beans.property.ListProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class EscenaVerdaderoFalso implements Escena{

    private Pane layout;
    private Pregunta pregunta;

    public EscenaVerdaderoFalso(Pregunta unaPregunta, Jugador unJugador, ManejadorDeTurnos manejadorDeTurnos){
        pregunta = unaPregunta;

        LayoutVerdaderoFalso layoutVerdaderoFalso = new LayoutVerdaderoFalso(pregunta, this , unJugador, manejadorDeTurnos);
        layout = layoutVerdaderoFalso.getLayout();
    }

    @Override
    public Scene getEscena() { return (new Scene(layout)); }

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {
        Pane layout = (new LayoutVerdaderoFalso(pregunta, this, jugador, manejadorDeTurnos, unaEtiquetaTiempo)).getLayout();
        manejadorDeTurnos.getStage().setScene(new Scene(layout));
    }
}
