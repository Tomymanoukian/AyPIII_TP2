package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusDePuntajeTest {

    @Test
    public void bonusDePuntajeAplicaUnUnicoMultiplicador(){
        Puntaje puntaje1 = new Puntaje(2);
        Puntaje puntaje2 = new Puntaje(2);

        Multiplicador multiplicador = new Multiplicador(2);
        ListaDeMultiplicadores listaDeMultiplicadores1 = new ListaDeMultiplicadores(multiplicador);
        ListaDeMultiplicadores listaDeMultiplicadores2 = new ListaDeMultiplicadores();
        ListaDeExclusividades listaDeExclusividades1 = new ListaDeExclusividades();
        ListaDeExclusividades listaDeExclusividades2 = new ListaDeExclusividades();

        BonusDePuntaje.aplicarbonus(puntaje1, listaDeMultiplicadores1, listaDeExclusividades1, puntaje2, listaDeMultiplicadores2, listaDeExclusividades2);

        assertEquals(4, puntaje1.getPuntos());
        assertEquals(2, puntaje2.getPuntos());
    }

    @Test
    public void bonusDePuntajeAplicaDosMultiplicadoresAUnPuntaje(){
        Puntaje puntaje1 = new Puntaje(2);
        Puntaje puntaje2 = new Puntaje(2);

        Multiplicador multiplicador1 = new Multiplicador(2);
        Multiplicador multiplicador2 = new Multiplicador(3);

        ListaDeMultiplicadores listaDeMultiplicadores1 = new ListaDeMultiplicadores(new ArrayList<>(Arrays.asList(multiplicador1, multiplicador2)));
        ListaDeMultiplicadores listaDeMultiplicadores2 = new ListaDeMultiplicadores();
        ListaDeExclusividades listaDeExclusividades1 = new ListaDeExclusividades();
        ListaDeExclusividades listaDeExclusividades2 = new ListaDeExclusividades();

        BonusDePuntaje.aplicarbonus(puntaje1, listaDeMultiplicadores1, listaDeExclusividades1, puntaje2, listaDeMultiplicadores2, listaDeExclusividades2);

        assertEquals(12, puntaje1.getPuntos());
        assertEquals(2, puntaje2.getPuntos());
    }

    @Test
    public void bonusDePuntajeAplicaDosMultiplicadoresALosDosPuntajes(){
        Puntaje puntaje1 = new Puntaje(2);
        Puntaje puntaje2 = new Puntaje(2);

        Multiplicador multiplicador1 = new Multiplicador(2);
        Multiplicador multiplicador2 = new Multiplicador(3);
        Multiplicador multiplicador3 = new Multiplicador(4);
        Multiplicador multiplicador4 = new Multiplicador(5);

        ListaDeMultiplicadores listaDeMultiplicadores1 = new ListaDeMultiplicadores(new ArrayList<>(Arrays.asList(multiplicador1, multiplicador2)));
        ListaDeMultiplicadores listaDeMultiplicadores2 = new ListaDeMultiplicadores(new ArrayList<>(Arrays.asList(multiplicador3, multiplicador4)));
        ListaDeExclusividades listaDeExclusividades1 = new ListaDeExclusividades();
        ListaDeExclusividades listaDeExclusividades2 = new ListaDeExclusividades();

        BonusDePuntaje.aplicarbonus(puntaje1, listaDeMultiplicadores1, listaDeExclusividades1, puntaje2, listaDeMultiplicadores2, listaDeExclusividades2);

        assertEquals(12, puntaje1.getPuntos());
        assertEquals(40, puntaje2.getPuntos());
    }

    @Test
    public void bonusDePuntajeAplicaUnaExclusividadConDosPuntajesNulos(){
        Puntaje puntaje1 = new Puntaje(0);
        Puntaje puntaje2 = new Puntaje(0);

        Exclusividad exclusividad = new Exclusividad();

        ListaDeMultiplicadores listaDeMultiplicadores1 = new ListaDeMultiplicadores();
        ListaDeMultiplicadores listaDeMultiplicadores2 = new ListaDeMultiplicadores();
        ListaDeExclusividades listaDeExclusividades1 = new ListaDeExclusividades(exclusividad);
        ListaDeExclusividades listaDeExclusividades2 = new ListaDeExclusividades();

        BonusDePuntaje.aplicarbonus(puntaje1, listaDeMultiplicadores1, listaDeExclusividades1, puntaje2, listaDeMultiplicadores2, listaDeExclusividades2);

        assertEquals(0, puntaje1.getPuntos());
        assertEquals(0, puntaje2.getPuntos());
    }

    @Test
    public void bonusDePuntajeAplicaUnaExclusividadConUnUnicoPuntajesNulo(){
        Puntaje puntaje1 = new Puntaje(0);
        Puntaje puntaje2 = new Puntaje(2);

        Exclusividad exclusividad = new Exclusividad();

        ListaDeMultiplicadores listaDeMultiplicadores1 = new ListaDeMultiplicadores();
        ListaDeMultiplicadores listaDeMultiplicadores2 = new ListaDeMultiplicadores();
        ListaDeExclusividades listaDeExclusividades1 = new ListaDeExclusividades(exclusividad);
        ListaDeExclusividades listaDeExclusividades2 = new ListaDeExclusividades();

        BonusDePuntaje.aplicarbonus(puntaje1, listaDeMultiplicadores1, listaDeExclusividades1, puntaje2, listaDeMultiplicadores2, listaDeExclusividades2);

        assertEquals(0, puntaje1.getPuntos());
        assertEquals(4, puntaje2.getPuntos());
    }

    @Test
    public void bonusDePuntajeAplicaUnaExclusividadConDosPuntajesPOsitivos(){
        Puntaje puntaje1 = new Puntaje(4);
        Puntaje puntaje2 = new Puntaje(4);

        Exclusividad exclusividad = new Exclusividad();

        ListaDeMultiplicadores listaDeMultiplicadores1 = new ListaDeMultiplicadores();
        ListaDeMultiplicadores listaDeMultiplicadores2 = new ListaDeMultiplicadores();
        ListaDeExclusividades listaDeExclusividades1 = new ListaDeExclusividades(exclusividad);
        ListaDeExclusividades listaDeExclusividades2 = new ListaDeExclusividades();

        BonusDePuntaje.aplicarbonus(puntaje1, listaDeMultiplicadores1, listaDeExclusividades1, puntaje2, listaDeMultiplicadores2, listaDeExclusividades2);

        assertEquals(0, puntaje1.getPuntos());
        assertEquals(0, puntaje2.getPuntos());
    }
}
