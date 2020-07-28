package edu.fiuba.algo3.modelo;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceParcialTest {
    @Test
    public void testCrearMultipleChoiceParcial(){

        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Respuesta respuestaCorrectaCheddar = new Respuesta("Cheddar");
        Respuesta respuestaCorrectaRoquefort = new Respuesta("Roquefort");
        Respuesta respuestaIncorrectaKetchup = new Respuesta("Ketchup");

        respuestasCorrectas.add(respuestaCorrectaCheddar);
        respuestasCorrectas.add(respuestaCorrectaRoquefort);

        respuestasIncorrectas.add(respuestaIncorrectaKetchup);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceParcial.getConsigna());
        assert( multipleChoiceParcial.getRespuestasCorrectas().containsAll(respuestasCorrectas));
        assert( multipleChoiceParcial.getRespuestasIncorrectas().containsAll(respuestasIncorrectas));
    }

    public void testCalculaPuntajeDeDosRespuestasCorrectas(){
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.add(respuestaCorrectaAlpha);
        respuestasCorrectas.add(respuestaCorrectaBetta);
        respuestasIncorrectas.add(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        List<Respuesta> respuestasElegidas = new ArrayList<>();
        Respuesta respuestaAlpha = new Respuesta("Alpha");
        Respuesta respuestaBetta = new Respuesta("Betta");
        respuestasElegidas.add(respuestaAlpha);
        respuestasElegidas.add(respuestaBetta);

        assertEquals(2, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }
    public void testCalculaPuntajeDeUnaListaDeRespuestasAdivinando1(){
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.add(respuestaCorrectaAlpha);
        respuestasCorrectas.add(respuestaCorrectaBetta);
        respuestasIncorrectas.add(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        List<Respuesta> respuestasElegidas = new ArrayList<>();
        Respuesta respuestaAlpha = new Respuesta("Alpha");
        respuestasElegidas.add(respuestaAlpha);

        assertEquals(1, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }

    public void testCalculaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaDevolviendo0(){
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.add(respuestaCorrectaAlpha);
        respuestasCorrectas.add(respuestaCorrectaBetta);
        respuestasIncorrectas.add(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        List<Respuesta> respuestasElegidas = new ArrayList<>();
        Respuesta respuestaAlpha = new Respuesta("Alpha");
        Respuesta respuestaJota = new Respuesta("Jota");
        respuestasElegidas.add(respuestaAlpha);
        respuestasElegidas.add(respuestaJota);

        assertEquals(0, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }

    public void testCalculaPuntajeDeTodasLasRespuestasIncorrectas(){
        List<Respuesta> respuestasCorrectas = new ArrayList<>();
        List<Respuesta> respuestasIncorrectas = new ArrayList<>();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaInorrectaDobleV = new Respuesta("DobleV");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.add(respuestaCorrectaAlpha);
        respuestasIncorrectas.add(respuestaInorrectaDobleV);
        respuestasIncorrectas.add(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        List<Respuesta> respuestasElegidas = new ArrayList<>();
        Respuesta respuestaJota = new Respuesta("Jota");
        Respuesta respuestaDobleV = new Respuesta("DobleV");
        respuestasElegidas.add(respuestaDobleV);
        respuestasElegidas.add(respuestaJota);

        assertEquals(0, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }
}
