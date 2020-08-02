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



}

