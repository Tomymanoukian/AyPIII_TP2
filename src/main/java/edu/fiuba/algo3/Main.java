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

        OrderedChoice orderedChoice = new OrderedChoice("Ordered Choice 1", listaOpciones);

        OrderedChoice orderedChoice1 = new OrderedChoice("Ordered Choice 2", listaOpciones);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        ////////////Termina creacion de objetos para hacer pruebas de la vista OrderedChoice

        ////////////Empieza creacion de objetos para hacer pruebas de la vista GroupChoice

        ListaOpciones listaGrupoA = new ListaOpciones();
        ListaOpciones listaGrupoB = new ListaOpciones();

        Opcion opcionA = new Opcion("Letra A");
        Opcion opcionB = new Opcion("Letra B");
        Opcion opcionC = new Opcion("Letra C");
        Opcion opcionD = new Opcion("Letra D");
        Opcion opcionE = new Opcion("Letra E");
        Opcion opcionF = new Opcion("Letra F");

        //ListaOpciones listaGrupoA = new

        ////////////Termina creacion de objetos para hacer pruebas de la vista GroupChoice



        Kahoot kahoot = new Kahoot(jugador1, jugador2);

        Stack<Pregunta> unStack = new Stack<>();
        unStack.add(orderedChoice);
        unStack.add(orderedChoice1);

        ManejadorDeTurnos unManejadorDeTurnos = new ManejadorDeTurnos(unStack, jugador1, jugador2, kahoot, stage);

        unManejadorDeTurnos.mostrarSiguientePregunta();

        stage.setTitle("Kahoot!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
