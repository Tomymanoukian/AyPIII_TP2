package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoValidoException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class KahootTest {

    @Test
    public void testSeCreaUnKahootConDosJugadoresConPuntaje0(){

        Jugador pablo = new Jugador("Pablo");
        Jugador matias = new Jugador("Matias");

        Kahoot kahoot = new Kahoot(pablo, matias);

        assertEquals(0,kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0,kahoot.getPuntajeJugador2().getPuntos());

    }

    @Test
    public void testSeCreaUnKahootConDosJugadoresPidiendoleElPuntajeAlJugador1(){

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        assertEquals(0,kahoot.getPuntajeJugador1().getPuntos());

    }

    @Test
    public void testSeCreaUnKahootConDosJugadoresPidiendoleElPuntajeAlJugador2(){

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        assertEquals(0,kahoot.getPuntajeJugador2().getPuntos());

    }

    @Test
    public void testUtilizarBonusConOtroJugadorLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");
        Jugador otroJugador = new Jugador("otroJugador");

        Kahoot kahoot = new Kahoot(martin, jose);

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("consigna");
        VerdaderoFalsoConPenalidad vofConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso("consigna");

        /*String consigna = "bar";

        Opcion opcion1DeGrupoA = new Opcion("respuesta1GrupoA");
        Opcion opcion2DeGrupoA = new Opcion("respuesta2GrupoA");
        Opcion opcion1DeGrupoB = new Opcion("respuesta1GrupoB");
        Opcion opcion2DeGrupoB = new Opcion("respuesta2GrupoB");

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));

        GroupChoice unGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);*/

        assertThrows(JugadorNoValidoException.class, ()-> kahoot.agregarMultiplicadorX2(vofConPenalidad, otroJugador));
        assertThrows(JugadorNoValidoException.class, ()-> kahoot.agregarMultiplicadorX3(vofConPenalidad, otroJugador));
        assertThrows(JugadorNoValidoException.class, ()-> kahoot.agregarExclusividad(vofClasico, otroJugador));
    }

    @Test
    public void devuelveCorrectamenteAlJugador1GanadorYAlJugador2Perdedor(){
        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        martin.sumarPuntos(new Puntaje(20));
        jose.sumarPuntos(new Puntaje(10));

        assertEquals(martin, kahoot.getJugadorGanador());
        assertEquals(jose, kahoot.getJugadorPerdedor());

    }

    @Test
    public void devuelveCorrectamenteAlJugador2GanadorYAlJugador1Perdedor(){
        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(jose, martin);

        martin.sumarPuntos(new Puntaje(20));
        jose.sumarPuntos(new Puntaje(10));

        assertEquals(martin, kahoot.getJugadorGanador());
        assertEquals(jose, kahoot.getJugadorPerdedor());

    }
}