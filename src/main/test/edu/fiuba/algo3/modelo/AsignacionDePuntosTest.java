package edu.fiuba.algo3.modelo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AsignacionDePuntosTest {

    @Test
    public void testVerdaderoFalsoClasicoJugador1AsertaYJugador2FallaAsignandoCorrectamenteLosPuntajes(){
        String consigna = "El Sol es azul";
        VerdaderoFalsoClasico preguntaVerderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoFalsa(consigna);

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
}

