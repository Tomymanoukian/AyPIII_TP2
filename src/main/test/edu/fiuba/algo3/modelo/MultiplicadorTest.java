package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {

    @Test
    public void testCreaUnMultiplicadorx2() {

        Multiplicador multiplicador = new Multiplicador(2);

        assertEquals(2,multiplicador.getFactorDeMultiplicacion());
    }

    @Test
    public void testCreaUnMultiplicadorYSeSeteax2() {

        Multiplicador multiplicador = new Multiplicador();

        multiplicador.setFactorDeMultiplicacion(2);

        assertEquals(2,multiplicador.getFactorDeMultiplicacion());
    }

    @Test
    public void testCreaUnMultiplicadorx5negativo() {

        Multiplicador multiplicador = new Multiplicador(-5);

        assertEquals(-5,multiplicador.getFactorDeMultiplicacion());
    }

    @Test
    public void testSeAplicaUnMultiplicadorPorTresCorrectamenteALPuntajeDeUnJugador(){
        Multiplicador mx3 = new Multiplicador(3);
        Jugador jugador = new Jugador("jugador");

        mx3.aplicarMultiplicador(jugador, 3);

        assertEquals(9, jugador.getPuntos());
    }
}
