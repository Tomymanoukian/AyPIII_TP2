package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaUnicaTest {
    @Test
    public void testSeCreaRespuestaUnicaConrrectamente() {
        Opcion opcion = new Opcion("una opcion");
        RespuestaUnica respuestaUnica = new RespuestaUnica(opcion);

        assertEquals(opcion, respuestaUnica.getOpcionSeleccionada());
    }

    @Test
    public void testSeLePideMasDeUnaOpcionResultandoEnExcepcion() {
        Opcion opcion = new Opcion("una opcion");
        RespuestaUnica respuestaUnica = new RespuestaUnica(opcion);

        assertThrows(RespuestaNoValidaException.class, respuestaUnica::getOpcionesSeleccionadas);
    }

}