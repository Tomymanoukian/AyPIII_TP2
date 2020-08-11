package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.LinkedList;

public class LayoutOrderedChoice extends VBox {

    private Pane layout;

    public LayoutOrderedChoice() {
        //Comienza primer renglón
        Label nombreJugador = new Label("Jugador1");
        Label tiempo = new Label("00:00");
        Label bonusX2 = new Label("X2");
        Label bonusX3 = new Label("X3");
        Label exclusividad = new Label("Exclusividad");

        VBox contenedorNombreJugador = new VBox(nombreJugador);

        VBox contenedorTiempo = new VBox(tiempo);
        contenedorTiempo.setStyle("-fx-font-weight: bold");

        HBox contenedorBonus = new HBox(bonusX2, bonusX3, exclusividad);
        contenedorBonus.setSpacing(3);

        HBox contenedorPrimerRenglon = new HBox(contenedorNombreJugador, contenedorTiempo, contenedorBonus);
        contenedorPrimerRenglon.setAlignment(Pos.CENTER);
        contenedorPrimerRenglon.setStyle("-fx-font-size: 1.25em;");
        contenedorPrimerRenglon.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorPrimerRenglon.setSpacing(40);
        contenedorPrimerRenglon.setPadding(new Insets(10));

        //Comienza cuadro de consigna

        Label consigna = new Label("Ordene los siguientes números:");
        consigna.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 300, 100);
        rectanguloConsigna.setFill(Color.LAVENDER);

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(15));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        //Comienzan Opciones

        ArrayList<HBox> listaHBoxOpciones = new ArrayList<>();

/* Así debería ser.
        for (int i=0; i < 5; i++) {
            listaHBoxOpciones.add(new HBox(unOrderedChoice.getPosition(i)));
        }
*/
        listaHBoxOpciones.add(new HBox (new Button("▼"), new Label ("Numero 1"), new Button("▲")));
        listaHBoxOpciones.add(new HBox (new Button("▼"), new Label ("Numero 2"), new Button("▲")));
        listaHBoxOpciones.add(new HBox (new Button("▼"), new Label ("Numero 3"), new Button("▲")));
        listaHBoxOpciones.add(new HBox (new Button("▼"), new Label ("Numero 4"), new Button("▲")));
        listaHBoxOpciones.add(new HBox (new Button("▼"), new Label ("Numero 5"), new Button("▲")));

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.getChildren().addAll(listaHBoxOpciones);

        for (int i=0; i<5; i++) {
            listaHBoxOpciones.get(i).setAlignment(Pos.CENTER);
        }

        HBox enviar = new HBox (new Button ("Enviar"));
        enviar.setAlignment(Pos.CENTER);

        contenedorOpciones.setAlignment(Pos.CENTER);

        layout = new VBox(contenedorPrimerRenglon, contenedorConsigna, contenedorOpciones, enviar);
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}

    public void mostrarVista(Pane unosLayouts) {

        unosLayouts.getChildren().forEach(element -> element.setVisible(false));
        layout.setVisible(true);
    }
}
