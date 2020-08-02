package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.VerdaderoFalsoConPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VerdaderoFalsoConPenalidadTest {
    @Test
    public void testSeCreaUnVoFConPenalidadConRespuestaCorrectaFalso(){
        String consigna = "Consigna:";
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Opcion opcionCorrecta = verdaderoFalsoConPenalidad.getRespuestaCorrecta();
        Opcion opcionIncorrecta = verdaderoFalsoConPenalidad.getRespuestaIncorrecta();

        assertEquals(consigna, verdaderoFalsoConPenalidad.getConsigna());

        assertEquals("Falso", opcionCorrecta.getOpcion());
        assertEquals(1, opcionCorrecta.getPuntaje());

        assertEquals("Verdadero", opcionIncorrecta.getOpcion());
        assertEquals(-1, opcionIncorrecta.getPuntaje());
    }
    @Test
    public void testSeLePideLaRespuestaCorrectaAUnVoFConPenalidadYTienePuntajeUno(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Opcion opcionCorrecta = verdaderoFalsoConPenalidad.getRespuestaCorrecta();

        assertEquals("Verdadero", opcionCorrecta.getOpcion());
        assertEquals(1, opcionCorrecta.getPuntaje());

    }
    @Test
    public void testSeLePideLaRespuestaIncorrectaAUnVoFConPenalidadYTienePuntajeMenosUno(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Opcion opcionIncorrecta = verdaderoFalsoConPenalidad.getRespuestaIncorrecta();

        assertEquals("Falso", opcionIncorrecta.getOpcion());
        assertEquals(-1, opcionIncorrecta.getPuntaje());

    }

    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorRestandoleUnPunto(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Jugador jugador = new Jugador("Jorge");
        ListaOpciones respuestasDelJugador = new ListaOpciones();
        respuestasDelJugador.agregar(verdaderoFalsoConPenalidad.getRespuestaIncorrecta());

        verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestasDelJugador,jugador);

        assertEquals(jugador.getPuntos(), -1);
    }
    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorSumandoleUnPunto(){
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Jugador jugador = new Jugador("Jorge");
        ListaOpciones respuestasDelJugador = new ListaOpciones();
        respuestasDelJugador.agregar(verdaderoFalsoConPenalidad.getRespuestaCorrecta());

        verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestasDelJugador,jugador);

        assertEquals(jugador.getPuntos(), 1);
    }





}