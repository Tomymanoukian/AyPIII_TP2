package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VerdaderoFalsoConPenalidadTest {
    @Test
    public void testSeCreaUnVoFConPenalidadConRespuestaCorrectaFalso() {
        String consigna = "Consigna:";
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Opcion opcionCorrecta = verdaderoFalsoConPenalidad.getOpcionCorrecta();
        Opcion opcionIncorrecta = verdaderoFalsoConPenalidad.getOpcionIncorrecta();

        assertEquals(consigna, verdaderoFalsoConPenalidad.getConsigna());

        assertEquals("Falso", opcionCorrecta.getOpcion());
        assertEquals(1, opcionCorrecta.getPuntaje().getPuntos());

        assertEquals("Verdadero", opcionIncorrecta.getOpcion());
        assertEquals(-1, opcionIncorrecta.getPuntaje().getPuntos());
    }

    @Test
    public void testSeLePideLaRespuestaCorrectaAUnVoFConPenalidadYTienePuntajeUno() {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Opcion opcionCorrecta = verdaderoFalsoConPenalidad.getOpcionCorrecta();

        assertEquals("Verdadero", opcionCorrecta.getOpcion());
        assertEquals(1, opcionCorrecta.getPuntaje().getPuntos());

    }

    @Test
    public void testSeLePideLaRespuestaIncorrectaAUnVoFConPenalidadYTienePuntajeMenosUno() {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Opcion opcionIncorrecta = verdaderoFalsoConPenalidad.getOpcionIncorrecta();

        assertEquals("Falso", opcionIncorrecta.getOpcion());
        assertEquals(-1, opcionIncorrecta.getPuntaje().getPuntos());

    }

    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorRestandoleUnPunto() {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");

        Jugador jugador = new Jugador("Jorge");
        RespuestaUnica respuestaDelJugador = new RespuestaUnica(verdaderoFalsoConPenalidad.getOpcionIncorrecta());

        assertEquals(-1,verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testSeEvaluaLaRespuestaIncorrectaDeUnJugadorSumandoleUnPunto() {
        VerdaderoFalsoConPenalidad verdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("Consigna:");
        Jugador jugador = new Jugador("Jorge");
        RespuestaUnica respuestaDelJugador = new RespuestaUnica(verdaderoFalsoConPenalidad.getOpcionCorrecta());

        assertEquals(1,verdaderoFalsoConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }


}