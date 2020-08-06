package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    private String consigna = "Agrupe en las categorias A y B:";

    private Opcion opcion1DeGrupoA;
    private Opcion opcion2DeGrupoA;
    private Opcion opcion1DeGrupoB;
    private Opcion opcion2DeGrupoB;

    private ListaOpciones opcionesGrupoA;
    private ListaOpciones opcionesGrupoB ;

    @BeforeEach
    public void setup (){
        String consigna = "Agrupe en las categorias A y B:";

        opcion1DeGrupoA = new Opcion("respuestaGrupoA");
        opcion2DeGrupoA = new Opcion("respuestaGrupoA");
         opcion1DeGrupoB = new Opcion("respuestaGrupoB");
         opcion2DeGrupoB = new Opcion("respuestaGrupoB");

         opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
         opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));
    }


    @Test
    public void testCrearGroupChoiceCorrectamente(){
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        assertEquals("Agrupe en las categorias A y B:", preguntaGroupChoice.getConsigna());
        assert (preguntaGroupChoice.getOpcionesGrupoA().contieneLoMismo(opcionesGrupoA));
        assert (preguntaGroupChoice.getOpcionesGrupoB().contieneLoMismo(opcionesGrupoB));
    }

    @Test
    public void testLeAsignaUnPuntoDeUnaRespuestaDeGruposCorrecta(){
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesGrupoA,opcionesGrupoB);

        assertEquals(1, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }

    @Test
    public void testLeAsignaCeroPuntosConUnaRespuestaDeGruposCorrectaYTresIncorrectas(){
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        ListaOpciones opcionesDelJugadorGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion1DeGrupoB, opcion2DeGrupoB)));
        ListaOpciones opcionesDelJugadorGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion2DeGrupoA)));

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesDelJugadorGrupoA,opcionesDelJugadorGrupoB);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }

    @Test
    public void testLeAsignaCeroPuntosConUnaRespuestaDeGruposIncorrecta(){
        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        RespuestaDeGrupos respuestasDelJugador = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        assertEquals(0, preguntaGroupChoice.evaluarRespuestaPara(respuestasDelJugador).getPuntos());
    }





}
