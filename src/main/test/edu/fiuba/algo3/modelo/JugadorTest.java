package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorSinNombreException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTest {

    @Test
    public void testCreaUnJugadorConPuntuacionCero() {

        Jugador jugador = new Jugador("Pepito");

        assertEquals(0,jugador.getPuntaje().getPuntos());
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
        jugador.sumarPuntos(new Puntaje(5));

        assertEquals(5, jugador.getPuntaje().getPuntos());
    }

    @Test
    public void testJugadorSinPuntosDisminuyeSusPuntosEnUnoYTieneUnPuntajeDeMenosUno(){

        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(new Puntaje(-1));

        assertEquals(-1, jugador.getPuntaje().getPuntos());
    }

    @Test
    public void testJugadorConPuntosDisminuyeSusPuntosPorDebajoDeCeroComoResultadoTienePuntajeNegativo(){

        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(new Puntaje(3));
        jugador.sumarPuntos(new Puntaje(-5));

        assertEquals(-2, jugador.getPuntaje().getPuntos());
    }

    @Test
    public void testJugadorConCuatroPuntosDisminuyeSusPuntosEnDos(){

        Jugador jugador = new Jugador("Juan");
        jugador.sumarPuntos(new Puntaje(4));
        jugador.sumarPuntos(new Puntaje(-2));

        assertEquals(2, jugador.getPuntaje().getPuntos());
    }
}