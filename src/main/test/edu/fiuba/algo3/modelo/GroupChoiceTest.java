package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void testCrearGroupChoiceCorrectamente(){

        String consigna = "Agrupe en las categorias A y B:";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        assertEquals("Agrupe en las categorias A y B:", preguntaGroupChoice.getConsigna());
        assert (preguntaGroupChoice.getOpcionesGrupoA().contieneLoMismo(opcionesGrupoA));
        assert (preguntaGroupChoice.getOpcionesGrupoB().contieneLoMismo(opcionesGrupoB));
    }

    @Test
    public void testLeAsignaUnPuntoDeUnaRespuestaDeGruposCorrecta(){

        String consigna = "Agrupe en las categorias A y B:";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        Jugador jugador = new Jugador("Juan");
        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesGrupoA,opcionesGrupoB);

        assertEquals(1, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador));
    }

    @Test
    public void testLeAsignaCeroPuntosConUnaRespuestaDeGruposCorrectaYTresIncorrectas(){

        String consigna = "Agrupe en las categorias A y B:";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));

        ListaOpciones opcionesDelJugadorGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion1DeGrupoB, opcion2DeGrupoB)));
        ListaOpciones opcionesDelJugadorGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion2DeGrupoA)));

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        Jugador jugador = new Jugador("Juan");
        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesDelJugadorGrupoA,opcionesDelJugadorGrupoB);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador));
    }

    @Test
    public void testLeAsignaCeroPuntosConUnaRespuestaDeGruposIncorrecta(){

        String consigna = "Agrupe en las categorias A y B:";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        Jugador jugador = new Jugador("Juan");
        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador));
    }





}
