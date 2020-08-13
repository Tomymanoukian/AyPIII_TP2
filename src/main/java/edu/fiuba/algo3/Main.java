package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {   ////////////Empieza creacion de objetos para hacer pruebas de la vista VerdaderoFalso
        String consignaVoF = "Elegir Verdadero o Falso";
        VerdaderoFalsoClasico verdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero(consignaVoF);
        ////////////Empieza creacion de objetos para hacer pruebas de la vista VerdaderoFalso

        ///////////Termina creacion de objetos para hacer pruebas de la vista OrderedChoice
        String consignaOrdered = "Ordene los siguientes números:";

        ListaOpciones listaOpciones = new ListaOpciones();

        Opcion opcion1 = new Opcion("Numero 1");
        Opcion opcion2 = new Opcion("Numero 2");
        Opcion opcion3 = new Opcion("Numero 3");
        Opcion opcion4 = new Opcion("Numero 4");
        Opcion opcion5 = new Opcion("Numero 5");

        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);
        listaOpciones.agregar(opcion3);
        listaOpciones.agregar(opcion4);
        listaOpciones.agregar(opcion5);

        OrderedChoice orderedChoice = new OrderedChoice(consignaOrdered, listaOpciones);
        ////////////Empieza creacion de objetos para hacer pruebas de la vista OrderedChoice

        ////////////Empieza creacion de objetos para hacer pruebas de la vista MultipleChoice
        ListaOpciones listaOpcionesCorrectas = new ListaOpciones();
        listaOpcionesCorrectas.agregar(opcion1);
        listaOpcionesCorrectas.agregar(opcion3);
        listaOpcionesCorrectas.agregar(opcion5);

        ListaOpciones listaOpcionesIncorrectas = new ListaOpciones();
        listaOpcionesCorrectas.agregar(opcion2);
        listaOpcionesCorrectas.agregar(opcion4);

        String consignaMultipleChoice = "Elija numeros impares";
        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consignaMultipleChoice, listaOpcionesCorrectas, listaOpcionesIncorrectas);

        ////////////Empieza creacion de objetos para hacer pruebas de la vista MultipleChoice


        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        ///////////Termina creacion de objetos para hacer pruebas de la vista OrderedChoice

        Kahoot kahoot = new Kahoot(jugador1, jugador2);

        LayoutVerdaderoFalso vistaVerdaderoFalso = new LayoutVerdaderoFalso(verdaderoFalsoClasico, kahoot.getJugador1(), kahoot, stage);
        LayoutMenuBienvenida vistaBienvenida = new LayoutMenuBienvenida();
        LayoutOrderedChoice vistaOrderedChoice = new LayoutOrderedChoice(orderedChoice.desordenarOpciones(), kahoot.getJugador1(), kahoot, stage);
        LayoutPuntuaciones vistaPuntuaciones = new LayoutPuntuaciones();
        LayoutMultipleChoice vistaMultipleChoice = new LayoutMultipleChoice(multipleChoiceClasico, kahoot.getJugador1(), kahoot, stage);

        Pane layout = new Pane();
        layout.getChildren().addAll(vistaBienvenida.getLayout(), vistaVerdaderoFalso.getLayout(), vistaOrderedChoice.getLayout(), vistaPuntuaciones.getLayout(), vistaMultipleChoice.getLayout());

        vistaMultipleChoice.mostrarVista(layout);

        Scene scene = new Scene(layout, 390, 400);

        stage.setTitle("Kahoot!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
