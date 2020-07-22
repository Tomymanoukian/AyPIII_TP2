package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreacionDePreguntasTest {
    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoIndicandoleLaRespuestaCorrectaVerdadera() {
        String consigna = "Smalltalk es mejor que Java?";
        VerdaderoFalsoClasico preguntaVerdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoVerdadera(consigna);
        Respuesta respuestaCorrecta = new Respuesta("Verdadero");

        assert(preguntaVerdaderoFalsoClasico.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        assertEquals("Smalltalk es mejor que Java?", preguntaVerdaderoFalsoClasico.getConsigna());
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoLaRespuestaCorrectaFalso() {
        String consigna = "Smalltalk es mejor que Java?";
        VerdaderoFalsoClasico preguntaVerdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoFalsa(consigna);
        Respuesta respuestaCorrecta = new Respuesta("Falso");

        assert(preguntaVerdaderoFalsoClasico.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        assertEquals("Smalltalk es mejor que Java?", preguntaVerdaderoFalsoClasico.getConsigna());
    }


}
