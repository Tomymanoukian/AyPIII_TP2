package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreacionDePreguntasTest {
    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoIndicandoleLaRespuestaCorrectaVerdadera() {
        String consigna = "Smalltalk es mejor que Java?";
        VerdaderoFalsoClasico preguntaVerdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero(consigna);
        Respuesta respuestaCorrecta = new Respuesta("Verdadero");

        assert(preguntaVerdaderoFalsoClasico.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        assertEquals("Smalltalk es mejor que Java?", preguntaVerdaderoFalsoClasico.getConsigna());
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoLaRespuestaCorrectaFalso() {
        String consigna = "Java es mejor que Smalltalk?";
        VerdaderoFalsoClasico preguntaVerdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso(consigna);
        Respuesta respuestaCorrecta = new Respuesta("Falso");

        assert(preguntaVerdaderoFalsoClasico.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        assertEquals("Java es mejor que Smalltalk?", preguntaVerdaderoFalsoClasico.getConsigna());
    }


}
