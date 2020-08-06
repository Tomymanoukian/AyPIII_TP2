package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultipleChoiceConPenalidadTest {

    /*@Before    ///////Agregar después en una refactorización
    public void setup (){

        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar");
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort");
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup");

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));
    }*/

    @Test
    public void testCrearMultipleChoiceConPenalidad(){

        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar");
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort");
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup");

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceConPenalidad.getConsigna());
        assert( multipleChoiceConPenalidad.getOpcionesCorrectas().contieneTodo(opcionesCorrectas));
        assert( multipleChoiceConPenalidad.getOpcionesIncorrectas().contieneTodo(opcionesIncorrectas));
    }

    @Test
    public void testMultipleChoiceConPenalidadLanzaExcepcionSiSeLeIngresan6Opciones() {
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

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceConPenalidad(consigna, respuestasCorrectas, respuestasIncorrectas));
    }
    @Test
    public void testMultipleChoiceConPenalidadLanzaExcepcionSiSeLeIngresa1Opcion() {
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");

        respuestasCorrectas.agregar(opcionCorrecta1);

        assertThrows(CantidadDeOpcionesInvalidaException.class, () -> new MultipleChoiceConPenalidad(consigna, respuestasCorrectas, respuestasIncorrectas));
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeDosopcionesCorrectas(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",new Puntaje(1));
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",new Puntaje(1));
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",new Puntaje(-1));

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaCheddar);
        opcionesElegidas.agregar(opcionCorrectaRoquefort);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(2, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeUnaOpcionCorrecta(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",new Puntaje(1));
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",new Puntaje(1));
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",new Puntaje(-1));

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaCheddar);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(1, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",new Puntaje(1));
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",new Puntaje(1));
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",new Puntaje(-1));

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaCheddar);
        opcionesElegidas.agregar(opcionIncorrectaKetchup);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaElPuntajeDe2OpcionesIncorrectas(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",new Puntaje(1));
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",new Puntaje(1));
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",new Puntaje(-1));
        Opcion opcionIncorrectaMostaza = new Opcion("Mostaza",new Puntaje(-1));

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionIncorrectaKetchup);
        opcionesElegidas.agregar(opcionIncorrectaMostaza);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(-2, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }
}