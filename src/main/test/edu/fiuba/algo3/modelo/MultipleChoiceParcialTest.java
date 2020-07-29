package edu.fiuba.algo3.modelo;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultipleChoiceParcialTest {
    @Test
    public void testCrearMultipleChoiceParcial(){

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Respuesta respuestaCorrectaCheddar = new Respuesta("Cheddar");
        Respuesta respuestaCorrectaRoquefort = new Respuesta("Roquefort");
        Respuesta respuestaIncorrectaKetchup = new Respuesta("Ketchup");

        respuestasCorrectas.agregar(respuestaCorrectaCheddar);
        respuestasCorrectas.agregar(respuestaCorrectaRoquefort);

        respuestasIncorrectas.agregar(respuestaIncorrectaKetchup);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceParcial.getConsigna());
        assert( multipleChoiceParcial.getRespuestasCorrectas().contieneTodo(respuestasCorrectas));
        assert( multipleChoiceParcial.getRespuestasIncorrectas().contieneTodo(respuestasIncorrectas));
    }

    public void testCalculaPuntajeDeDosRespuestasCorrectas(){
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.agregar(respuestaCorrectaAlpha);
        respuestasCorrectas.agregar(respuestaCorrectaBetta);
        respuestasIncorrectas.agregar(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        Respuesta respuestaAlpha = new Respuesta("Alpha");
        Respuesta respuestaBetta = new Respuesta("Betta");
        respuestasElegidas.agregar(respuestaAlpha);
        respuestasElegidas.agregar(respuestaBetta);

        assertEquals(2, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }
    public void testCalculaPuntajeDeUnaListaDeRespuestasAdivinando1(){
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.agregar(respuestaCorrectaAlpha);
        respuestasCorrectas.agregar(respuestaCorrectaBetta);
        respuestasIncorrectas.agregar(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        Respuesta respuestaAlpha = new Respuesta("Alpha");
        respuestasElegidas.agregar(respuestaAlpha);

        assertEquals(1, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }

    public void testCalculaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaDevolviendo0(){
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.agregar(respuestaCorrectaAlpha);
        respuestasCorrectas.agregar(respuestaCorrectaBetta);
        respuestasIncorrectas.agregar(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        Respuesta respuestaAlpha = new Respuesta("Alpha");
        Respuesta respuestaJota = new Respuesta("Jota");
        respuestasElegidas.agregar(respuestaAlpha);
        respuestasElegidas.agregar(respuestaJota);

        assertEquals(0, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }

    public void testCalculaPuntajeDeTodasLasRespuestasIncorrectas(){
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha");
        Respuesta respuestaInorrectaDobleV = new Respuesta("DobleV");
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota");

        respuestasCorrectas.agregar(respuestaCorrectaAlpha);
        respuestasIncorrectas.agregar(respuestaInorrectaDobleV);
        respuestasIncorrectas.agregar(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        Respuesta respuestaJota = new Respuesta("Jota");
        Respuesta respuestaDobleV = new Respuesta("DobleV");
        respuestasElegidas.agregar(respuestaDobleV);
        respuestasElegidas.agregar(respuestaJota);

        assertEquals(0, multipleChoiceParcial.calcularPuntajePara(respuestasElegidas));
    }
}
