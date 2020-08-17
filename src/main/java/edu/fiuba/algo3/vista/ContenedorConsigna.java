package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pregunta;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ContenedorConsigna {

    private VBox layout;

    public ContenedorConsigna(Pregunta pregunta) {

        Rectangle rectanguloTipoDePregunta = new Rectangle(10, 20, 200, 50);
        rectanguloTipoDePregunta.setFill(Color.LIGHTSTEELBLUE);

        Label tipoDePregunta = new Label(pregunta.getClass().getSimpleName());

        StackPane contenedorTipoDePregunta = new StackPane(rectanguloTipoDePregunta, tipoDePregunta);
        contenedorTipoDePregunta.setPadding(new Insets(10));
        contenedorTipoDePregunta.setStyle("-fx-font-size: 1em;");

        Label consigna = new Label(pregunta.getConsigna());
        consigna.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 300, 100);
        rectanguloConsigna.setFill(Color.LAVENDER);

        StackPane contenedorConsinga = new StackPane(rectanguloConsigna, consigna);
        contenedorConsinga.setPadding(new Insets(10));
        contenedorConsinga.setStyle("-fx-font-size: 1.3em;");

        layout = new VBox(contenedorTipoDePregunta, contenedorConsinga);
        layout.setPadding(new Insets(10));

    }

    public VBox getLayout() {
        return layout;
    }
}
