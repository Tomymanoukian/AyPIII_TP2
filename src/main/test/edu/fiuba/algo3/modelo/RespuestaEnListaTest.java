package edu.fiuba.algo3.modelo;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RespuestaEnListaTest {

    @Test
    public void testSeCreaRespuestaEnListaConrrectamente() {
        Opcion opcion1 = new Opcion("una opcion");
        Opcion opcion2 = new Opcion("otra opcion");
        Opcion opcion3 = new Opcion("otra otra opcion");
        ListaOpciones opcionesSeleccionadad = new ListaOpciones(Arrays.asList(opcion1, opcion2, opcion3));
        RespuestaEnLista respuestaEnLista = new RespuestaEnLista(opcionesSeleccionadad);

        assert (respuestaEnLista.getOpcionesSeleccionadas().contieneLoMismo(opcionesSeleccionadad));

    }

    @Test
    public void testSeLePideMasDeUnaOpcionResultandoEnExcepcion() {
        Opcion opcion1 = new Opcion("una opcion");
        Opcion opcion2 = new Opcion("otra opcion");
        Opcion opcion3 = new Opcion("otra otra opcion");
        ListaOpciones opcionesSeleccionadad = new ListaOpciones(Arrays.asList(opcion1, opcion2, opcion3));
        RespuestaEnLista respuestaEnLista = new RespuestaEnLista(opcionesSeleccionadad);


        assertThrows(RespuestaNoValidaException.class, respuestaEnLista::getOpcionSeleccionada);
    }

}
