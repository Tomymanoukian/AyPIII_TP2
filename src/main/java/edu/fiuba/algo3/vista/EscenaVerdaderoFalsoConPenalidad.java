package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.ManejadorDeTurnos;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaVerdaderoFalsoConPenalidad implements Escena{
    private Pane layout;

    public EscenaVerdaderoFalsoConPenalidad(Pregunta pregunta, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        LayoutVerdaderoFalso layoutVerdaderoFalso = new LayoutVerdaderoFalso(pregunta, jugador, manejadorDeTurnos);
        layout = layoutVerdaderoFalso.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }

    @Override
    public void actualizar(Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

    }
}
