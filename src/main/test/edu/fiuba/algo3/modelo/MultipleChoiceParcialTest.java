package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MultipleChoiceParcialTest {
    @Test
    public void testCrearMultipleChoiceParcial(){

        ListaOpciones opcionesCorrectas = new ListaOpciones();
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar");
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort");
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup");

        opcionesCorrectas.agregar(opcionCorrectaCheddar);
        opcionesCorrectas.agregar(opcionCorrectaRoquefort);

        opcionesIncorrectas.agregar(opcionIncorrectaKetchup);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceParcial.getConsigna());
        assert( multipleChoiceParcial.getOpcionesCorrectas().contieneTodo(opcionesCorrectas));
        assert( multipleChoiceParcial.getOpcionesIncorrectas().contieneTodo(opcionesIncorrectas));
    }
    @Test
    public void testAplicaPuntajeAUnJugadorDeDosopcionesCorrectas(){
        ListaOpciones opcionesCorrectas = new ListaOpciones();
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha",new Puntaje(1));
        Opcion opcionCorrectaBetta = new Opcion("Betta",new Puntaje(1));
        Opcion opcionIncorrectaJota = new Opcion("Jota",new Puntaje(0));

        opcionesCorrectas.agregar(opcionCorrectaAlpha);
        opcionesCorrectas.agregar(opcionCorrectaBetta);
        opcionesIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaAlpha);
        opcionesElegidas.agregar(opcionCorrectaBetta);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(2, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }
    @Test
    public void testAplicaPuntajeDeUnaListaDeopcionesAdivinandoUno(){
        ListaOpciones opcionesCorrectas = new ListaOpciones();
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha",new Puntaje(1));
        Opcion opcionCorrectaBetta = new Opcion("Betta",new Puntaje(1));
        Opcion opcionIncorrectaJota = new Opcion("Jota",new Puntaje(0));

        opcionesCorrectas.agregar(opcionCorrectaAlpha);
        opcionesCorrectas.agregar(opcionCorrectaBetta);
        opcionesIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaAlpha);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(1, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }
    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos(){
        ListaOpciones opcionesCorrectas = new ListaOpciones();
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha");
        Opcion opcionCorrectaBetta = new Opcion("Betta");
        Opcion opcionIncorrectaJota = new Opcion("Jota");

        opcionesCorrectas.agregar(opcionCorrectaAlpha);
        opcionesCorrectas.agregar(opcionCorrectaBetta);
        opcionesIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaAlpha);
        opcionesElegidas.agregar(opcionIncorrectaJota);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }
    @Test
    public void testAplicaElPuntajeDeTodasLasopcionesIncorrectas(){
        ListaOpciones opcionesCorrectas = new ListaOpciones();
        ListaOpciones opcionesIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuales de las siguientes opciones son letras griegas";

        Opcion opcionCorrectaAlpha = new Opcion("Alpha");
        Opcion opcionInorrectaDobleV = new Opcion("DobleV");
        Opcion opcionIncorrectaJota = new Opcion("Jota");

        opcionesCorrectas.agregar(opcionCorrectaAlpha);
        opcionesIncorrectas.agregar(opcionInorrectaDobleV);
        opcionesIncorrectas.agregar(opcionIncorrectaJota);

        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionInorrectaDobleV);
        opcionesElegidas.agregar(opcionIncorrectaJota);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceParcial.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }
}
