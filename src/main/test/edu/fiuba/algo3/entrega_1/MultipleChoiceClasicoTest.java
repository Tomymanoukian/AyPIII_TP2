package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ListaRespuestas;
import edu.fiuba.algo3.modelo.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultipleChoiceClasicoTest {
    @Test
    public void testCrearMultipleChoiceClasico() {

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Respuesta respuestaCorrecta1 = new Respuesta("Amarillo");
        Respuesta respuestaCorrecta2 = new Respuesta("Azul");
        Respuesta respuestaIncorrecta1 = new Respuesta("Tractor");

        respuestasCorrectas.agregar(respuestaCorrecta1);
        respuestasCorrectas.agregar(respuestaCorrecta2);
        respuestasIncorrectas.agregar(respuestaIncorrecta1);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        assertEquals("Indicar cuáles de las siguientes opciones son colores", multipleChoiceClasico.getConsigna());
        assert (multipleChoiceClasico.getRespuestasCorrectas().contieneLoMismo(respuestasCorrectas));
        assert (multipleChoiceClasico.getRespuestasIncorrectas().contieneLoMismo(respuestasIncorrectas));
    }

    @Test
    public void testCalculaPuntajeParaTodasRespuestasCorrectas() {

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Respuesta respuestaCorrecta1 = new Respuesta("Amarillo");
        Respuesta respuestaCorrecta2 = new Respuesta("Azul");
        Respuesta respuestaIncorrecta1 = new Respuesta("Tractor");

        respuestasCorrectas.agregar(respuestaCorrecta1);
        respuestasCorrectas.agregar(respuestaCorrecta2);
        respuestasIncorrectas.agregar(respuestaIncorrecta1);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();
        respuestasElegidas.agregar(respuestaCorrecta1);
        respuestasElegidas.agregar(respuestaCorrecta2);

        assertEquals(1, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas));
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConUnaIncorrecta() {

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Respuesta respuestaCorrecta = new Respuesta("Amarillo");
        Respuesta respuestaIncorrecta = new Respuesta("Tractor");

        respuestasCorrectas.agregar(respuestaCorrecta);
        respuestasIncorrectas.agregar(respuestaIncorrecta);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();

        respuestasElegidas.agregar(respuestaIncorrecta);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas));
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConUnaCorrectaYUnaIncorrecta() {

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Respuesta respuestaCorrecta1 = new Respuesta("Amarillo");
        Respuesta respuestaCorrecta2 = new Respuesta("Azul");
        Respuesta respuestaIncorrecta = new Respuesta("Tractor");

        respuestasCorrectas.agregar(respuestaCorrecta1);
        respuestasCorrectas.agregar(respuestaCorrecta2);
        respuestasIncorrectas.agregar(respuestaIncorrecta);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();

        respuestasElegidas.agregar(respuestaCorrecta1);
        respuestasElegidas.agregar(respuestaIncorrecta);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas));
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConAlgunasCorrectas() {

        ListaRespuestas respuestasCorrectas = new ListaRespuestas();
        ListaRespuestas respuestasIncorrectas = new ListaRespuestas();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Respuesta respuestaCorrecta1 = new Respuesta("Amarillo");
        Respuesta respuestaCorrecta2 = new Respuesta("Azul");
        Respuesta respuestaCorrecta3 = new Respuesta("Verde");
        Respuesta respuestaIncorrecta = new Respuesta("Tractor");

        respuestasCorrectas.agregar(respuestaCorrecta1);
        respuestasCorrectas.agregar(respuestaCorrecta2);
        respuestasCorrectas.agregar(respuestaCorrecta3);
        respuestasIncorrectas.agregar(respuestaIncorrecta);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaRespuestas respuestasElegidas = new ListaRespuestas();

        respuestasElegidas.agregar(respuestaCorrecta1);
        respuestasElegidas.agregar(respuestaCorrecta2);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas));
    }
}