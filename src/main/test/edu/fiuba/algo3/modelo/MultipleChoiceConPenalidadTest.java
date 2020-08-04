package edu.fiuba.algo3.modelo;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testAplicaPuntajeAUnJugadorDeDosopcionesCorrectas(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",1);
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",1);
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",-1);

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaCheddar);
        opcionesElegidas.agregar(opcionCorrectaRoquefort);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador,jugador);

        assertEquals(2, jugador.getPuntos());
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeUnaOpcionCorrecta(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",1);
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",1);
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",-1);

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaCheddar);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador,jugador);

        assertEquals(1, jugador.getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",1);
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",1);
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",-1);

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionCorrectaCheddar);
        opcionesElegidas.agregar(opcionIncorrectaKetchup);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador,jugador);

        assertEquals(0, jugador.getPuntos());
    }

    @Test
    public void testAplicaElPuntajeDe2OpcionesIncorrectas(){
        String consigna = "Indicar cuales de las siguientes opciones son quesos";

        Opcion opcionCorrectaCheddar = new Opcion("Cheddar",1);
        Opcion opcionCorrectaRoquefort = new Opcion("Roquefort",1);
        Opcion opcionIncorrectaKetchup = new Opcion("Ketchup",-1);
        Opcion opcionIncorrectaMostaza = new Opcion("Mostaza",-1);

        ListaOpciones opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrectaCheddar, opcionCorrectaRoquefort)));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrectaKetchup)));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador jugador = new Jugador("Pepe");
        ListaOpciones opcionesElegidas = new ListaOpciones();
        opcionesElegidas.agregar(opcionIncorrectaKetchup);
        opcionesElegidas.agregar(opcionIncorrectaMostaza);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador,jugador);

        assertEquals(-2, jugador.getPuntos());
    }
}