package edu.fiuba.algo3.modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CreacionDePreguntasTest {
    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasico() {
        List<Respuesta> respuestas = new ArrayList<>();
        String consigna = "Smalltalk es mejor que Java?";
        VerdaderoFalso preguntaVerdaderoYFalso = new VerdaderoFalso(consigna, respuestas);

        assertEquals("Smalltalk es mejor que Java?",preguntaVerdaderoYFalso.getConsigna());
    }
}
