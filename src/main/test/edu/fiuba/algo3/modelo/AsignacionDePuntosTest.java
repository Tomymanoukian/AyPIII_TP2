package edu.fiuba.algo3.modelo;

import javafx.css.converter.LadderConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AsignacionDePuntosTest {

    @Test
    public void testVerdaderoFalsoClasicoJugador1AsertaYJugador2FallaSumandoCorrectamenteLosPuntajes(){
        String consigna = "El Sol es azul";
        VerdaderoFalsoClasico preguntaVerderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso(consigna);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        Respuesta respuestaJugador1 = new Respuesta("Falso");
        Respuesta respuestaJugador2 = new Respuesta("Verdadero");

        kahoot.setRespuestaJugador1(respuestaJugador1);
        kahoot.setRespuestaJugador2(respuestaJugador2);

        kahoot.evaluarRespuestas(preguntaVerderoFalsoClasico);

        assertEquals(1,kahoot.getPuntajeJugador1());
        assertEquals(0,kahoot.getPuntajeJugador2());
    }

    @Test
    public void testVerdaderoFalsoConPernalidadJugador1AsertaYJugador2FallaSumandoleCorrectamenteLosPuntajes(){
        String consigna = "El Sol es azul";
        VerdaderoFalsoConPenalidad preguntaVerderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        Respuesta respuestaJugador1 = new Respuesta("Falso");
        Respuesta respuestaJugador2 = new Respuesta("Verdadero");

        kahoot.setRespuestaJugador1(respuestaJugador1);
        kahoot.setRespuestaJugador2(respuestaJugador2);

        kahoot.evaluarRespuestas(preguntaVerderoFalsoConPenalidad);

        assertEquals(1,kahoot.getPuntajeJugador1());
        assertEquals(-1,kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertaTodasLasRespuestasCorrectasSumandoleCorrectamenteLosPuntosDeLasRespuestasCorrectas(){
        String consigna = "Indicar cuales de los siguientes con planetas:";
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra");
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte");
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter");
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul");
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo");


        respuestasCorrectas.add(respuestaCorrectaTierra);
        respuestasCorrectas.add(respuestaCorrectaMarte);
        respuestasCorrectas.add(respuestaCorrectaJupiter);

        respuestasIncorrectas.add(respuestaInorrectaAzul);
        respuestasIncorrectas.add(respuestaIncorrectaAmarillo);

        List<Respuesta> respuestasJugador = new ArrayList<>(respuestasCorrectas);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna,respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(3,kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertaTodasLasRespuestasCorrectasYUnaIncorrectaSumandoleCeroPuntos(){
        String consigna = "Indicar cuales de los siguientes con planetas:";
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra");
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte");
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul");
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo");


        respuestasCorrectas.add(respuestaCorrectaTierra);
        respuestasCorrectas.add(respuestaCorrectaMarte);
        respuestasIncorrectas.add(respuestaInorrectaAzul);
        respuestasIncorrectas.add(respuestaIncorrectaAmarillo);

        List<Respuesta> respuestasJugador = new ArrayList<>(respuestasCorrectas);
        respuestasJugador.add(respuestaInorrectaAzul);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna,respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0,kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertaAlgunasCorrectasYNingunaIncorrectaSumandoleCeroPuntos(){
        String consigna = "Indicar cuales de los siguientes con planetas:";
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();
        List<Respuesta> respuestasJugador = new ArrayList<>();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra");
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte");
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter");
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul");
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo");


        respuestasCorrectas.add(respuestaCorrectaTierra);
        respuestasCorrectas.add(respuestaCorrectaMarte);
        respuestasCorrectas.add(respuestaCorrectaJupiter);
        respuestasIncorrectas.add(respuestaInorrectaAzul);
        respuestasIncorrectas.add(respuestaIncorrectaAmarillo);

        respuestasJugador.add(respuestaCorrectaMarte);
        respuestasJugador.add(respuestaCorrectaJupiter);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna,respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(2,kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceParcialJugadorNoAciertaNingunaCorrectasSumandoleCeroPuntos(){
        String consigna = "Indicar cuales de los siguientes con planetas:";
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra");
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte");
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter");
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul");
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo");


        respuestasCorrectas.add(respuestaCorrectaTierra);
        respuestasCorrectas.add(respuestaCorrectaMarte);
        respuestasCorrectas.add(respuestaCorrectaJupiter);
        respuestasIncorrectas.add(respuestaInorrectaAzul);
        respuestasIncorrectas.add(respuestaIncorrectaAmarillo);

        List<Respuesta> respuestasJugador = new ArrayList<>(respuestasIncorrectas);


        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna,respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0,kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorAciertaTodasLasRespuestasCorrectasSumandoleUnPunto(){
        String consigna = "Indicar cuales de los siguientes con planetas:";
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra");
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte");
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter");
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul");
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo");


        respuestasCorrectas.add(respuestaCorrectaTierra);
        respuestasCorrectas.add(respuestaCorrectaMarte);
        respuestasCorrectas.add(respuestaCorrectaJupiter);
        respuestasIncorrectas.add(respuestaInorrectaAzul);
        respuestasIncorrectas.add(respuestaIncorrectaAmarillo);

        List<Respuesta> respuestasJugador = new ArrayList<>(respuestasCorrectas);


        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna,respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(1,kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorAciertaTodasLasRespuestasCorrectasYUnaIncorrectaSumandoleCeroPuntos(){
        String consigna = "Indicar cuales de los siguientes con planetas:";
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra");
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte");
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter");
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul");
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo");


        respuestasCorrectas.add(respuestaCorrectaTierra);
        respuestasCorrectas.add(respuestaCorrectaMarte);
        respuestasCorrectas.add(respuestaCorrectaJupiter);
        respuestasIncorrectas.add(respuestaInorrectaAzul);
        respuestasIncorrectas.add(respuestaIncorrectaAmarillo);

        List<Respuesta> respuestasJugador = new ArrayList<>(respuestasCorrectas);
        respuestasJugador.add(respuestaIncorrectaAmarillo);


        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna,respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0,kahoot.getPuntajeJugador1());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorNoAciertaNingunaRespuestasCorrectasSumandoleCeroPuntos(){
        String consigna = "Indicar cuales de los siguientes con planetas:";
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();

        Respuesta respuestaCorrectaTierra = new Respuesta("Tierra");
        Respuesta respuestaCorrectaMarte = new Respuesta("Marte");
        Respuesta respuestaCorrectaJupiter = new Respuesta("Jupiter");
        Respuesta respuestaInorrectaAzul = new Respuesta("Azul");
        Respuesta respuestaIncorrectaAmarillo = new Respuesta("Amarillo");


        respuestasCorrectas.add(respuestaCorrectaTierra);
        respuestasCorrectas.add(respuestaCorrectaMarte);
        respuestasCorrectas.add(respuestaCorrectaJupiter);
        respuestasIncorrectas.add(respuestaInorrectaAzul);
        respuestasIncorrectas.add(respuestaIncorrectaAmarillo);

        List<Respuesta> respuestasJugador = new ArrayList<>(respuestasCorrectas);
        respuestasJugador.add(respuestaIncorrectaAmarillo);


        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna,respuestasCorrectas, respuestasIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0,kahoot.getPuntajeJugador1());
    }

}

