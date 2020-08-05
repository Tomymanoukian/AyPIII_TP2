package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaDeExclusividadesTest {

    @Test
    public void listeDeExclusividadesSeCreaConUnaExclusividad(){
        Exclusividad exclusividad = new Exclusividad();

        List<Exclusividad> arrayListExclusividad = new ArrayList<>(Arrays.asList(exclusividad));

        ListaDeExclusividades listaDeExclusividades = new ListaDeExclusividades(exclusividad);

        assertEquals(arrayListExclusividad, listaDeExclusividades.getExclusividades());
    }

    @Test
    public void listeDeExclusividadesSeCreaConUnArrayListDeExclusividadesCorrectamente(){
        Exclusividad ex1 = new Exclusividad();
        Exclusividad ex2 = new Exclusividad();
        Exclusividad ex3 = new Exclusividad();

        List<Exclusividad> arrayListExclusividades = new ArrayList<>(Arrays.asList(ex1, ex2, ex3));

        ListaDeExclusividades listaDeExclusividades = new ListaDeExclusividades(arrayListExclusividades);

        assertEquals(arrayListExclusividades, listaDeExclusividades.getExclusividades());
    }

    @Test
    public void agregarExclusividadesFuncionaCorrectamente(){
        Exclusividad ex1 = new Exclusividad();
        Exclusividad ex2 = new Exclusividad();
        Exclusividad ex3 = new Exclusividad();

        List<Exclusividad> arrayListExclusividades = new ArrayList<>(Arrays.asList(ex1, ex2, ex3));

        ListaDeExclusividades listaDeExclusividades = new ListaDeExclusividades();

        listaDeExclusividades.agregarExclusividad(ex1);
        listaDeExclusividades.agregarExclusividad(ex2);
        listaDeExclusividades.agregarExclusividad(ex3);

        assertEquals(arrayListExclusividades, listaDeExclusividades.getExclusividades());
    }

    @Test
    public void AplicarExclusividadesFuncionaCorrectamenteConTresMultiplicadores(){
        Puntaje puntaje1 = new Puntaje(2);
        Puntaje puntaje2 = new Puntaje(0);

        Exclusividad exclusividad = new Exclusividad();

        ListaDeExclusividades listaDeExclusividades = new ListaDeExclusividades(exclusividad);
        listaDeExclusividades.aplicarExclusividades(puntaje1, puntaje2);

        assertEquals(4, puntaje1.getPuntos());
        assertEquals(0, puntaje2.getPuntos());
    }

    @Test
    public void AplicarMultiplicadoresFuncionaCorrectamenteSinMultiplicadores(){
        Puntaje puntaje = new Puntaje(2);

        ListaDeMultiplicadores listaDeMultiplicadores = new ListaDeMultiplicadores();
        listaDeMultiplicadores.aplicarMultiplicadores(puntaje);

        assertEquals(2, puntaje.getPuntos());
    }
}
