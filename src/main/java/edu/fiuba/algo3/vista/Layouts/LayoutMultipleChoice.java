package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class LayoutMultipleChoice {

    protected Pane layout;
    protected RespuestaEnLista respuesta;
    protected ListaOpciones listaRespuestas;

    public Pane getLayout() {return layout;}

    public StackPane obtenerContenedorDeOpciones(ListaOpciones opcionesMostradas, ListaOpciones listaRespuestas){

        VBox checkBoxDeOpciones = new VBox();
        checkBoxDeOpciones.setAlignment(Pos.CENTER);

        int cantidadDeOpcionesAMostrar = opcionesMostradas.cantidadDeOpciones();

        for (int i = 0; i < cantidadDeOpcionesAMostrar; i++) {

            CheckBox checkBox = new CheckBox(opcionesMostradas.obtener(i).getOpcion());
            checkBox.setPadding(new Insets(5));

            checkBoxDeOpciones.getChildren().add(checkBox);

            checkBox.setIndeterminate(false);
            String opcion = opcionesMostradas.obtener(i).getOpcion();
            Puntaje puntaje = opcionesMostradas.obtener(i).getPuntaje();

            EventHandler<ActionEvent> event = e -> {

                if (checkBox.isSelected())
                    listaRespuestas.agregar(new Opcion(opcion, puntaje));
                else
                    listaRespuestas.eliminar(opcion);
            };

            checkBox.setOnAction(event);
        }

        Rectangle rectanguloOpciones = new Rectangle(20, 20, 250, 150);
        rectanguloOpciones.setFill(Color.LIGHTGRAY);

        StackPane contenedorOpciones = new StackPane(rectanguloOpciones, checkBoxDeOpciones);
        contenedorOpciones.setStyle("-fx-font-size: 1.2em;");

        return contenedorOpciones;
    }
}
