package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTest {

    @Test
    public void testCreaUnJugadorConPuntuacionCero() {

        Jugador jugador = new Jugador("Pepito");

        assertEquals(0,jugador.getPuntos());
    }

    @Test
    public void testCreaUnJugadorConNombre(){

        Jugador jugador = new Jugador("Juan");

        assertEquals("Juan", jugador.getNombre());
    }

    @Test
    public void testNoPuedeCrearUnJugadorSinNombre(){

        assertThrows(JugadorSinNombreException.class, ()-> new Jugador(""));
    }

    @Test
    public void testJugadorAumentaSusPuntosEn5(){

        Jugador jugador = new Jugador("Juan");
        jugador.modificarPuntos(5);

        assertEquals(5, jugador.getPuntos());
    }

    @Test
    public void testJugadorSinPuntosDisminuyeSusPuntosEnUnoYTieneUnPuntajeDeMenosUno(){

        Jugador jugador = new Jugador("Juan");
        jugador.modificarPuntos(-1);

        assertEquals(-1, jugador.getPuntos());
    }

    @Test
    public void testJugadorConPuntosDisminuyeSusPuntosPorDebajoDeCeroComoResultadoTienePuntajeNegativo(){

        Jugador jugador = new Jugador("Juan");
        jugador.modificarPuntos(3);
        jugador.modificarPuntos(-5);

        assertEquals(-2, jugador.getPuntos());
    }

    @Test
    public void testJugadorConCuatroPuntosDisminuyeSusPuntosEnDos(){

        Jugador jugador = new Jugador("Juan");
        jugador.modificarPuntos(4);
        jugador.modificarPuntos(-2);

        assertEquals(2, jugador.getPuntos());
    }


}