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

import static edu.fiuba.algo3.vista.Constantes.*;

public class LayoutGroupChoice {

    private VBox layout;
    private RespuestaDeGrupos respuesta;

    public LayoutGroupChoice(Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        respuesta = new RespuestaDeGrupos(new ListaOpciones(), new ListaOpciones());

        EtiquetaTiempo unaEtiquetaTiempo = new EtiquetaTiempo(jugador, respuesta, manejadorDeTurnos);

        this.crearLayout(pregunta, escenaGroupChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    public LayoutGroupChoice(Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo) {

        respuesta = new RespuestaDeGrupos(new ListaOpciones(), new ListaOpciones());

        this.crearLayout(pregunta, escenaGroupChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);
    }

    public Pane getLayout() {
        return layout;
    }

    private VBox obtenerContenedorDeOpciones(GroupChoice groupChoice, ListaOpciones listaOpciones, ArrayList<HBox> listaHBox) {

        Label opcion = new Label("Opciones");
        Label grupo1 = new Label (groupChoice.getNombreGrupoA());
        Label grupo2 = new Label (groupChoice.getNombreGrupoB());

        opcion.setPrefWidth(ANCHO_OPCION-ANCHO_GRUPO*2);
        opcion.setAlignment(Pos.CENTER);
        grupo1.setPrefWidth(ANCHO_GRUPO);
        grupo1.setAlignment(Pos.CENTER);
        grupo2.setPrefWidth(ANCHO_GRUPO);
        grupo2.setAlignment(Pos.CENTER);

        HBox contenedorGrupos = new HBox(opcion, grupo1, grupo2);

        contenedorGrupos.setBackground(new Background(new BackgroundFill(Color.web(COLOR_GRUPOS), CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorGrupos.setMinSize(ANCHO_OPCION, 30);
        contenedorGrupos.setMaxSize(ANCHO_OPCION, 30);
        contenedorGrupos.setAlignment(Pos.CENTER_RIGHT);

        for (int i = 0; i < listaOpciones.cantidadDeOpciones(); i++) {

            ToggleGroup grupoDeBotones = new ToggleGroup();

            RadioButton botonGrupoA = new RadioButton();
            botonGrupoA.setToggleGroup(grupoDeBotones);
            botonGrupoA.setOnAction(new BotonAsignarGrupoHandler(listaOpciones.obtener(i), respuesta.getOpcionesSeleccionadasGrupoB(), respuesta.getOpcionesSeleccionadasGrupoA()));

            HBox contenedorBotonGrupoA = new HBox (botonGrupoA);
            contenedorBotonGrupoA.setPrefWidth(ANCHO_GRUPO);
            contenedorBotonGrupoA.setAlignment(Pos.CENTER);

            RadioButton botonGrupoB = new RadioButton();
            botonGrupoB.setToggleGroup(grupoDeBotones);
            botonGrupoB.setOnAction(new BotonAsignarGrupoHandler(listaOpciones.obtener(i), respuesta.getOpcionesSeleccionadasGrupoA(), respuesta.getOpcionesSeleccionadasGrupoB()));

            HBox contenedorBotonGrupoB = new HBox (botonGrupoB);
            contenedorBotonGrupoB.setPrefWidth(ANCHO_GRUPO);
            contenedorBotonGrupoB.setAlignment(Pos.CENTER);

            Label nombreOpcion = new Label(listaOpciones.obtener(i).getOpcion());
            nombreOpcion.setPrefWidth(ANCHO_OPCION-ANCHO_GRUPO*2-10);
            nombreOpcion.setAlignment(Pos.CENTER_LEFT);

            HBox linea = new HBox(nombreOpcion, contenedorBotonGrupoA, contenedorBotonGrupoB);

            linea.setBackground(new Background(new BackgroundFill(Color.web(COLOR_OPCIONES), CornerRadii.EMPTY, Insets.EMPTY)));
            linea.setMinSize(ANCHO_OPCION, 30);
            linea.setMaxSize(ANCHO_OPCION, 30);
            linea.setAlignment(Pos.CENTER_RIGHT);

            listaHBox.add(linea);
        }

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.getChildren().addAll(contenedorGrupos);
        contenedorOpciones.getChildren().addAll(listaHBox);

        contenedorOpciones.setBackground(new Background(new BackgroundFill(Color.web(COLOR_CONTENEDOR_CONSIGNA), CornerRadii.EMPTY, new Insets(-20))));
        contenedorOpciones.setMaxWidth(ANCHO_OPCION);
        contenedorOpciones.setAlignment(Pos.CENTER);

        return contenedorOpciones;
    }

    private void crearLayout(Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos, EtiquetaTiempo unaEtiquetaTiempo){

        GroupChoice groupChoice = (GroupChoice) pregunta;

        ListaOpciones listaOpciones = escenaGroupChoice.getOpcionesMostradas();

        ArrayList<HBox> listaHBox = new ArrayList<>();

        VBox contenedorOpciones = this.obtenerContenedorDeOpciones(groupChoice, listaOpciones, listaHBox);

        ContenedorPrimerReglonPreguntaSinPenalidad contenedorPrimerRenglon = new ContenedorPrimerReglonPreguntaSinPenalidad((PreguntaSinPenalidad) pregunta, escenaGroupChoice, jugador, manejadorDeTurnos, unaEtiquetaTiempo);

        ContenedorConsigna contenedorConsigna = new ContenedorConsigna(pregunta);

        ContenedorBotonEnviar contenedorBotonEnviar = new ContenedorBotonEnviar(jugador, respuesta, manejadorDeTurnos, contenedorPrimerRenglon.getTiempo());

        //Se crea el layout final

        layout = new VBox(contenedorPrimerRenglon.getLayout(), contenedorConsigna.getLayout(), contenedorOpciones, contenedorBotonEnviar.getLayout());
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.TOP_CENTER);
    }
}