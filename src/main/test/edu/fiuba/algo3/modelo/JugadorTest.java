package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        jugador.aumentarPuntos(5);

        assertEquals(5, jugador.getPuntos());
    }

    @Test
    public void testJugadorNoPuedeAumentarUnPuntajeNegativo(){
        Jugador jugador = new Jugador("Pedro");

        assertThrows(PuntosNegativoException.class, ()-> jugador.aumentarPuntos(-1));
    }

    @Test
    public void testJugadorSinPuntosDisminuyeSusPuntosEn1YSeMantieneEnCero(){

        Jugador jugador = new Jugador("Juan");
        jugador.disminuirPuntos(1);

        assertEquals(0, jugador.getPuntos());
    }

    @Test
    public void testJugadorNoPuedeDisminuirUnPuntajeNegativo(){
        Jugador jugador = new Jugador("Pedro");

        assertThrows(PuntosNegativoException.class, ()-> jugador.disminuirPuntos(-1));
    }

    @Test
    public void testJugadorCon4PuntosDisminuyeSusPuntosEn2(){

        Jugador jugador = new Jugador("Juan");
        jugador.aumentarPuntos(4);
        jugador.disminuirPuntos(2);

        assertEquals(2, jugador.getPuntos());
    }


}