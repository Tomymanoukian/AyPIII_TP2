package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OrderedChoice;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OrderedChoiceTest {
    @Test
    public void testCrearOrderedChoice() {

        String consigna = "Ordenar los numeros de menor a mayor";

        Opcion opcion1 = new Opcion("1");
        Opcion opcion2 = new Opcion("2");
        Opcion opcion3 = new Opcion("3");

        ListaOpciones listaDeOpciones = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3)));

        OrderedChoice orderedChoice = new OrderedChoice(consigna, listaDeOpciones);

        assertEquals("Ordenar los numeros de menor a mayor", orderedChoice.getConsigna());
        assert (orderedChoice.getOpciones().esIgual(listaDeOpciones));
    }

    @Test
    public void testCalculaPuntajeParaRespuestasOrdenadas() {

        String consigna = "Ordenar los numeros de menor a mayor";

        Opcion opcion1 = new Opcion("1");
        Opcion opcion2 = new Opcion("2");
        Opcion opcion3 = new Opcion("3");

        ListaOpciones listaDeOpciones = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3)));

        OrderedChoice orderedChoice = new OrderedChoice(consigna, listaDeOpciones);

        ListaOpciones opcionesElegidas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3)));


        assertEquals(1, orderedChoice.calcularPuntajePara(opcionesElegidas).getPuntos());
    }

    @Test
    public void testCalculaPuntajeParaRespuestasDesordenadas() {

        String consigna = "Ordenar los numeros de menor a mayor";

        Opcion opcion1 = new Opcion("1");
        Opcion opcion2 = new Opcion("2");
        Opcion opcion3 = new Opcion("3");

        ListaOpciones listaDeOpciones = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3)));

        OrderedChoice orderedChoice = new OrderedChoice(consigna, listaDeOpciones);

        ListaOpciones opcionesElegidas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1, opcion3, opcion2)));


        assertEquals(0, orderedChoice.calcularPuntajePara(opcionesElegidas).getPuntos());
    }
    @Test
    public void testOrederedChoiceLanzaExcepcionSiSeLeIngresanMenosDeDosOpciones(){
        String consigna = "Ordenar los numeros de menor a mayor";

        Opcion opcion1 = new Opcion("1");
        ListaOpciones listaDeOpciones = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1)));

        assertThrows(CantidadDeOpcionesInvalidaException.class, ()-> new OrderedChoice(consigna, listaDeOpciones));
    }

    @Test
    public void testOrederedChoiceLanzaExcepcionSiSeLeIngresanMasDeCincoOpciones(){
        String consigna = "Ordenar los numeros de menor a mayor";

        Opcion opcion1 = new Opcion("1");
        Opcion opcion2 = new Opcion("2");
        Opcion opcion3 = new Opcion("3");
        Opcion opcion4 = new Opcion("4");
        Opcion opcion5 = new Opcion("5");
        Opcion opcion6 = new Opcion("6");

        ListaOpciones listaDeOpciones = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)));

        assertThrows(CantidadDeOpcionesInvalidaException.class, ()-> new OrderedChoice(consigna, listaDeOpciones));
    }
}