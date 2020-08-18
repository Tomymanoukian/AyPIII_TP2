package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class LayoutGroupChoice {

    private Pane layout;

    public LayoutGroupChoice(Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) pregunta;

        ListaOpciones listaOpciones = escenaGroupChoice.getOpcionesMostradas();

        ArrayList<HBox> listaHBox = new ArrayList<>();

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(groupChoice, listaOpciones, listaHBox);

        RespuestaDeGrupos respuestaDeGrupos = new RespuestaDeGrupos(new ListaOpciones(), new ListaOpciones());

        ContenedorPrimerReglon contenedorPrimerRenglon = new ContenedorPrimerReglon(pregunta, escenaGroupChoice, jugador, manejadorDeTurnos, respuestaDeGrupos);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        HBox contenedorGrupos = new HBox(new Label("Grupo"), new Label (groupChoice.getNombreGrupoA()), new Label (groupChoice.getNombreGrupoB()));
        contenedorGrupos.setAlignment(Pos.CENTER);

        ContenedorBotonEnviarGroupChoice contenedorBotonEnviarGroupChoice = new ContenedorBotonEnviarGroupChoice(jugador, listaOpciones, listaHBox, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        //Se crea el layout final

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorGrupos, contenedorOpciones, contenedorBotonEnviarGroupChoice.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {
        return layout;
    }

    private VBox obtenerContenedorDeOpciones(GroupChoice groupChoice, ListaOpciones listaOpciones, ArrayList<HBox> listaHBox) {

        HBox nombresGrupos = new HBox(10, new Label("Opciones:"), new Label(groupChoice.getNombreGrupoA(), new Label(groupChoice.getNombreGrupoB())));
        nombresGrupos.setAlignment(Pos.CENTER);

        for (int i = 0; i < listaOpciones.cantidadDeOpciones(); i++) {

            ToggleGroup grupoDeBotones = new ToggleGroup();
            RadioButton botonGrupoA = new RadioButton();
            botonGrupoA.setToggleGroup(grupoDeBotones);
            RadioButton botonGrupoB = new RadioButton();
            botonGrupoB.setToggleGroup(grupoDeBotones);

            listaHBox.add(new HBox(10, new Label(listaOpciones.obtener(i).getOpcion()), botonGrupoA, botonGrupoB));
            listaHBox.get(i).setAlignment(Pos.CENTER);
        }

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.setPadding(new Insets(10));
        contenedorOpciones.getChildren().addAll(listaHBox);
        contenedorOpciones.setAlignment(Pos.CENTER);

        return contenedorOpciones;
    }
}