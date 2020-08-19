package edu.fiuba.algo3.vista.Layouts;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaSinPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaDeGrupos;
import edu.fiuba.algo3.vista.Contenedores.ContenedorBotonEnviar;
import edu.fiuba.algo3.vista.Contenedores.ContenedorConsigna;
import edu.fiuba.algo3.vista.Contenedores.ContenedorPrimerReglonPreguntaSinPenalidad;
import edu.fiuba.algo3.vista.Escenas.EscenaGroupChoice;
import edu.fiuba.algo3.vista.EtiquetaTiempo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class LayoutGroupChoice {

    private Pane layout;

    public LayoutGroupChoice(Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) pregunta;

        ListaOpciones listaOpciones = escenaGroupChoice.getOpcionesMostradas();

        ArrayList<HBox> listaHBox = new ArrayList<>();

        RespuestaDeGrupos respuesta = new RespuestaDeGrupos(new ListaOpciones(), new ListaOpciones());

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(groupChoice, listaOpciones, respuesta, listaHBox);

        ContenedorPrimerReglonPreguntaSinPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaSinPenalidad((PreguntaSinPenalidad) pregunta, escenaGroupChoice, jugador, manejadorDeTurnos, respuesta);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        HBox contenedorGrupos = new HBox(new Label("Grupo"), new Label (groupChoice.getNombreGrupoA()), new Label (groupChoice.getNombreGrupoB()));
        contenedorGrupos.setAlignment(Pos.CENTER);

        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        //Se crea el layout final

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorGrupos, contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public LayoutGroupChoice(Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        GroupChoice groupChoice = (GroupChoice) pregunta;

        ListaOpciones listaOpciones = escenaGroupChoice.getOpcionesMostradas();

        ArrayList<HBox> listaHBox = new ArrayList<>();

        RespuestaDeGrupos respuesta = new RespuestaDeGrupos(new ListaOpciones(), new ListaOpciones());

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(groupChoice, listaOpciones, respuesta, listaHBox);

        ContenedorPrimerReglonPreguntaSinPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaSinPenalidad((PreguntaSinPenalidad) pregunta, escenaGroupChoice, jugador, manejadorDeTurnos, respuesta, unaEtiquetaTiempo);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        HBox contenedorGrupos = new HBox(new Label("Grupo"), new Label (groupChoice.getNombreGrupoA()), new Label (groupChoice.getNombreGrupoB()));
        contenedorGrupos.setAlignment(Pos.CENTER);

        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        //Se crea el layout final

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorGrupos, contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {
        return layout;
    }

    private VBox obtenerContenedorDeOpciones(GroupChoice groupChoice, ListaOpciones listaOpciones, RespuestaDeGrupos respuesta, ArrayList<HBox> listaHBox) {

        HBox nombresGrupos = new HBox(10, new Label("Opciones:"), new Label(groupChoice.getNombreGrupoA(), new Label(groupChoice.getNombreGrupoB())));
        nombresGrupos.setAlignment(Pos.CENTER);

        for (int i = 0; i < listaOpciones.cantidadDeOpciones(); i++) {

            ToggleGroup grupoDeBotones = new ToggleGroup();

            RadioButton botonGrupoA = new RadioButton();
            botonGrupoA.setToggleGroup(grupoDeBotones);
            botonGrupoA.setOnAction(new BotonAsignarGrupoHandler(listaOpciones.obtener(i), respuesta.getOpcionesSeleccionadasGrupoB(), respuesta.getOpcionesSeleccionadasGrupoA()));

            RadioButton botonGrupoB = new RadioButton();
            botonGrupoB.setToggleGroup(grupoDeBotones);
            botonGrupoB.setOnAction(new BotonAsignarGrupoHandler(listaOpciones.obtener(i), respuesta.getOpcionesSeleccionadasGrupoA(), respuesta.getOpcionesSeleccionadasGrupoB()));

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