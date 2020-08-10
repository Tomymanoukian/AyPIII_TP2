package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    public void testMultipleChoiceParcialLanzaExcepcionSiSeLeIngresan6Opciones() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionCorrecta3 = new Opcion("Verde");
        Opcion opcionCorrecta4 = new Opcion("Rojo");
        Opcion opcionIncorrecta1 = new Opcion("Tractor");
        Opcion opcionIncorrecta2 = new Opcion("Auto");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasCorrectas.agregar(opcionCorrecta3);
        respuestasCorrectas.agregar(opcionCorrecta4);
        respuestasIncorrectas.agregar(opcionIncorrecta1);
        respuestasIncorrectas.agregar(opcionIncorrecta2);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas));
    }

    @Test
    public void testMultipleChoiceParcialLanzaExcepcionSiSeLeIngresa1Opcion() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");

        respuestasCorrectas.agregar(opcionCorrecta1);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceParcial(consigna, respuestasCorrectas, respuestasIncorrectas));
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

    @Test
    public void testSeVerificaQueSePuedaUtilizarMultiplicador(){

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
        assertEquals(false, multipleChoiceParcial.aceptaMultiplicador());
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarExclusividad(){

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
        assertEquals(true, multipleChoiceParcial.aceptaExclusividad());
    }
}
