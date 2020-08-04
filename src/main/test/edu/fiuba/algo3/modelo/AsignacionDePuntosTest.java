package edu.fiuba.algo3.modelo;

//import javafx.css.converter.LagregarerConverter;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AsignacionDePuntosTest {

    @Before
    public void setUp() {


    }

    @Test
    public void testVerdaderoFalsoClasicoJugador1AsertaYJugador2FallaSumandoCorrectamenteLosPuntajes() {
        String consigna = "El Sol es azul";
        VerdaderoFalsoClasico preguntaVerderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso(consigna);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaUnica respuestaDelJugador1 = new RespuestaUnica(preguntaVerderoFalsoClasico.getOpcionCorrecta());
        RespuestaUnica respuestaDelJugador2 = new RespuestaUnica(preguntaVerderoFalsoClasico.getOpcionIncorrecta());

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);

        kahoot.evaluarRespuestas(preguntaVerderoFalsoClasico);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testVerdaderoFalsoConPenalidadJugador1AsertaYJugador2FallaSumandoleCorrectamenteLosPuntajes() {
        String consigna = "El Sol es azul";
        VerdaderoFalsoConPenalidad preguntaVerderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso(consigna);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaUnica respuestaDelJugador1 = new RespuestaUnica(preguntaVerderoFalsoConPenalidad.getOpcionCorrecta());
        RespuestaUnica respuestaDelJugador2 = new RespuestaUnica(preguntaVerderoFalsoConPenalidad.getOpcionIncorrecta());

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);

        kahoot.evaluarRespuestas(preguntaVerderoFalsoConPenalidad);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(-1, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceParcialJugadorAciertanTodasLasRespuestasCorrectasSumandolesCorrectamenteLosPuntosDeLasRespuestasCorrectas() {
        String consigna = "Indicar cuales de los siguientes con planetas:";


        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);

        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte,opcionCorrectaJupiter));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionInorrectaAzul,opcionIncorrectaAmarillo));
        ListaOpciones opcionesSeleccionadas = new ListaOpciones(opcionesCorrectas);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);


        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(3, kahoot.getPuntajeJugador1());
        assertEquals(3, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceParcialJugadoresAciertanTodasLasOpcionesCorrectasYUnaIncorrectaSumandolesCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionIncorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrectaAzul,opcionIncorrectaAmarillo));
        ListaOpciones opcionesSeleccionadas = new ListaOpciones();
        opcionesSeleccionadas.agregarTodo(opcionesCorrectas);
        opcionesSeleccionadas.agregar(opcionIncorrectaAzul);

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);


        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceParcialJugadoresAciertanAlgunasCorrectasYNingunaIncorrectaSumandolesCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);

        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte,opcionCorrectaJupiter));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionInorrectaAzul,opcionIncorrectaAmarillo));
        ListaOpciones opcionesSeleccionadas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte));

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);


        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(2, kahoot.getPuntajeJugador1());
        assertEquals(2, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceParcialJugadoresNoAciertaNingunaCorrectasSumandolesCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);

        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte,opcionCorrectaJupiter));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionInorrectaAzul,opcionIncorrectaAmarillo));
        ListaOpciones opcionesSeleccionadas = new ListaOpciones(Arrays.asList(opcionIncorrectaAmarillo));

        MultipleChoiceParcial preguntaMultipleChoiceParcial = new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);


        kahoot.evaluarRespuestas(preguntaMultipleChoiceParcial);

        assertEquals(0, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceClasicoJugadorAciertaTodasLasOpcionesCorrectasSumandoleUnPunto() {
        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte,opcionCorrectaJupiter));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionInorrectaAzul,opcionIncorrectaAmarillo));
        ListaOpciones opcionesSeleccionadas = new ListaOpciones(opcionesCorrectas);

        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);


        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(1, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceClasicoJugadoresAciertanTodasLasRespuestasCorrectasYUnaIncorrectaSumandolesCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte,opcionCorrectaJupiter));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionInorrectaAzul,opcionIncorrectaAmarillo));
        ListaOpciones opcionesSeleccionadas = new ListaOpciones();
        opcionesSeleccionadas.agregarTodo(opcionesCorrectas);
        opcionesSeleccionadas.agregar(opcionInorrectaAzul);

        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);


        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceClasicoJugadoesrNoAciertanNingunaRespuestasCorrectasSumandolesCeroPuntos() {
        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", 0);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", 0);


        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrectaTierra,opcionCorrectaMarte,opcionCorrectaJupiter));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionInorrectaAzul,opcionIncorrectaAmarillo));
        ListaOpciones opcionesSeleccionadas = new ListaOpciones(opcionesIncorrectas);

        MultipleChoiceClasico preguntaMultipleChoiceClasico = new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        RespuestaEnLista respuestaDelJugador1 = new RespuestaEnLista(opcionesSeleccionadas);
        RespuestaEnLista respuestaDelJugador2 = new RespuestaEnLista(opcionesSeleccionadas);

        kahoot.setRespuestaJugador1(respuestaDelJugador1);
        kahoot.setRespuestaJugador2(respuestaDelJugador2);


        kahoot.evaluarRespuestas(preguntaMultipleChoiceClasico);

        assertEquals(0, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1AciertaCuatroOpcionesYJugador2AciertaCuatroOpcionesSumandolesCorrectamenteCuatroPuntos() {

        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionCorrectaSaturno = new Opcion("Saturno", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", -1);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", -1);

        List<Opcion> opcionesCorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        List<Opcion> opcionesIncorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        ListaOpciones opcionesCorrectas = new ListaOpciones(opcionesCorrectasList);
        ListaOpciones opcionesIncorrectas = new ListaOpciones(opcionesIncorrectasList);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista (new ListaOpciones(opcionesCorrectas));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista (new ListaOpciones(opcionesCorrectas));

        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(4, kahoot.getPuntajeJugador1());
        assertEquals(4, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1EligeTresOpcionesCorrectasYUnaIncorrectaYJugador2EligeDosOpcionesCorrectasYDosIncorrectaAsignandolesCorrectamenteLosPuntos() {

        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionCorrectaSaturno = new Opcion("Saturno", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", -1);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", -1);

        List<Opcion> opcionesCorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        List<Opcion> opcionesIncorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        ListaOpciones opcionesCorrectas = new ListaOpciones(opcionesCorrectasList);
        ListaOpciones opcionesIncorrectas = new ListaOpciones(opcionesIncorrectasList);

        List<Opcion> respuestasJugador1List = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionCorrectaJupiter, opcionInorrectaAzul));
        List<Opcion> respuestasJugador2List = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionCorrectaMarte, opcionIncorrectaAmarillo, opcionInorrectaAzul));

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista (new ListaOpciones (respuestasJugador1List));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista (new ListaOpciones (respuestasJugador2List));

        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(2, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testMultipleChoiceConPenalidadJugador1EligeUnaOpcionYDosIncorrectasYJugador2EligeCeroOpcionesCorrectasYDosIncorrectaAsignandolesCorrectamenteLosPuntos() {

        String consigna = "Indicar cuales de los siguientes con planetas:";

        Opcion opcionCorrectaTierra = new Opcion("Tierra", 1);
        Opcion opcionCorrectaMarte = new Opcion("Marte", 1);
        Opcion opcionCorrectaJupiter = new Opcion("Jupiter", 1);
        Opcion opcionCorrectaSaturno = new Opcion("Saturno", 1);
        Opcion opcionInorrectaAzul = new Opcion("Azul", -1);
        Opcion opcionIncorrectaAmarillo = new Opcion("Amarillo", -1);


        List<Opcion> opcionesCorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaMarte, opcionCorrectaJupiter, opcionCorrectaSaturno));
        List<Opcion> opcionesIncorrectasList = new ArrayList<>(Arrays.asList(opcionCorrectaJupiter, opcionCorrectaSaturno));
        ListaOpciones opcionesCorrectas = new ListaOpciones(opcionesCorrectasList);
        ListaOpciones opcionesIncorrectas = new ListaOpciones(opcionesIncorrectasList);

        List<Opcion> opcionesJugador1List = new ArrayList<>(Arrays.asList(opcionCorrectaTierra, opcionIncorrectaAmarillo, opcionInorrectaAzul));
        List<Opcion> opcionesJugador2List = new ArrayList<>(Arrays.asList(opcionIncorrectaAmarillo, opcionInorrectaAzul));

        RespuestaEnLista opcionesJugador1 = new RespuestaEnLista (new ListaOpciones (opcionesJugador1List));
        RespuestaEnLista opcionesJugador2 = new RespuestaEnLista (new ListaOpciones (opcionesJugador2List));


        MultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(opcionesJugador1);
        kahoot.setRespuestaJugador2(opcionesJugador2);

        kahoot.evaluarRespuestas(preguntaMultipleChoiceConPenalidad);

        assertEquals(-1, kahoot.getPuntajeJugador1());
        assertEquals(-2, kahoot.getPuntajeJugador2());
    }
}

