package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    @Test
    public void testAplicoExclusividadADosJugadoresQueRespondieronCorrectamente(){
        Exclusividad exclusividad = new Exclusividad();
        Jugador jugador1 = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");

        exclusividad.aplicarExclusividad(jugador1, 1, jugador2, 1);

        assertEquals(0, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void testAplicoExclusividadADosJugadoresQueRespondieronIncorrectamente(){
        Exclusividad exclusividad = new Exclusividad();
        Jugador jugador1 = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");

        exclusividad.aplicarExclusividad(jugador1, 0, jugador2, 0);

        assertEquals(0, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void testAplicoExclusividadAUnJugadorQueRespondioCorrectamenteYOtroJugadorQueRespondioIncorrectamente(){
        Exclusividad exclusividad = new Exclusividad();
        Jugador jugador1 = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");

        exclusividad.aplicarExclusividad(jugador1, 1, jugador2, 0);

        assertEquals(2, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }
}
