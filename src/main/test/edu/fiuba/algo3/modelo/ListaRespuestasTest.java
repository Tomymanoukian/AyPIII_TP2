package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaRespuestasTest {

    @Test
    public void testAgregoUnaRespuestaCorrectamente(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta = new Respuesta("Una gran respuesta");
        listaRespuestas.agregar(respuesta);

        assertEquals(respuesta, listaRespuestas.obtener(0));
    }

    public void testAgregoTodosLosElementosDeUnaListaAOtra(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta1 = new Respuesta("Respuesta1");
        Respuesta respuesta2 = new Respuesta("Respuesta2");
        Respuesta respuesta3 = new Respuesta("Respuesta3");
        listaRespuestas.agregar(respuesta1);
        listaRespuestas.agregar(respuesta2);
        listaRespuestas.agregar(respuesta3);

        ListaRespuestas otraListaRespuestas = new ListaRespuestas();

        assert(otraListaRespuestas.contieneTodo(listaRespuestas));
    }

    public void testCompruebaQueUnaListaContieneTodosLosElementosDeOtraLista(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta1 = new Respuesta("Respuesta1");
        Respuesta respuesta2 = new Respuesta("Respuesta2");
        listaRespuestas.agregar(respuesta1);
        listaRespuestas.agregar(respuesta2);

        ListaRespuestas otraListaRespuestas = new ListaRespuestas();
        otraListaRespuestas.agregar(respuesta1);
        otraListaRespuestas.agregar(respuesta2);

        assert(otraListaRespuestas.contieneTodo(listaRespuestas));
    }
    public void testCompruebaQueUnaListaNoContieneTodosLosElementosDeOtraLista(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta1 = new Respuesta("Respuesta1");
        Respuesta respuesta2 = new Respuesta("Respuesta2");
        listaRespuestas.agregar(respuesta1);
        listaRespuestas.agregar(respuesta2);

        ListaRespuestas otraListaRespuestas = new ListaRespuestas();
        otraListaRespuestas.agregar(respuesta1);

        assert(!otraListaRespuestas.contieneTodo(listaRespuestas));
    }

    public void testObtieneCorrectamenteUnElementoDeLaLista(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta1 = new Respuesta("Respuesta1");
        Respuesta respuesta2 = new Respuesta("Respuesta2");
        listaRespuestas.agregar(respuesta1);
        listaRespuestas.agregar(respuesta2);

        assertEquals(respuesta1, listaRespuestas.obtener(0));
        assertEquals(respuesta2, listaRespuestas.obtener(1));
    }

    public void testObtieneLaListaDeRespuestasCorrectamente(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta1 = new Respuesta("Respuesta1");
        Respuesta respuesta2 = new Respuesta("Respuesta2");
        listaRespuestas.agregar(respuesta1);
        listaRespuestas.agregar(respuesta2);

        List<Respuesta> listDeRespuestas = new ArrayList<>();
        listDeRespuestas.add(respuesta1);
        listDeRespuestas.add(respuesta2);

        assertEquals(listDeRespuestas, listaRespuestas.obtenerLista());
    }

    public void testObtieneCantidadDeCoincidenciasCorrectamenteDevolviendo2(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta1 = new Respuesta("Respuesta1");
        Respuesta respuesta2 = new Respuesta("Respuesta2");
        Respuesta respuesta3 = new Respuesta("Respuesta3");
        listaRespuestas.agregar(respuesta1);
        listaRespuestas.agregar(respuesta2);
        listaRespuestas.agregar(respuesta3);

        ListaRespuestas otraListaRespuestas = new ListaRespuestas();
        otraListaRespuestas.agregar(respuesta1);
        otraListaRespuestas.agregar(respuesta2);

        assertEquals(2, listaRespuestas.obtenerCoincidencias(otraListaRespuestas));
    }

    public void testObtieneCeroCantidadDeCoincidenciasEntreDosListas(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta1 = new Respuesta("Respuesta1");
        Respuesta respuesta2 = new Respuesta("Respuesta2");
        listaRespuestas.agregar(respuesta1);
        listaRespuestas.agregar(respuesta2);

        ListaRespuestas otraListaRespuestas = new ListaRespuestas();
        Respuesta respuesta3 = new Respuesta("Respuesta3");
        Respuesta respuesta4 = new Respuesta("Respuesta4");
        otraListaRespuestas.agregar(respuesta3);
        otraListaRespuestas.agregar(respuesta4);

        assertEquals(0, listaRespuestas.obtenerCoincidencias(otraListaRespuestas));
    }

}
