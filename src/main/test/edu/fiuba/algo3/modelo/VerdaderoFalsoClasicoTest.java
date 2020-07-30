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

    public void testCalcularPuntajeParaFuncionaCorrectamenteAlAsertarConLaFalsa() {

        VerdaderoFalsoClasico vofClasicoVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        VerdaderoFalsoClasico vofClasicoFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");

        Respuesta falsa = new Respuesta("Falso");
        Respuesta verdadera = new Respuesta("Verdadero");

        ListaRespuestas listaVerdadera =  new ListaRespuestas();
        ListaRespuestas listaFalsa =  new ListaRespuestas();
        listaVerdadera.agregar(verdadera);
        listaFalsa.agregar(falsa);

        assertEquals(1, vofClasicoVerdaderaCorrecta.calcularPuntajePara(listaVerdadera));
        assertEquals(0, vofClasicoVerdaderaCorrecta.calcularPuntajePara(listaFalsa));

        assertEquals(1, vofClasicoFalsaCorrecta.calcularPuntajePara(listaFalsa));
        assertEquals(0, vofClasicoFalsaCorrecta.calcularPuntajePara(listaVerdadera));

    }

    @Test
    public void testVoFClasicoLanzaExcepcionSiSeLaDaUnaRespuestaNoValidaAlEvaluarRespuestas(){
        Respuesta verdadera = new Respuesta("Verdadero");
        Respuesta falsa = new Respuesta("Falso");
        Respuesta otra = new Respuesta("foo");
        Jugador jugador = new Jugador("Pedro");


        ListaRespuestas listaVerdadera =  new ListaRespuestas();
        ListaRespuestas listaFalsa =  new ListaRespuestas();
        ListaRespuestas listaOtra =  new ListaRespuestas();
        listaVerdadera.agregar(verdadera);
        listaFalsa.agregar(falsa);
        listaOtra.agregar(otra);

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("bar");

        vofClasico.calcularPuntajePara(listaVerdadera);
        vofClasico.calcularPuntajePara(listaFalsa);

        assertThrows(RespuestaNoValidaException.class, ()-> vofClasico.evaluarRespuestaPara(listaOtra, jugador ));
    }

    @Test
    public void testVoFClasicoLanzaExcepcionSiSeIngresaMasDeUnaRespuesta(){
        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("bar");
        Jugador jugador = new Jugador("Pedro");

        Respuesta verdadera = new Respuesta("Verdadero");
        Respuesta falsa = new Respuesta("Falso");

        ListaRespuestas lista =  new ListaRespuestas();

        assertThrows(CantidadDeRespuestasInvalidaException.class, ()-> vofClasico.evaluarRespuestaPara(lista, jugador));

        lista.agregar(verdadera);
        lista.agregar(falsa);

        assertThrows(CantidadDeRespuestasInvalidaException.class, ()-> vofClasico.evaluarRespuestaPara(lista, jugador));
    }
}
