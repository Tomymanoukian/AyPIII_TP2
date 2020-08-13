package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EscenaVerdaderoFalsoClasico implements Escena{

    private Pane layout;

    public EscenaVerdaderoFalsoClasico(Pregunta pregunta, Jugador jugador, Kahoot kahoot, Stage stage) {

        //LayoutVerdaderoFalso layoutVerdaderoFalso = new LayoutVerdaderoFalso(pregunta, jugador, kahoot, stage);
        //layout = layoutVerdaderoFalso.getLayout();
    }

    @Override
    public Scene getEscena() {
        return (new Scene(layout));
    }
}
