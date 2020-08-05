package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ListaDeMultiplicadores;
import edu.fiuba.algo3.modelo.Multiplicador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaDeMultiplicadoresTest {

    @Test
    public void listeDeMultiplicadoresSeCreaConUnMultiplicador(){
        Multiplicador multiplicador = new Multiplicador();

        List<Multiplicador> arrayListMultiplicador = new ArrayList<>(Arrays.asList(multiplicador));

        ListaDeMultiplicadores listaDeMultiplicadores = new ListaDeMultiplicadores(multiplicador);

        assertEquals(arrayListMultiplicador, listaDeMultiplicadores.getMultiplicadores());
    }

    @Test
    public void listeDeMultiplicadoresSeCreaConUnArrayListDeMultilpicadoresCorrectamente(){
        Multiplicador m1 = new Multiplicador(2);
        Multiplicador m2 = new Multiplicador(3);
        Multiplicador m3 = new Multiplicador(4);
        List<Multiplicador> arrayListMultiplicadores = new ArrayList<>(Arrays.asList(m1, m2, m3));

        ListaDeMultiplicadores listaDeMultiplicadores = new ListaDeMultiplicadores(arrayListMultiplicadores);

        assertEquals(arrayListMultiplicadores, listaDeMultiplicadores.getMultiplicadores());
    }

    @Test
    public void agregarMultiplicadorFuncionaCorrectamente(){
        Multiplicador m1 = new Multiplicador(2);
        Multiplicador m2 = new Multiplicador(3);
        Multiplicador m3 = new Multiplicador(4);
        List<Multiplicador> arrayListMultiplicadores = new ArrayList<>(Arrays.asList(m1, m2, m3));

        ListaDeMultiplicadores listaDeMultiplicadores = new ListaDeMultiplicadores();

        listaDeMultiplicadores.agregarMultiplicador(m1);
        listaDeMultiplicadores.agregarMultiplicador(m2);
        listaDeMultiplicadores.agregarMultiplicador(m3);

        assertEquals(arrayListMultiplicadores, listaDeMultiplicadores.getMultiplicadores());
    }

    @Test
    public void AplicarMultiplicadoresFuncionaCorrectamenteConTresMultiplicadores(){
        Puntaje puntaje = new Puntaje(1);

        Multiplicador m1 = new Multiplicador(2);
        Multiplicador m2 = new Multiplicador(3);
        Multiplicador m3 = new Multiplicador(4);
        List<Multiplicador> arrayListMultiplicadores = new ArrayList<>(Arrays.asList(m1, m2, m3));

        ListaDeMultiplicadores listaDeMultiplicadores = new ListaDeMultiplicadores(arrayListMultiplicadores);
        listaDeMultiplicadores.aplicarMultiplicadores(puntaje);

        assertEquals(24, puntaje.getPuntos());
    }

    @Test
    public void AplicarMultiplicadoresFuncionaCorrectamenteSinMultiplicadores(){
        Puntaje puntaje = new Puntaje(2);

        ListaDeMultiplicadores listaDeMultiplicadores = new ListaDeMultiplicadores();
        listaDeMultiplicadores.aplicarMultiplicadores(puntaje);

        assertEquals(2, puntaje.getPuntos());
    }
}
