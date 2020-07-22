package edu.fiuba.algo3.modelo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AsignacionDePuntosTests {
    @Test
    public void testVerdaderoFalsoClasicoJugador1AsertaYJugador2FallaAsignandoCorrectamenteLosPuntajes(){
        String consigna = "El Sol es azul";
        VerdaderoFalsoClasico preguntaVerderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoFalsa(consigna);

        Kahoot kahoot = new Kahoot();
        kahoot.setNombreJugador1("Juan");
        kahoot.setNombreJugador2("Maria");
        Respuesta respuestaJugador1 = new Respuesta("Falso");
        Respuesta respuestaJugador2 = new Respuesta("Verdadero");

        kahoot.setRespuestaJugador1(respuestaJugador1);
        kahoot.setRespuestaJugador2(respuestaJugador2);

        kahoot.evaluarRespuestas(preguntaVerderoFalsoClasico);

        assertEquals(1,kahoot.getPuntajeJugador1());
        assertEquals(0,kahoot.getPuntajeJugador2());
    }
}
