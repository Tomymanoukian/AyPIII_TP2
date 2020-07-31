package edu.fiuba.algo3.modelo;

//import javafx.css.converter.LagregarerConverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AsignacionDePuntosTest {

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
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra", 1);
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte", 1);
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter", 1);
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul", 0);
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo", 0);


        respuestasCorrectas.agregar(respuestaCorrectaTierra);
        respuestasCorrectas.agregar(respuestaCorrectaMarte);
        respuestasCorrectas.agregar(respuestaCorrectaJupiter);

        respuestasIncorrectas.agregar(respuestaInorrectaAzul);
        respuestasIncorrectas.agregar(respuestaIncorrectaAmarillo);

        ListaRespuestas respuestasJugador = new ListaRespuestas();
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
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra", 1);
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte", 1);
        Respuesta respuestaIncorrectaAzul = new Respuesta("Azul", 0);
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo", 0);


        respuestasCorrectas.agregar(respuestaCorrectaTierra);
        respuestasCorrectas.agregar(respuestaCorrectaMarte);
        respuestasIncorrectas.agregar(respuestaIncorrectaAzul);
        respuestasIncorrectas.agregar(respuestaIncorrectaAmarillo);

        ListaRespuestas respuestasJugador = new ListaRespuestas();
        respuestasJugador.agregarTodo(respuestasCorrectas);
        respuestasJugador.agregar(respuestaIncorrectaAzul);


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
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        ListaRespuestas respuestasJugador = new ListaRespuestas();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra", 1);
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte", 1);
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter", 1);
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul", 0);
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo", 0);


        respuestasCorrectas.agregar(respuestaCorrectaTierra);
        respuestasCorrectas.agregar(respuestaCorrectaMarte);
        respuestasCorrectas.agregar(respuestaCorrectaJupiter);
        respuestasIncorrectas.agregar(respuestaInorrectaAzul);
        respuestasIncorrectas.agregar(respuestaIncorrectaAmarillo);

        respuestasJugador.agregar(respuestaCorrectaMarte);
        respuestasJugador.agregar(respuestaCorrectaJupiter);


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
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra", 1);
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte", 1);
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter", 1);
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul", 0);
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo", 0);


        respuestasCorrectas.agregar(respuestaCorrectaTierra);
        respuestasCorrectas.agregar(respuestaCorrectaMarte);
        respuestasCorrectas.agregar(respuestaCorrectaJupiter);
        respuestasIncorrectas.agregar(respuestaInorrectaAzul);
        respuestasIncorrectas.agregar(respuestaIncorrectaAmarillo);

        ListaRespuestas respuestasJugador = new ListaRespuestas();
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
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra", 1);
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte", 1);
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter", 1);
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul", 0);
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo", 0);


        respuestasCorrectas.agregar(respuestaCorrectaTierra);
        respuestasCorrectas.agregar(respuestaCorrectaMarte);
        respuestasCorrectas.agregar(respuestaCorrectaJupiter);
        respuestasIncorrectas.agregar(respuestaInorrectaAzul);
        respuestasIncorrectas.agregar(respuestaIncorrectaAmarillo);

        ListaRespuestas respuestasJugador = new ListaRespuestas();
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
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra", 1);
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte", 1);
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter", 1);
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul", 0);
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo", 0);


        respuestasCorrectas.agregar(respuestaCorrectaTierra);
        respuestasCorrectas.agregar(respuestaCorrectaMarte);
        respuestasCorrectas.agregar(respuestaCorrectaJupiter);
        respuestasIncorrectas.agregar(respuestaInorrectaAzul);
        respuestasIncorrectas.agregar(respuestaIncorrectaAmarillo);

        ListaRespuestas respuestasJugador = new ListaRespuestas();
        respuestasJugador.agregarTodo(respuestasCorrectas);
        respuestasJugador.agregar(respuestaIncorrectaAmarillo);


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
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra", 1);
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte", 1);
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter", 1);
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul", 0);
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo", 0);


        respuestasCorrectas.agregar(respuestaCorrectaTierra);
        respuestasCorrectas.agregar(respuestaCorrectaMarte);
        respuestasCorrectas.agregar(respuestaCorrectaJupiter);
        respuestasIncorrectas.agregar(respuestaInorrectaAzul);
        respuestasIncorrectas.agregar(respuestaIncorrectaAmarillo);

        ListaRespuestas respuestasJugador = new ListaRespuestas();
        respuestasJugador.agregarTodo(respuestasIncorrectas);

        respuestasJugador.agregar(respuestaIncorrectaAmarillo);


        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0, kahoot.getPuntajeJugador1());
    }

}

