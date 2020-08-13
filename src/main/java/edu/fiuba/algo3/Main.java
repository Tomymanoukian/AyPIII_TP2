package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage stage) {   ////////////Empieza creacion de objetos para hacer pruebas de la vista VerdaderoFalso
        String consignaVoF = "Elegir Verdadero o Falso";

        VerdaderoFalsoClasico verdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero(consignaVoF);
        ///////////Termina creacion de objetos para hacer pruebas de la vista OrderedChoice
        ////////////Empieza creacion de objetos para hacer pruebas de la vista OrderedChoice
        String consigna = "Ordene los siguientes números:";

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

        OrderedChoice orderedChoice = new OrderedChoice(consigna, listaOpciones);

        OrderedChoice orderedChoice1 = new OrderedChoice("Coso 2", listaOpciones);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        ///////////Termina creacion de objetos para hacer pruebas de la vista OrderedChoice

        Kahoot kahoot = new Kahoot(jugador1, jugador2);

        Stack<Pregunta> unStack = new Stack<>();
        unStack.add(orderedChoice);
        unStack.add(orderedChoice1);

        ManejadorDeTurnos unManejadorDeTurnos = new ManejadorDeTurnos(unStack, jugador1, jugador2, kahoot, stage);

        unManejadorDeTurnos.mostrarSiguientePregunta();

        //stage.setScene(new Scene((new LayoutMenuBienvenida()).getLayout()));
/*
        LayoutVerdaderoFalso vistaVerdaderoFalso = new LayoutVerdaderoFalso(kahoot.getJugador1(), verdaderoFalsoClasico.getOpcionCorrecta(), verdaderoFalsoClasico.getOpcionIncorrecta(), kahoot);
        LayoutMenuBienvenida vistaBienvenida = new LayoutMenuBienvenida();
        LayoutOrderedChoice vistaOrderedChoice = new LayoutOrderedChoice(orderedChoice.desordenarOpciones(), kahoot.getJugador1(), kahoot, stage);
        LayoutPuntuaciones vistaPuntuaciones = new LayoutPuntuaciones();
        LayoutMultipleChoice vistaMultipleChoice = new LayoutMultipleChoice();

        Pane layout = new Pane();
        layout.getChildren().addAll(vistaBienvenida.getLayout(), vistaVerdaderoFalso.getLayout(), vistaOrderedChoice.getLayout(), vistaPuntuaciones.getLayout(), vistaMultipleChoice.getLayout());

        vistaOrderedChoice.mostrarVista(layout);

        Scene scene = new Scene(layout, 390, 400);
*/
        stage.setTitle("Kahoot!");
        //stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
