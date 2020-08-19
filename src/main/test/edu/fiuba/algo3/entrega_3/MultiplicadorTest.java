package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Bonus.Multiplicador;
import edu.fiuba.algo3.modelo.Puntaje;
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
        Puntaje puntaje = new Puntaje(3);

        mx3.aplicarMultiplicador(puntaje);

        assertEquals(9, puntaje.getPuntos());
    }
}
