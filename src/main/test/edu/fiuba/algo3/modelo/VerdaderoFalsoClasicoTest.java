package edu.fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoIndicandoleLaRespuestaCorrectaVerdadera() {
        VerdaderoFalsoClasico vofVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoVerdadera("foo");
        Respuesta respuestaCorrecta = new Respuesta("Verdadero");

        assert(vofVerdaderaCorrecta.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        Assert.assertEquals("foo", vofVerdaderaCorrecta.getConsigna());
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoLaRespuestaCorrectaFalso() {
        VerdaderoFalsoClasico vofFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoFalsa("bar");
        Respuesta respuestaCorrecta = new Respuesta("Falso");

        assert(vofFalsaCorrecta.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        Assert.assertEquals("bar", vofFalsaCorrecta.getConsigna());
    }

    @Test
    public void testCalcularPuntajeParaFuncionaCorrectamente() {

        VerdaderoFalsoClasico vofClasicoVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoVerdadera("foo");
        VerdaderoFalsoClasico vofClasicoFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoFalsa("bar");
        Respuesta verdadera = new Respuesta("Verdadero");
        Respuesta falsa = new Respuesta("Falso");

        assertEquals(1, vofClasicoVerdaderaCorrecta.calcularPuntajePara(verdadera));
        assertEquals(0, vofClasicoVerdaderaCorrecta.calcularPuntajePara(falsa));

        assertEquals(1, vofClasicoFalsaCorrecta.calcularPuntajePara(falsa));
        assertEquals(0, vofClasicoFalsaCorrecta.calcularPuntajePara(verdadera));
    }

    @Test
    public void testVoFClasicoLanzaExcepciónSiSeLaDaUnaRespuestaNoValidaEnCalcularPuntaje(){
        Respuesta verdadera = new Respuesta("Verdadero");
        Respuesta falsa = new Respuesta("Falso");
        Respuesta otra = new Respuesta("foo");

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoVerdadera("bar");

        vofClasico.calcularPuntajePara(verdadera);
        vofClasico.calcularPuntajePara(falsa);

        assertThrows(RespuestaNoValidaException.class, ()-> vofClasico.calcularPuntajePara(otra));
    }
}
