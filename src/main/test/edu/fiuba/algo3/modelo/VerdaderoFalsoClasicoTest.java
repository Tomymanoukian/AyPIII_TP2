package edu.fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoIndicandoleLaRespuestaCorrectaVerdadera() {
        VerdaderoFalsoClasico vofVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        Respuesta respuestaCorrecta = new Respuesta("Verdadero");

        assert(vofVerdaderaCorrecta.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        Assert.assertEquals("foo", vofVerdaderaCorrecta.getConsigna());
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoLaRespuestaCorrectaFalso() {
        VerdaderoFalsoClasico vofFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");
        Respuesta respuestaCorrecta = new Respuesta("Falso");

        assert(vofFalsaCorrecta.getRespuestaCorrecta().esIgualA(respuestaCorrecta));
        Assert.assertEquals("bar", vofFalsaCorrecta.getConsigna());
    }

    @Test
    public void testCalcularPuntajeParaFuncionaCorrectamente() {
        VerdaderoFalsoClasico vofClasicoVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        VerdaderoFalsoClasico vofClasicoFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        Respuesta verdadera = new Respuesta("Verdadero");
        respuestasCorrectas.agregar(verdadera);
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        Respuesta falsa = new Respuesta("Falso");
        respuestasIncorrectas.agregar(falsa);

        assertEquals(1, vofClasicoVerdaderaCorrecta.calcularPuntajePara(respuestasCorrectas));
        assertEquals(0, vofClasicoVerdaderaCorrecta.calcularPuntajePara(respuestasIncorrectas));

    }

    public void testCalcularPuntajeParaFuncionaCorrectamenteAlAsertarConLaFalsa() {

        VerdaderoFalsoClasico vofClasicoVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        VerdaderoFalsoClasico vofClasicoFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        Respuesta falsa = new Respuesta("Falso");
        respuestasCorrectas.agregar(falsa);
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        Respuesta verdadera = new Respuesta("Verdadero");
        respuestasCorrectas.agregar(verdadera);

        assertEquals(1, vofClasicoFalsaCorrecta.calcularPuntajePara(respuestasCorrectas));
        assertEquals(0, vofClasicoFalsaCorrecta.calcularPuntajePara(respuestasIncorrectas));
    }

    @Test
    public void testVoFClasicoLanzaExcepcionSiSeLaDaUnaRespuestaNoValidaEnCalcularPuntaje(){
        Respuesta verdadera = new Respuesta("Verdadero");
        Respuesta falsa = new Respuesta("Falso");
        Respuesta otra = new Respuesta("foo");

        ListaRespuestas otrasRespuestas = new ListaRespuestas();
        otrasRespuestas.agregar(otra);

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        respuestasCorrectas.agregar(verdadera);

        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        respuestasIncorrectas.agregar(falsa);

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("bar");

        vofClasico.calcularPuntajePara(respuestasCorrectas);
        vofClasico.calcularPuntajePara(respuestasIncorrectas);

        assertThrows(RespuestaNoValidaException.class, ()-> vofClasico.calcularPuntajePara(otrasRespuestas));
    }
}
