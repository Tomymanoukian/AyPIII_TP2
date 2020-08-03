package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultipleChoiceParcialTest {
    @Test
    public void testCrearMultipleChoiceParcial() {

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
        assert (multipleChoiceParcial.getOpcionesCorrectas().contieneTodo(respuestasCorrectas));
        assert (multipleChoiceParcial.getOpcionesIncorrectas().contieneTodo(respuestasIncorrectas));
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeDosRespuestasCorrectas() {

        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", 1);
        Opcion opcionCorrectaBetta = new Opcion("Betta", 1);
        Opcion opcionIncorrectaJota = new Opcion("Jota", 0);

        ListaOpciones respuestasCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha, opcionCorrectaBetta)));
        ListaOpciones respuestasIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaJota)));

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha, opcionCorrectaBetta)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador, jugador);

        assertEquals(2, jugador.getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaListaDeRespuestasAdivinandoUno() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha", 1);
        Opcion opcionCorrectaBetta = new Opcion("Betta", 1);
        Opcion opcionIncorrectaJota = new Opcion("Jota", 0);

        respuestasCorrectas.agregar(opcionCorrectaAlpha);
        respuestasCorrectas.agregar(opcionCorrectaBetta);
        respuestasIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas);

        Jugador jugador = new Jugador("Pepe");

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador, jugador);

        assertEquals(1, jugador.getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos() {
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

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaAlpha,opcionIncorrectaJota)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador, jugador);

        assertEquals(0, jugador.getPuntos());
    }

    @Test
    public void testAplicaElPuntajeDeTodasLasRespuestasIncorrectas() {
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

        ListaOpciones opcionesSeleccionadas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionInorrectaDobleV,opcionIncorrectaJota)));
        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesSeleccionadas);

        multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador, jugador);

        assertEquals(0, jugador.getPuntos());
    }
}
