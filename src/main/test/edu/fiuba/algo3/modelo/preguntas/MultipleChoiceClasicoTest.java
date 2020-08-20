package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MultipleChoiceClasicoTest {

    private ListaOpciones opcionesCorrectas;
    private ListaOpciones opcionesIncorrectas;
    private String consigna;

    private Opcion opcionCorrecta1;
    private Opcion opcionCorrecta2;
    private Opcion opcionIncorrecta1;

    private ListaOpciones opcionesElegidas;
    

    @BeforeEach
    public void setUp() {
      consigna = "Indicar cuáles de las siguientes opciones son colores";

      opcionCorrecta1 = new Opcion("Amarillo");
      opcionCorrecta2 = new Opcion("Azul");
      opcionIncorrecta1 = new Opcion("Tractor");
      
      opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrecta1, opcionCorrecta2));
      opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrecta1));
        
      opcionesElegidas = new ListaOpciones();

    }
    @Test
    public void testMultipleChoiceClasicoLanzaExcepcionSiSeLeIngresan6Opciones(){
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");
        Opcion opcionCorrecta2 = new Opcion("Azul");
        Opcion opcionCorrecta3 = new Opcion("Verde");
        Opcion opcionCorrecta4 = new Opcion("Rojo");
        Opcion opcionIncorrecta1 = new Opcion("Tractor");
        Opcion opcionIncorrecta2 = new Opcion("Auto");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasCorrectas.agregar(opcionCorrecta3);
        respuestasCorrectas.agregar(opcionCorrecta4);
        respuestasIncorrectas.agregar(opcionIncorrecta1);
        respuestasIncorrectas.agregar(opcionIncorrecta2);

        assertThrows(CantidadDeOpcionesInvalidaException.class, ()-> new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas));
    }
    @Test
    public void testMultipleChoiceClasicoLanzaExcepcionSiSeLeIngresa1Opcion(){
        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "Indicar cuáles de las siguientes opciones son colores";

        Opcion opcionCorrecta1 = new Opcion("Amarillo");

        respuestasCorrectas.agregar(opcionCorrecta1);
        assertThrows(CantidadDeOpcionesInvalidaException.class, ()-> new MultipleChoiceClasico(consigna, respuestasCorrectas, respuestasIncorrectas));
    }


    @Test
    public void testCrearMultipleChoiceClasico() {
        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        assertEquals("Indicar cuáles de las siguientes opciones son colores", multipleChoiceClasico.getConsigna());
        assert (multipleChoiceClasico.getOpcionesCorrectas().contieneLoMismo(opcionesCorrectas));
        assert (multipleChoiceClasico.getOpcionesIncorrectas().contieneLoMismo(opcionesIncorrectas));
    }

    @Test
    public void testCalculaPuntajeParaTodasRespuestasCorrectas() {

        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);
        opcionesElegidas.agregar(opcionCorrecta2);

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesElegidas);

        assertEquals(1, multipleChoiceClasico.calcularPuntajePara(respuesta).getPuntos());
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConUnaIncorrecta() {
        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionIncorrecta1);

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuesta).getPuntos());
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConUnaCorrectaYUnaIncorrecta() {
        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);
        opcionesElegidas.agregar(opcionIncorrecta1);

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuesta).getPuntos());
    }

    @Test
    public void testCalculaPuntajeDeUnaListaDeRespuestasConAlgunasCorrectas() {
        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        opcionesElegidas.agregar(opcionCorrecta1);

        RespuestaEnLista respuesta = new RespuestaEnLista(opcionesElegidas);

        assertEquals(0, multipleChoiceClasico.calcularPuntajePara(respuesta).getPuntos());
    }

    @Test
    public void testSeVerificaQueSePuedaUtilizarExclusividad(){
        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);
        assert(multipleChoiceClasico.getExclusividad().getClass() == Exclusividad.class);
    }
}