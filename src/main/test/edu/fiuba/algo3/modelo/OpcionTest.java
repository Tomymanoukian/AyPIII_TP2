package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OpcionTest {
    @Test
    public void testCreoDosRespuestasIguales(){
        Opcion opcion1 = new Opcion("unaRespuesta");
        Opcion opcion2 = new Opcion("unaRespuesta");

        assert(opcion1.esIgualA(opcion2));
    }

    @Test
    public void testCreoDosRespuestasDistintas(){
        Opcion opcion1 = new Opcion("unaRespuesta");
        Opcion opcion2 = new Opcion("diferenteRespuesta");

        assert(!opcion1.esIgualA(opcion2));
    }

    @Test
    public void testSeCreaUnaRespuestaConPuntajePositivoAlAplicarselaAlJugadorSumaPuntos(){
        int puntaje = 2;
        Opcion opcion = new Opcion("Cosigna :", puntaje);
        Jugador unJugador = new Jugador("Pablo");

        opcion.aplicarPuntajeA(unJugador);

        assertEquals(unJugador.getPuntos(),puntaje);


    }

}
