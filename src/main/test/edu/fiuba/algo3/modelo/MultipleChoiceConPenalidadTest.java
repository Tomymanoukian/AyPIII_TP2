package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceConPenalidadTest {
    private String consigna;

    private Opcion opcionCorrecta1;
    private Opcion opcionCorrecta2;
    private Opcion opcionIncorrecta1;
    private Opcion opcionIncorrecta2;

    private ListaOpciones opcionesCorrectas ;
    private ListaOpciones opcionesIncorrectas ;

    private ListaOpciones opcionesElegidas;

    @BeforeEach
    public void setup (){

        consigna = "Indicar cuales de las siguientes opciones son quesos";

        opcionCorrecta1 = new Opcion("Cheddar",new Puntaje(1));
        opcionCorrecta2 = new Opcion("Roquefort",new Puntaje(1));
        opcionIncorrecta1 = new Opcion("Ketchup",new Puntaje(-1));
        opcionIncorrecta2 = new Opcion("Mostaza",new Puntaje(-1));

        opcionesCorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionCorrecta1, opcionCorrecta2)));
        opcionesIncorrectas = new ListaOpciones(new ArrayList<>(Arrays.asList(opcionIncorrecta1,opcionIncorrecta2)));

        opcionesElegidas = new ListaOpciones();
    }

    @Test
    public void testCrearMultipleChoiceConPenalidad(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        assertEquals("Indicar cuales de las siguientes opciones son quesos", multipleChoiceConPenalidad.getConsigna());
        assert( multipleChoiceConPenalidad.getOpcionesCorrectas().contieneTodo(opcionesCorrectas));
        assert( multipleChoiceConPenalidad.getOpcionesIncorrectas().contieneTodo(opcionesIncorrectas));
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeDosopcionesCorrectas(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);
        opcionesElegidas.agregar(opcionCorrecta1);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(2, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeAUnJugadorDeUnaOpcionCorrecta(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(1, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaPuntajeDeUnaRespuestaCorrectaYOtraIncorrectaSumandoCeroPuntos(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);
        opcionesElegidas.agregar(opcionIncorrecta1);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }

    @Test
    public void testAplicaElPuntajeDe2OpcionesIncorrectas(){
        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionIncorrecta1);
        opcionesElegidas.agregar(opcionIncorrecta2);

        RespuestaEnLista respuestaDelJugador = new RespuestaEnLista(opcionesElegidas);

        assertEquals(-2, multipleChoiceConPenalidad.evaluarRespuestaPara(respuestaDelJugador).getPuntos());
    }
}