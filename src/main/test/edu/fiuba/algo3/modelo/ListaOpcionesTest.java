package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

public class ListaOpcionesTest {

    @Test
    public void testAgregoUnaRespuestaCorrectamente(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion = new Opcion("Una gran respuesta");
        listaOpciones.agregar(opcion);

        assertEquals(opcion, listaOpciones.obtener(0));
    }

    @Test
    public void testAgregoTodosLosElementosDeUnaListaAOtra(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        Opcion opcion3 = new Opcion("Respuesta3");
        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);
        listaOpciones.agregar(opcion3);

        ListaOpciones otraListaOpciones = new ListaOpciones();
        otraListaOpciones.agregarTodo(listaOpciones);

        assert(otraListaOpciones.contieneTodo(listaOpciones));
    }

    @Test
    public void testCompruebaQueUnaListaContieneTodosLosElementosDeOtraLista(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);

        ListaOpciones otraListaOpciones = new ListaOpciones();
        otraListaOpciones.agregar(opcion1);
        otraListaOpciones.agregar(opcion2);

        assert(otraListaOpciones.contieneTodo(listaOpciones));
    }
    public void testCompruebaQueUnaListaNoContieneTodosLosElementosDeOtraLista(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);

        ListaOpciones otraListaOpciones = new ListaOpciones();
        otraListaOpciones.agregar(opcion1);

        assert(!otraListaOpciones.contieneTodo(listaOpciones));
    }

    @Test
    public void testObtieneCorrectamenteUnElementoDeLaLista(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);

        assertEquals(opcion1, listaOpciones.obtener(0));
        assertEquals(opcion2, listaOpciones.obtener(1));
    }

    @Test
    public void testObtieneLaListaDeRespuestasCorrectamente(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);

        List<Opcion> listDeOpcions = new ArrayList<>();
        listDeOpcions.add(opcion1);
        listDeOpcions.add(opcion2);

        assertEquals(listDeOpcions, listaOpciones.obtenerLista());
    }

    @Test
    public void testObtieneCantidadDeCoincidenciasCorrectamenteDevolviendo2(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        Opcion opcion3 = new Opcion("Respuesta3");
        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);
        listaOpciones.agregar(opcion3);

        ListaOpciones otraListaOpciones = new ListaOpciones();
        otraListaOpciones.agregar(opcion1);
        otraListaOpciones.agregar(opcion2);

        assertEquals(2, listaOpciones.obtenerCoincidencias(otraListaOpciones));
    }

    @Test
    public void testObtieneCeroCantidadDeCoincidenciasEntreDosListas(){
        ListaOpciones listaOpciones = new ListaOpciones();
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        listaOpciones.agregar(opcion1);
        listaOpciones.agregar(opcion2);

        ListaOpciones otraListaOpciones = new ListaOpciones();
        Opcion opcion3 = new Opcion("Respuesta3");
        Opcion opcion4 = new Opcion("Respuesta4");
        otraListaOpciones.agregar(opcion3);
        otraListaOpciones.agregar(opcion4);

        assertEquals(0, listaOpciones.obtenerCoincidencias(otraListaOpciones));
    }

    @Test
    public void listaDeRespuestasSeCreaConUnArrayListDeRespuestas(){
        Opcion opcion1 = new Opcion("respuesta1");
        Opcion opcion2 = new Opcion("respuesta2");
        Opcion opcion3 = new Opcion("respuesta3");

        List<Opcion> arrayList = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3));

        ListaOpciones lista = new ListaOpciones(arrayList);

        assertEquals(arrayList, lista.obtenerLista());
    }

    @Test
    public void testContieneLoMismoFuncionaCorrectamente(){
        Opcion opcion1 = new Opcion("respuesta1");
        Opcion opcion2 = new Opcion("respuesta2");
        Opcion opcion3 = new Opcion("respuesta3");
        Opcion opcion4 = new Opcion("respuesta4");

        List<Opcion> arrayListTresOpcions = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3));
        List<Opcion> arrayListCuatroOpcions = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4));

        ListaOpciones listaConTresRespuestas = new ListaOpciones(arrayListTresOpcions);
        ListaOpciones listaConCuatroRespuestas = new ListaOpciones(arrayListCuatroOpcions);
        ListaOpciones otralistaConCuatroRespuestas = new ListaOpciones(arrayListCuatroOpcions);

        assertTrue(listaConCuatroRespuestas.contieneLoMismo(otralistaConCuatroRespuestas));
        assertFalse(listaConTresRespuestas.contieneLoMismo(listaConCuatroRespuestas));
        assertFalse(listaConCuatroRespuestas.contieneLoMismo(listaConTresRespuestas));
    }

    @Test
    public void testEsIgualFuncionaCorrectamente(){
        Opcion opcion1 = new Opcion("respuesta1");
        Opcion opcion2 = new Opcion("respuesta2");
        Opcion opcion3 = new Opcion("respuesta3");
        Opcion opcion4 = new Opcion("respuesta4");

        Opcion opcion1bis = new Opcion("respuesta1");
        Opcion opcion2bis = new Opcion("respuesta2");
        Opcion opcion3bis = new Opcion("respuesta3");
        Opcion opcion4bis = new Opcion("respuesta4");

        List<Opcion> arrayListTresOpciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3));
        List<Opcion> arrayListCuatroOpciones = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion3, opcion4));
        List<Opcion> arrayListCuatroOpcionesDesordenadas = new ArrayList<>(Arrays.asList(opcion1, opcion2, opcion4, opcion3));

        ListaOpciones listaConTresOpciones = new ListaOpciones(arrayListTresOpciones);
        ListaOpciones listaConCuatroOpciones = new ListaOpciones(arrayListCuatroOpciones);
        ListaOpciones otralistaConCuatroOpciones = new ListaOpciones(arrayListCuatroOpciones);
        ListaOpciones listaConCuatroOpcionesDesordenadas = new ListaOpciones(arrayListCuatroOpcionesDesordenadas);

        assertTrue(listaConCuatroOpciones.esIgual(otralistaConCuatroOpciones));
        assertFalse(listaConTresOpciones.esIgual(listaConCuatroOpciones));
        assertFalse(listaConCuatroOpciones.esIgual(listaConTresOpciones));
        assertFalse(listaConCuatroOpciones.esIgual(listaConCuatroOpcionesDesordenadas));
    }
}
