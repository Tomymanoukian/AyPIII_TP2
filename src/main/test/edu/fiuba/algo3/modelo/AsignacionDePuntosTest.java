package edu.fiuba.algo3.modelo;

//import javafx.css.converter.LagregarerConverter;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AsignacionDePuntosTest {

    @Before
    public void setUp() {


    }

    @Test
    public void testVerdaderoFalsoClasicoJugador1AsertaYJugador2FallaSumandoCorrectamenteLosPuntajes() {
        String consigna = "El Sol es azul";
        VerdaderoFalsoClasico preguntaVerderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso(consigna);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(preguntaVerderoFalsoClasico.getRespuestaCorrecta());
        kahoot.setRespuestaJugador2(preguntaVerderoFalsoClasico.getRespuestaIncorrecta());

        kahoot.evaluarRespuestas(preguntaVerderoFalsoClasico);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testVerdaderoFalsoConPenalidadJugador1AsertaYJugador2FallaSumandoleCorrectamenteLosPuntajes() {
        String consigna = "El Sol es azul";
        VerdaderoFalsoConPenalidad preguntaVerderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(preguntaVerderoFalsoConPenalidad.getRespuestaCorrecta());
        kahoot.setRespuestaJugador2(preguntaVerderoFalsoConPenalidad.getRespuestaIncorrecta());

        kahoot.evaluarRespuestas(preguntaVerderoFalsoConPenalidad);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(-1, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertaTodasLasRespuestasCorrectasSumandoleCorrectamenteLosPuntosDeLasRespuestasCorrectas() {
        String consigna = "Indicar cuales de los siguientes con planetas:";
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        respuestasCorrectas.agregar(opcionCorrectaTierra);
        respuestasCorrectas.agregar(opcionCorrectaMarte);
        respuestasCorrectas.agregar(opcionCorrectaJupiter);

        respuestasIncorrectas.agregar(opcionInorrectaAzul);
        respuestasIncorrectas.agregar(opcionIncorrectaAmarillo);

        ListaOpciones respuestasJugador = new ListaOpciones();
        respuestasJugador.agregarTodo(respuestasCorrectas);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(3, kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertaTodasLasRespuestasCorrectasYUnaIncorrectaSumandoleCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionIncorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        respuestasCorrectas.agregar(opcionCorrectaTierra);
        respuestasCorrectas.agregar(opcionCorrectaMarte);
        respuestasIncorrectas.agregar(opcionIncorrectaAzul);
        respuestasIncorrectas.agregar(opcionIncorrectaAmarillo);

        ListaOpciones respuestasJugador = new ListaOpciones();
        respuestasJugador.agregarTodo(respuestasCorrectas);
        respuestasJugador.agregar(opcionIncorrectaAzul);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertaAlgunasCorrectasYNingunaIncorrectaSumandoleCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        ListaOpciones respuestasJugador = new ListaOpciones();

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        respuestasCorrectas.agregar(opcionCorrectaTierra);
        respuestasCorrectas.agregar(opcionCorrectaMarte);
        respuestasCorrectas.agregar(opcionCorrectaJupiter);
        respuestasIncorrectas.agregar(opcionInorrectaAzul);
        respuestasIncorrectas.agregar(opcionIncorrectaAmarillo);

        respuestasJugador.agregar(opcionCorrectaMarte);
        respuestasJugador.agregar(opcionCorrectaJupiter);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador2(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(2, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceParcialJugadorNoAciertaNingunaCorrectasSumandoleCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        respuestasCorrectas.agregar(opcionCorrectaTierra);
        respuestasCorrectas.agregar(opcionCorrectaMarte);
        respuestasCorrectas.agregar(opcionCorrectaJupiter);
        respuestasIncorrectas.agregar(opcionInorrectaAzul);
        respuestasIncorrectas.agregar(opcionIncorrectaAmarillo);

        ListaOpciones respuestasJugador = new ListaOpciones();
        respuestasJugador.agregarTodo(respuestasIncorrectas);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorAciertaTodasLasRespuestasCorrectasSumandoleUnPunto() {
        String consigna = "Indicar cuales de los siguientes con planetas:";
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        respuestasCorrectas.agregar(opcionCorrectaTierra);
        respuestasCorrectas.agregar(opcionCorrectaMarte);
        respuestasCorrectas.agregar(opcionCorrectaJupiter);
        respuestasIncorrectas.agregar(opcionInorrectaAzul);
        respuestasIncorrectas.agregar(opcionIncorrectaAmarillo);

        ListaOpciones respuestasJugador = new ListaOpciones();
        respuestasJugador.agregarTodo(respuestasCorrectas);


        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(1, kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorAciertaTodasLasRespuestasCorrectasYUnaIncorrectaSumandoleCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        respuestasCorrectas.agregar(opcionCorrectaTierra);
        respuestasCorrectas.agregar(opcionCorrectaMarte);
        respuestasCorrectas.agregar(opcionCorrectaJupiter);
        respuestasIncorrectas.agregar(opcionInorrectaAzul);
        respuestasIncorrectas.agregar(opcionIncorrectaAmarillo);

        ListaOpciones respuestasJugador = new ListaOpciones();
        respuestasJugador.agregarTodo(respuestasCorrectas);
        respuestasJugador.agregar(opcionIncorrectaAmarillo);


        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0, kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorNoAciertaNingunaRespuestasCorrectasSumandoleCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        respuestasCorrectas.agregar(opcionCorrectaTierra);
        respuestasCorrectas.agregar(opcionCorrectaMarte);
        respuestasCorrectas.agregar(opcionCorrectaJupiter);
        respuestasIncorrectas.agregar(opcionInorrectaAzul);
        respuestasIncorrectas.agregar(opcionIncorrectaAmarillo);

        ListaOpciones respuestasJugador = new ListaOpciones();
        respuestasJugador.agregarTodo(respuestasIncorrectas);

        respuestasJugador.agregar(opcionIncorrectaAmarillo);


        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0, kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1AciertaCuatroRespuestasYJugador2AciertaCuatroRespuestasSumandolesCorrectamenteCuatroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";


        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionCorrectaSaturno = new Opcion("Saturno", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        List<Opcion> respuestasCorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        List<Opcion> respuestasIncorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        ListaOpciones respuestasCorrectas = new ListaOpciones(respuestasCorrectasList);
        ListaOpciones respuestasIncorrectas = new ListaOpciones(respuestasIncorrectasList);

        ListaOpciones respuestasJugador1 = new ListaOpciones(respuestasCorrectas);
        ListaOpciones respuestasJugador2 = new ListaOpciones(respuestasCorrectas);


        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(4, kahoot.getPuntajeJugador1());
        assertEquals(4, kahoot.getPuntajeJugador2());
    }


    @Test
    public void testMultipleChoiceConPenalidadJugador1EligeTresRespuestasCorrectasYUnaIncorrectaYJugador2EligeDosRespuestasCorrectasYDosIncorrectaAsignandolesCorrectamenteLosPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";


        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionCorrectaSaturno = new Opcion("Saturno", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        List<Opcion> respuestasCorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        List<Opcion> respuestasIncorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        ListaOpciones respuestasCorrectas = new ListaOpciones(respuestasCorrectasList);
        ListaOpciones respuestasIncorrectas = new ListaOpciones(respuestasIncorrectasList);

        List<Opcion> respuestasJugador1List = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionIncorrectaAmarillo, opcionInorrectaAzul));
        List<Opcion> respuestasJugador2List = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionIncorrectaAmarillo, opcionInorrectaAzul));
        ListaOpciones respuestasJugador1 = new ListaOpciones(respuestasJugador1List);
        ListaOpciones respuestasJugador2 = new ListaOpciones(respuestasJugador2List);


        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(2, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1EligeUnaRespuestasCorrectasYDosIncorrectaYJugador2EligeCeroRespuestasCorrectasYDosIncorrectaAsignandolesCorrectamenteLosPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";


        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionCorrectaSaturno = new Opcion("Saturno", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        List<Opcion> respuestasCorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        List<Opcion> respuestasIncorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaJupiter, opcionCorrectaSaturno));
        ListaOpciones respuestasCorrectas = new ListaOpciones(respuestasCorrectasList);
        ListaOpciones respuestasIncorrectas = new ListaOpciones(respuestasIncorrectasList);

        List<Opcion> opcionesJugador1List = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionIncorrectaAmarillo, opcionInorrectaAzul));
        List<Opcion> opcionesJugador2List = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionIncorrectaAmarillo, opcionInorrectaAzul));
        ListaOpciones opcionesJugador1 = new ListaOpciones(opcionesJugador1List);
        ListaOpciones opcionesJugador2 = new ListaOpciones(opcionesJugador2List);


        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(opcionesJugador1);
        kahoot.setRespuestaJugador2(opcionesJugador2);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(2, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }
/*
    @Test
    public void testGroupChoiceJugador1YJugador2AgrupanCorrectamenteLasRespuestasAsignandolesUnPuntoACadaUno() {
        String consigna = "Agrupe en las categorias A y B:";


        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB", 0);


        List<Opcion> respuestasGrupoAList = new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA));
        List<Opcion> respuestasGrupoBList = new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB));
        ListaOpciones respuestasGrupoA = new ListaOpciones(respuestasGrupoAList);
        ListaOpciones respuestasGrupoB = new ListaOpciones(respuestasGrupoBList);

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, respuestasCorrectas, respuestasIncorrectas);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(1, kahoot.getPuntajeJugador2());
    }

@Test
public void testGroupChoiceJugador1AgrupaCorrectamenteLasOpcionesYJugador2AgrupaIncorrectamenteLasOpcionesAsignandolesCorrectamenteLosPuntajes() {
    String consigna = "Agrupe en las categorias A y B:";


    Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
    Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
    Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA", 0);
    Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
    Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);
    Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB", 0);


    List<Opcion> respuestasGrupoAList = new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA));
    List<Opcion> respuestasGrupoBList = new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB));
    ListaOpciones respuestasGrupoA = new ListaOpciones(respuestasGrupoAList);
    ListaOpciones respuestasGrupoB = new ListaOpciones(respuestasGrupoBList);

    GroupChoice preguntaGroupChoice = new GroupChoice(consigna, respuestasCorrectas, respuestasIncorrectas);

    RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB );
    RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);




    Jugador juan = new Jugador("Juan");
    Jugador maria = new Jugador("Maria");

    Kahoot kahoot = new Kahoot(juan, maria);

    kahoot.setRespuestaJugador1(respuestasJugador1);
    kahoot.setRespuestaJugador2(respuestasJugador2);

    kahoot.evaluarRespuestas(preguntaGroupChoice);

    assertEquals(1, kahoot.getPuntajeJugador1());
    assertEquals(0, kahoot.getPuntajeJugador2());
}

    public void testGroupChoiceJugador1YJugador2AgrupanIncorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        String consigna = "Agrupe en las categorias A y B:";


        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB", 0);


        List<Opcion> respuestasGrupoAList = new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA));
        List<Opcion> respuestasGrupoBList = new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB));
        ListaOpciones respuestasGrupoA = new ListaOpciones(respuestasGrupoAList);
        ListaOpciones respuestasGrupoB = new ListaOpciones(respuestasGrupoBList);

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, respuestasCorrectas, respuestasIncorrectas);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(0, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

 */


    public void testOrderedChoiceJugador1YJugador2OrdenanCorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        String consigna = "Ordene correctamente las opciones:";


        Opcion primerOpcion = new Opcion("1er Opcion", 0);
        Opcion segundaOpcion = new Opcion("2da Opcion", 0);
        Opcion terceraOpcion = new Opcion("3era Opcion", 0);
        Opcion cuartaOpcion = new Opcion("4ta Opcion", 0);
        Opcion quintaOpcion = new Opcion("5ta Opcion", 0);
        Opcion sextaOpcion = new Opcion("6ta Opcion", 0);


        List<Opcion> respuestasOrdenadasCorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion, segundaOpcion, terceraOpcion,cuartaOpcion,quintaOpcion,sextaOpcion));
        ListaOpciones opcionesOrdenadasCorrectamente = new ListaOpciones(respuestasOrdenadasCorrectamenteList);


        OrderedChoice preguntaGroupChoice = new OrderedChoice(consigna, opcionesOrdenadasCorrectamente);

        ListaOpciones respuestasJugador1 = new ListaOpciones(opcionesOrdenadasCorrectamente);
        ListaOpciones respuestasJugador2 = new ListaOpciones(opcionesOrdenadasCorrectamente);


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(1, kahoot.getPuntajeJugador2());
    }



    public void testOrderedChoiceJugador1YJugador2OrdenanIncorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        String consigna = "Ordene correctamente las opciones:";


        Opcion primerOpcion = new Opcion("1er Opcion", 0);
        Opcion segundaOpcion = new Opcion("2da Opcion", 0);
        Opcion terceraOpcion = new Opcion("3era Opcion", 0);
        Opcion cuartaOpcion = new Opcion("4ta Opcion", 0);
        Opcion quintaOpcion = new Opcion("5ta Opcion", 0);
        Opcion sextaOpcion = new Opcion("6ta Opcion", 0);


        List<Opcion> respuestasOrdenadasCorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion, segundaOpcion, terceraOpcion,cuartaOpcion,quintaOpcion,sextaOpcion));
        ListaOpciones opcionesOrdenadasCorrectamente = new ListaOpciones(respuestasOrdenadasCorrectamenteList);
        List<Opcion> respuestasOrdenadasInorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion,terceraOpcion ,segundaOpcion ,cuartaOpcion,quintaOpcion,sextaOpcion));
        ListaOpciones opcionesOrdenadasInorrectamente = new ListaOpciones(respuestasOrdenadasInorrectamenteList);


        OrderedChoice preguntaGroupChoice = new OrderedChoice(consigna, opcionesOrdenadasCorrectamente);

        ListaOpciones respuestasJugador1 = new ListaOpciones(opcionesOrdenadasCorrectamente);
        ListaOpciones respuestasJugador2 = new ListaOpciones(opcionesOrdenadasInorrectamente);


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(1, kahoot.getPuntajeJugador2());
    }

    public void testOrderedChoiceJugador1OrdenaCorrectamenteLasOpcionesYJugador2OrdenaInorrectamenteLasOpcionesAsignandolesCorrectamenteLosPuntajes() {
        String consigna = "Ordene correctamente las opciones:";


        Opcion primerOpcion = new Opcion("1er Opcion", 0);
        Opcion segundaOpcion = new Opcion("2da Opcion", 0);
        Opcion terceraOpcion = new Opcion("3era Opcion", 0);
        Opcion cuartaOpcion = new Opcion("4ta Opcion", 0);
        Opcion quintaOpcion = new Opcion("5ta Opcion", 0);
        Opcion sextaOpcion = new Opcion("6ta Opcion", 0);


        List<Opcion> respuestasOrdenadasCorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion, segundaOpcion, terceraOpcion,cuartaOpcion,quintaOpcion,sextaOpcion));
        ListaOpciones opcionesOrdenadasCorrectamente = new ListaOpciones(respuestasOrdenadasCorrectamenteList);
        List<Opcion> respuestasOrdenadasInorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion,terceraOpcion ,segundaOpcion ,cuartaOpcion,quintaOpcion,sextaOpcion));
        ListaOpciones opcionesOrdenadasInorrectamente = new ListaOpciones(respuestasOrdenadasInorrectamenteList);


        OrderedChoice preguntaGroupChoice = new OrderedChoice(consigna, opcionesOrdenadasCorrectamente);

        ListaOpciones respuestasJugador1 = new ListaOpciones(opcionesOrdenadasInorrectamente);
        ListaOpciones respuestasJugador2 = new ListaOpciones(opcionesOrdenadasInorrectamente);


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(1, kahoot.getPuntajeJugador2());
    }


}

