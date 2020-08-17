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

    public LayoutGroupChoice (Pregunta pregunta, EscenaGroupChoice escenaGroupChoice, Jugador jugador, ManejadorDeTurnos manejadorDeTurnos) {

        GroupChoice groupChoice = (GroupChoice) pregunta;

        //Comienza primer renglón
        Label nombreJugador = new Label(jugador.getNombre());
        Label tiempo = new Label("00:00");

        Button bonusX2 = new Button("X2");
        bonusX2.setDisable(true);

        Button bonusX3 = new Button("X3");
        bonusX3.setDisable(true);

        Button exclusividad = new Button("Ex");
        BotonExclusividadHandler exclusividadHandler = new BotonExclusividadHandler(groupChoice, escenaGroupChoice, jugador, manejadorDeTurnos);
        exclusividad.setOnAction(exclusividadHandler);
        if (jugador.getExclusividades().size()==0)
            exclusividad.setDisable(true);

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

        Label consigna = new Label(groupChoice.getConsigna());
        consigna.setStyle("-fx-font-weight: bold");

        Rectangle rectanguloConsigna = new Rectangle(20, 20, 300, 100);
        rectanguloConsigna.setFill(Color.LAVENDER);

        StackPane contenedorConsigna = new StackPane(rectanguloConsigna, consigna);
        contenedorConsigna.setPadding(new Insets(15));
        contenedorConsigna.setStyle("-fx-font-size: 1.3em;");

        //Comienzan Opciones

        ListaOpciones listaOpciones = escenaGroupChoice.getOpcionesMostradas();

        ArrayList<HBox> listaHBox = new ArrayList<>();

        HBox nombresGrupos = new HBox (10, new Label ("Opciones:"), new Label (groupChoice.getNombreGrupoA(), new Label (groupChoice.getNombreGrupoB())));
        nombresGrupos.setAlignment(Pos.CENTER);

        for (int i = 0; i < listaOpciones.cantidadDeOpciones(); i++) {

            ToggleGroup grupoDeBotones = new ToggleGroup();
            RadioButton botonGrupoA = new RadioButton ();
            botonGrupoA.setToggleGroup(grupoDeBotones);
            RadioButton botonGrupoB = new RadioButton ();
            botonGrupoB.setToggleGroup(grupoDeBotones);

            listaHBox.add(new HBox (10, new Label (listaOpciones.obtener(i).getOpcion()), botonGrupoA, botonGrupoB));
            listaHBox.get(i).setAlignment(Pos.CENTER);
        }

        VBox contenedorOpciones = new VBox(10);
        contenedorOpciones.getChildren().addAll(listaHBox);
        contenedorOpciones.setAlignment(Pos.CENTER);

        /////////////////Se crea la respuesta dada

        ListaOpciones respuestaGrupoA = new ListaOpciones();
        ListaOpciones respuestaGrupoB = new ListaOpciones();

        for (int i = 0; i < listaOpciones.cantidadDeOpciones(); i++) {

            if(((RadioButton)listaHBox.get(i).getChildren().get(1)).isArmed())
                respuestaGrupoA.agregar(listaOpciones.obtener(i));

            else if (((RadioButton)listaHBox.get(i).getChildren().get(2)).isArmed())
                respuestaGrupoB.agregar(listaOpciones.obtener(i));
        }

        RespuestaDeGrupos respuestaDeGrupos = new RespuestaDeGrupos(respuestaGrupoA, respuestaGrupoB);

        /////////////////

        Button botonEnviar = new Button ("Enviar");
        BotonEnviarHandler enviarHandler = new BotonEnviarHandler (jugador, respuestaDeGrupos, manejadorDeTurnos);
        botonEnviar.setOnAction(enviarHandler);

        HBox enviar = new HBox (botonEnviar);
        enviar.setAlignment(Pos.CENTER);

        //Se crea el layout final

        layout = new VBox(20,contenedorPrimerRenglon, contenedorConsigna, contenedorOpciones, enviar);
        layout.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Pane getLayout() {return layout;}
}

