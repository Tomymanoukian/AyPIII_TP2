package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Opcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultipleChoiceClasicoTest {
    @Test
    public void testCrearMultipleChoiceClasico() {

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionIncorrecta1 = new Opcion("Tractor");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasIncorrectas.agregar(opcionIncorrecta1);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        assertEquals("Indicar cuáles de las siguientes opciones son colores", multipleChoiceClasico.getConsigna());
        assert (multipleChoiceClasico.getOpcionesCorrectas().contieneLoMismo(respuestasCorrectas));
        assert (multipleChoiceClasico.getOpcionesIncorrectas().contieneLoMismo(respuestasIncorrectas));
    }

    @Test
    public void testCalculaPuntajeParaTodasRespuestasCorrectas() {

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionIncorrecta1 = new Opcion("Tractor");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasIncorrectas.agregar(opcionIncorrecta1);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaOpciones respuestasElegidas = new ListaOpciones();
        respuestasElegidas.agregar(opcionCorrecta1);
        respuestasElegidas.agregar(opcionCorrecta2);

        assertEquals(1, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas).getPuntos());
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConUnaIncorrecta() {

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta = new Opcion("Amarillo");
        Opcion opcionIncorrecta = new Opcion("Tractor");

        respuestasCorrectas.agregar(opcionCorrecta);
        respuestasIncorrectas.agregar(opcionIncorrecta);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaOpciones respuestasElegidas = new ListaOpciones();

        respuestasElegidas.agregar(opcionIncorrecta);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas).getPuntos());
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConUnaCorrectaYUnaIncorrecta() {

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionIncorrecta = new Opcion("Tractor");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasIncorrectas.agregar(opcionIncorrecta);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaOpciones respuestasElegidas = new ListaOpciones();

        respuestasElegidas.agregar(opcionCorrecta1);
        respuestasElegidas.agregar(opcionIncorrecta);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas).getPuntos());
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConAlgunasCorrectas() {

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionCorrecta3 = new Opcion("Verde");
        Opcion opcionIncorrecta = new Opcion("Tractor");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasCorrectas.agregar(opcionCorrecta3);
        respuestasIncorrectas.agregar(opcionIncorrecta);

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas);

        ListaOpciones respuestasElegidas = new ListaOpciones();

        respuestasElegidas.agregar(opcionCorrecta1);
        respuestasElegidas.agregar(opcionCorrecta2);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuestasElegidas).getPuntos());
    }
}