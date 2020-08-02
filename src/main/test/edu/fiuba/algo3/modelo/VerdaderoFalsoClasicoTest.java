package edu.fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoIndicandoleLaRespuestaCorrectaVerdadera() {
        VerdaderoFalsoClasico vofVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        Opcion opcionCorrecta = new Opcion("Verdadero");

        assert(vofVerdaderaCorrecta.getRespuestaCorrecta().esIgualA(opcionCorrecta));
        Assert.assertEquals("foo", vofVerdaderaCorrecta.getConsigna());
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoLaRespuestaCorrectaFalso() {
        VerdaderoFalsoClasico vofFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");
        Opcion opcionCorrecta = new Opcion("Falso");

        assert(vofFalsaCorrecta.getRespuestaCorrecta().esIgualA(opcionCorrecta));
        Assert.assertEquals("bar", vofFalsaCorrecta.getConsigna());
    }

    public void testCalcularPuntajeParaFuncionaCorrectamenteAlAsertarConLaFalsa() {

        VerdaderoFalsoClasico vofClasicoVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        VerdaderoFalsoClasico vofClasicoFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");

        Opcion falsa = new Opcion("Falso");
        Opcion verdadera = new Opcion("Verdadero");

        ListaOpciones listaVerdadera =  new ListaOpciones();
        ListaOpciones listaFalsa =  new ListaOpciones();
        listaVerdadera.agregar(verdadera);
        listaFalsa.agregar(falsa);

        assertEquals(1, vofClasicoVerdaderaCorrecta.calcularPuntajePara(listaVerdadera));
        assertEquals(0, vofClasicoVerdaderaCorrecta.calcularPuntajePara(listaFalsa));

        assertEquals(1, vofClasicoFalsaCorrecta.calcularPuntajePara(listaFalsa));
        assertEquals(0, vofClasicoFalsaCorrecta.calcularPuntajePara(listaVerdadera));

    }

    @Test
    public void testVoFClasicoLanzaExcepcionSiSeLaDaUnaRespuestaNoValidaAlEvaluarRespuestas(){
        Opcion verdadera = new Opcion("Verdadero");
        Opcion falsa = new Opcion("Falso");
        Opcion otra = new Opcion("foo");
        Jugador jugador = new Jugador("Pedro");


        ListaOpciones listaVerdadera =  new ListaOpciones();
        ListaOpciones listaFalsa =  new ListaOpciones();
        ListaOpciones listaOtra =  new ListaOpciones();
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

        Opcion verdadera = new Opcion("Verdadero");
        Opcion falsa = new Opcion("Falso");

        ListaOpciones lista =  new ListaOpciones();

        assertThrows(CantidadDeRespuestasInvalidaException.class, ()-> vofClasico.evaluarRespuestaPara(lista, jugador));

        lista.agregar(verdadera);
        lista.agregar(falsa);

        assertThrows(CantidadDeRespuestasInvalidaException.class, ()-> vofClasico.evaluarRespuestaPara(lista, jugador));
    }
}
