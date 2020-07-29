package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class ListaRespuestasTest {

    @Test
    public void testAgregoUnaRespuestaCorrectamente(){
        ListaRespuestas listaRespuestas = new ListaRespuestas();
        Respuesta respuesta = new Respuesta("Una gran respuesta");
        listaRespuestas.agregar(respuesta);

        assertEquals(respuesta, listaRespuestas.obtener(0));
    }



}
