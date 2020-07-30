package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ListaRespuestas;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.VerdaderoFalsoConPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VerdaderoFalsoConPenalidadTest {
    @Test
    public void testSeCreaUnVoFConPenalidadConRespuestaCorrectaFalso(){
        String consigna = "Consigna:";
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Respuesta respuestaCorrecta = verdaderoFalsoConPenalidad.getRespuestaCorrecta();
        Respuesta respuestaIncorrecta = verdaderoFalsoConPenalidad.getRespuestaIncorrecta();

        assertEquals(consigna, verdaderoFalsoConPenalidad.getConsigna());

        assertEquals("Falso", respuestaCorrecta.getRespuesta());
        assertEquals(1, respuestaCorrecta.getPuntaje());

        assertEquals("Verdadero", respuestaIncorrecta.getRespuesta());
        assertEquals(-1, respuestaIncorrecta.getPuntaje());
    }
    @Test
    public void testSeLePideLaRespuestaCorrectaAUnVoFConPenalidadYTienePuntajeUno(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Respuesta respuestaCorrecta = verdaderoFalsoConPenalidad.getRespuestaCorrecta();

        assertEquals("Verdadero", respuestaCorrecta.getRespuesta());
        assertEquals(1, respuestaCorrecta.getPuntaje());

    }
    @Test
    public void testSeLePideLaRespuestaIncorrectaAUnVoFConPenalidadYTienePuntajeMenosUno(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Respuesta respuestaIncorrecta = verdaderoFalsoConPenalidad.getRespuestaIncorrecta();

        assertEquals("Falso", respuestaIncorrecta.getRespuesta());
        assertEquals(-1, respuestaIncorrecta.getPuntaje());

    }

    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorRestandoleUnPunto(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Jugador jugador = new Jugador("Jorge");
        ListaRespuestas respuestasDelJugador = new ListaRespuestas();
        respuestasDelJugador.agregar(verdaderoFalsoConPenalidad.getRespuestaIncorrecta());

        verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestasDelJugador,jugador);

        assertEquals(jugador.getPuntos(), -1);
    }
    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorSumandoleUnPunto(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Jugador jugador = new Jugador("Jorge");
        ListaRespuestas respuestasDelJugador = new ListaRespuestas();
        respuestasDelJugador.agregar(verdaderoFalsoConPenalidad.getRespuestaCorrecta());

        verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestasDelJugador,jugador);

        assertEquals(jugador.getPuntos(), 1);
    }





}