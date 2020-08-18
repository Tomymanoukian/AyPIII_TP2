package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MockLecturaDeArchivoDePreguntas {

    private VerdaderoFalsoClasico verdaderoFalsoClasico;
    private VerdaderoFalsoConPenalidad  verdaderoFalsoConPenalidad;
    private OrderedChoice orderedChoice;
    private GroupChoice groupChoice;
    private MultipleChoiceClasico multipleChoiceClasico;
    private MultipleChoiceParcial multipleChoiceParcial;
    private MultipleChoiceConPenalidad multipleChoiceConPenalidad;

    public MockLecturaDeArchivoDePreguntas() {


        ////////////Empieza creacion de objetos para hacer pruebas de la vista VerdaderoFalso
        String consignaVoF1 = "Consigna verdadera";
        String consignaVoF2 = "Consigna falsa";

        verdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero(consignaVoF1);
        verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consignaVoF2);
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

        ////////////Empieza creacion de objetos para hacer pruebas de la vista MultipleChoiceParcial
        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionTierraParcial = new Opcion("Tierra", new Puntaje(1));
        Opcion opcionMarteParcial = new Opcion("Marte", new Puntaje(1));
        Opcion opcionJupiterParcial = new Opcion("Jupiter", new Puntaje(1));
        Opcion opcionAzulParcial = new Opcion("Azul", new Puntaje(0));
        Opcion opcionAmarilloParcial = new Opcion("Amarillo", new Puntaje(0));

        ListaOpciones opcionesCorrectasParcial = new ListaOpciones(Arrays.asList(opcionTierraParcial, opcionMarteParcial, opcionJupiterParcial));
        ListaOpciones opcionesIncorrectasParcial = new ListaOpciones(Arrays.asList(opcionAzulParcial, opcionAmarilloParcial));

        multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectasParcial, opcionesIncorrectasParcial);
        ////////////Termina creacion de objetos para hacer pruebas de la vista MultipleChoiceParcial

        ////////////Empieza creacion de objetos para hacer pruebas de la vista MultipleChoicePenalidad
        Opcion opcionTierraPenalidad = new Opcion("Tierra", new Puntaje(1));
        Opcion opcionMartePenalidad = new Opcion("Marte", new Puntaje(1));
        Opcion opcionJupiterPenalidad = new Opcion("Jupiter", new Puntaje(1));
        Opcion opcionAzulPenalidad = new Opcion("Azul", new Puntaje(-1));
        Opcion opcionAmarilloPenalidad = new Opcion("Amarillo", new Puntaje(-1));

        ListaOpciones opcionesCorrectasPenalidad = new ListaOpciones(Arrays.asList(opcionTierraPenalidad, opcionMartePenalidad, opcionJupiterPenalidad));
        ListaOpciones opcionesIncorrectasPenalidad = new ListaOpciones(Arrays.asList(opcionAzulPenalidad, opcionAmarilloPenalidad));

        multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectasPenalidad, opcionesIncorrectasPenalidad);
        ////////////Termina creacion de objetos para hacer pruebas de la vista MultipleChoicePenalidad

        ////////////Empieza creacion de objetos para hacer pruebas de la vista MultipleChoiceClasico
        Opcion opcionTierraClasico = new Opcion("Tierra", new Puntaje(1));
        Opcion opcionMarteClasico = new Opcion("Marte", new Puntaje(1));
        Opcion opcionJupiterClasico = new Opcion("Jupiter", new Puntaje(1));
        Opcion opcionAzulClasico = new Opcion("Azul", new Puntaje(-1));
        Opcion opcionAmarilloClasico = new Opcion("Amarillo", new Puntaje(-1));

        ListaOpciones opcionesCorrectasClasico = new ListaOpciones(Arrays.asList(opcionTierraClasico, opcionMarteClasico, opcionJupiterClasico));
        ListaOpciones opcionesIncorrectasClasico = new ListaOpciones(Arrays.asList(opcionAzulClasico, opcionAmarilloClasico));

        multipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectasClasico, opcionesIncorrectasClasico);
        ////////////Termina creacion de objetos para hacer pruebas de la vista MultipleChoiceClasico
    }

    public Stack<Pregunta> getPilaDePreguntas() {
        Stack<Pregunta> pila = new Stack<>();
        pila.add(orderedChoice);
        pila.add(groupChoice);  //Se asigna mal el puntaje
        pila.add(multipleChoiceClasico);
        pila.add(multipleChoiceConPenalidad);  //Se asigna mal el puntaje
        pila.add(multipleChoiceParcial);   //Se asigna mal el puntaje
        pila.add(verdaderoFalsoConPenalidad);
        pila.add(verdaderoFalsoClasico);
        return pila;
    }
}
