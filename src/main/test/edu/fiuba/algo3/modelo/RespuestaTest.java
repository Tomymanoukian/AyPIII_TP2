package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RespuestaTest {
    @Test
    public void testCreoDosRespuestasIguales(){
        Respuesta respuesta1 = new Respuesta("unaRespuesta");
        Respuesta respuesta2 = new Respuesta("unaRespuesta");

        assert(respuesta1.esIgualA(respuesta2));
    }

    @Test
    public void testCreoDosRespuestasDistintas(){
        Respuesta respuesta1 = new Respuesta("unaRespuesta");
        Respuesta respuesta2 = new Respuesta("diferenteRespuesta");

        assert(!respuesta1.esIgualA(respuesta2));
    }

    @Test
    public void testSeCreaUnaRespuestaConPuntajePositivoAlAplicarselaAlJugadorSumaPuntos(){
        int puntaje = 2;
        Respuesta respuesta = new Respuesta("Cosigna :", puntaje);
        Jugador unJugador = new Jugador("Pablo");

        respuesta.aplicarPuntajeA(unJugador);

        assertEquals(unJugador.getPuntos(),puntaje);


    }

}
