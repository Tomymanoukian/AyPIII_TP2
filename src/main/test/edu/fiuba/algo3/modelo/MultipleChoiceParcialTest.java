package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
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
    @Test
    public void testAplicaPuntajeAUnJugadorDeDosRespuestasCorrectas(){
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha",1);
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta",1);
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota",0);

        respuestasCorrectas.agregar(respuestaCorrectaAlpha);
        respuestasCorrectas.agregar(respuestaCorrectaBetta);
        respuestasIncorrectas.agregar(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        respuestasElegidas.agregar(respuestaCorrectaAlpha);
        respuestasElegidas.agregar(respuestaCorrectaBetta);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas,jugador);

        assertEquals(2, jugador.getPuntos());
    }
    @Test
    public void testAplicaPuntajeDeUnaListaDeRespuestasAdivinandoUno(){
        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Respuesta respuestaCorrectaAlpha = new Respuesta("Alpha",1);
        Respuesta respuestaCorrectaBetta = new Respuesta("Betta",1);
        Respuesta respuestaIncorrectaJota = new Respuesta("Jota",0);

        respuestasCorrectas.agregar(respuestaCorrectaAlpha);
        respuestasCorrectas.agregar(respuestaCorrectaBetta);
        respuestasIncorrectas.agregar(respuestaIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        respuestasElegidas.agregar(respuestaCorrectaAlpha);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas, jugador);
        assertEquals(1, jugador.getPuntos());
    }
    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos(){
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

        Jugador jugador = new Jugador("Pepe");
        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        respuestasElegidas.agregar(respuestaCorrectaAlpha);
        respuestasElegidas.agregar(respuestaIncorrectaJota);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas, jugador);
        assertEquals(0, jugador.getPuntos());
    }
    @Test
    public void testAplicaElPuntajeDeTodasLasRespuestasIncorrectas(){
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

        Jugador jugador = new Jugador("Pepe");
        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        respuestasElegidas.agregar(respuestaInorrectaDobleV);
        respuestasElegidas.agregar(respuestaIncorrectaJota);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas, jugador);
        assertEquals(0, jugador.getPuntos());
    }
}
