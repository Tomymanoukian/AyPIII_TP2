package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

public class RespuestaTest {
    @Test
    public void testCreoDosRespuestasIguales(){
        Respuesta respuesta1 = new Respuesta("unaRespuesta");
        Respuesta respuesta2 = new Respuesta("unaRespuesta");

        assert(respuesta1.esIgualA(respuesta2));
    }

    @Test
    public void testCreoDosRespuestasDistintas(){
        Respuesta respuesta1 = new Respuesta("unaRespuesta");
        Respuesta respuesta2 = new Respuesta("otraRespuesta");

        assert(!respuesta1.esIgualA(respuesta2));
    }


}
