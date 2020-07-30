package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class KahootTest {

    @Test
    public void testSeCreaUnKahootConDosJugadoresConPuntaje0(){

        Jugador pablo = new Jugador("Pablo");
        Jugador matias = new Jugador("Matias");

        Kahoot kahoot = new Kahoot(pablo, matias);

        assertEquals(0,kahoot.getPuntajeJugador1());
        assertEquals(0,kahoot.getPuntajeJugador2());

    }

    public void testSeCreaUnKahootConDosJugadoresPidiendoleElPuntajeAlJugador1(){

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        assertEquals(0,kahoot.getPuntajeJugador1());

    }

    public void testSeCreaUnKahootConDosJugadoresPidiendoleElPuntajeAlJugador2(){

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        assertEquals(0,kahoot.getPuntajeJugador2());

    }



}