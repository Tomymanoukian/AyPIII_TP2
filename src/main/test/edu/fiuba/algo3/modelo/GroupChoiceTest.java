package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.BeforeEach;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testGroupChoiceLanzaExcepcionSiSeLeIngresan7Opciones(){
        String consigna = "Agrupe las opciones en dos grupos";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA");
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA");
        Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA");
        Opcion opcion4DeGrupoA = new Opcion("respuestaGrupoA");
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB");
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB");
        Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB");

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA, opcion4DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB)));

        assertThrows(CantidadDeOpcionesInvalidaException.class, ()-> new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB));
    }
    @Test
    public void testGroupChoiceLanzaExcepcionSiSeLeIngresa1Opcion(){
        String consigna = "Agrupe las opciones en dos grupos";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA");

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList()));

        assertThrows(CantidadDeOpcionesInvalidaException.class, ()-> new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB));
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

    @Test
    public void testSeVerificaQueSePuedaUtilizarMultiplicador(){

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);
        assertEquals(false, preguntaGroupChoice.aceptaMultiplicador());
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarExclusividad(){

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);
        assertEquals(true, preguntaGroupChoice.aceptaExclusividad());
    }
}
