package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MockLecturaDeArchivoDePreguntas {

    private VerdaderoFalsoClasico verdaderoFalsoClasico;
    private VerdaderoFalsoConPenalidad  verdaderoFalsoConPenalidad;
    private OrderedChoice orderedChoice;
    private OrderedChoice orderedChoice1;
    private GroupChoice groupChoice;
    private MultipleChoiceClasico multipleChoiceClasico;
    private MultipleChoiceParcial multipleChoiceParcial;
    private MultipleChoiceConPenalidad multipleChoiceConPenalidad;

    public MockLecturaDeArchivoDePreguntas() {


        ////////////Empieza creacion de objetos para hacer pruebas de la vista VerdaderoFalso
        String consignaVoF = "Elegir Verdadero o Falso";

        verdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero(consignaVoF);
        verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consignaVoF);
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

        orderedChoice = new OrderedChoice("Ordered Choice 1", listaOpciones);

        orderedChoice1 = new OrderedChoice("Ordered Choice 2", listaOpciones);

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

        listaGrupoA.agregar(opcionA);
        listaGrupoA.agregar(opcionE);
        listaGrupoB.agregar(opcionB);
        listaGrupoB.agregar(opcionC);
        listaGrupoB.agregar(opcionD);
        listaGrupoB.agregar(opcionF);

        groupChoice = new GroupChoice("Agrupe en vocales y consonantes", "Vocales", listaGrupoA, "Consonantes", listaGrupoB);

        ////////////Termina creacion de objetos para hacer pruebas de la vista GroupChoice

        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", new Puntaje(1));
        Opcion opcionCorrectaMarte = new Opcion("Marte", new Puntaje(1));
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", new Puntaje(1));
        Opcion opcionInorrectaAzul = new Opcion("Azul", new Puntaje(0));
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", new Puntaje(0));

        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionInorrectaAzul, opcionIncorrectaAmarillo));

        multipleChoiceClasico = new MultipleChoiceClasico("Multiple Choice Clasico", opcionesCorrectas, opcionesIncorrectas);
        multipleChoiceConPenalidad = new MultipleChoiceConPenalidad("Multiple Choice con penalidad", opcionesCorrectas, opcionesIncorrectas);
        multipleChoiceParcial = new MultipleChoiceParcial("Multiple Choice Parcial", opcionesCorrectas, opcionesIncorrectas);

    }

    public ArrayList<Pregunta> getListaDePreguntas(){
        ArrayList<Pregunta> lista = new ArrayList<>();
        lista.add(verdaderoFalsoClasico);
        lista.add(orderedChoice);
        lista.add(orderedChoice1);
        lista.add(groupChoice);
        lista.add(multipleChoiceClasico);
        lista.add(multipleChoiceConPenalidad);
        return lista;
    }

    public Stack<Pregunta> getPilaDePreguntas() {
        Stack<Pregunta> pila = new Stack<>();
        pila.add(orderedChoice);
        //pila.add(orderedChoice1);
        pila.add(groupChoice);
        pila.add(multipleChoiceClasico);
        pila.add(multipleChoiceConPenalidad);
        pila.add(multipleChoiceParcial);
        //pila.add(verdaderoFalsoConPenalidad);
        //pila.add(verdaderoFalsoClasico);
        return pila;
    }
}
