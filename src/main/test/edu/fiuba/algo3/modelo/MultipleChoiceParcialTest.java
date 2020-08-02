package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MultipleChoiceParcialTest {
    @Test
    public void testCrearMultipleChoiceParcial(){

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar");
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort");
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup");

        respuestasCorrectas.agregar(opcionCorrectaCheddar);
        respuestasCorrectas.agregar(opcionCorrectaRoquefort);

        respuestasIncorrectas.agregar(opcionIncorrectaKetchup);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceParcial.getConsigna());
        assert( multipleChoiceParcial.getRespuestasCorrectas().contieneTodo(respuestasCorrectas));
        assert( multipleChoiceParcial.getRespuestasIncorrectas().contieneTodo(respuestasIncorrectas));
    }
    @Test
    public void testAplicaPuntajeAUnJugadorDeDosRespuestasCorrectas(){
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha",1);
        Opcion opcionCorrectaBetta = new Opcion("Betta",1);
        Opcion opcionIncorrectaJota = new Opcion("Jota",0);

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasCorrectas.agregar(opcionCorrectaBetta);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones respuestasElegidas = new ListaOpciones();
        respuestasElegidas.agregar(opcionCorrectaAlpha);
        respuestasElegidas.agregar(opcionCorrectaBetta);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas,jugador);

        assertEquals(2, jugador.getPuntos());
    }
    @Test
    public void testAplicaPuntajeDeUnaListaDeRespuestasAdivinandoUno(){
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha",1);
        Opcion opcionCorrectaBetta = new Opcion("Betta",1);
        Opcion opcionIncorrectaJota = new Opcion("Jota",0);

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasCorrectas.agregar(opcionCorrectaBetta);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones respuestasElegidas = new ListaOpciones();
        respuestasElegidas.agregar(opcionCorrectaAlpha);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas, jugador);
        assertEquals(1, jugador.getPuntos());
    }
    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos(){
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha");
        Opcion opcionCorrectaBetta = new Opcion("Betta");
        Opcion opcionIncorrectaJota = new Opcion("Jota");

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasCorrectas.agregar(opcionCorrectaBetta);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones respuestasElegidas = new ListaOpciones();
        respuestasElegidas.agregar(opcionCorrectaAlpha);
        respuestasElegidas.agregar(opcionIncorrectaJota);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas, jugador);
        assertEquals(0, jugador.getPuntos());
    }
    @Test
    public void testAplicaElPuntajeDeTodasLasRespuestasIncorrectas(){
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha");
        Opcion opcionInorrectaDobleV = new Opcion("DobleV");
        Opcion opcionIncorrectaJota = new Opcion("Jota");

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasIncorrectas.agregar(opcionInorrectaDobleV);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones respuestasElegidas = new ListaOpciones();
        respuestasElegidas.agregar(opcionInorrectaDobleV);
        respuestasElegidas.agregar(opcionIncorrectaJota);

        multipleChoiceParcial.evaluarRespuestaPara(respuestasElegidas, jugador);
        assertEquals(0, jugador.getPuntos());
    }
}
