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
    public void testMultipleChoiceParcialJugadoresAciertanTodasLasRespuestasCorrectasYUnaIncorrectaSumandolesCeroPuntos() {
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



    ////


    @Test
    public void testGroupChoiceJugador1YJugador2AgrupanCorrectamenteLasRespuestasAsignandolesUnPuntoACadaUno() {
        String consigna = "Agrupe en las categorias A y B:";

        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB", 0);

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB)));

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB);


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(1, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testGroupChoiceJugador1AgrupaCorrectamenteLasOpcionesYJugador2AgrupaIncorrectamenteLasOpcionesAsignandolesCorrectamenteLosPuntajes() {
        String consigna = "Agrupe en las categorias A y B:";


        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB", 0);

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB)));

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoA, opcionesGrupoB );
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);

        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testGroupChoiceJugador1YJugador2AgrupanIncorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        String consigna = "Agrupe en las categorias A y B:";


        Opcion opcion1DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion2DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion3DeGrupoA = new Opcion("respuestaGrupoA", 0);
        Opcion opcion1DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion2DeGrupoB = new Opcion("respuestaGrupoB", 0);
        Opcion opcion3DeGrupoB = new Opcion("respuestaGrupoB", 0);

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA, opcion3DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB, opcion3DeGrupoB)));

        GroupChoice preguntaGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        RespuestaDeGrupos respuestasJugador1 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);
        RespuestaDeGrupos respuestasJugador2 = new RespuestaDeGrupos(opcionesGrupoB, opcionesGrupoA);


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(0, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testOrderedChoiceJugador1YJugador2OrdenanCorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        String consigna = "Ordene correctamente las opciones:";


        Opcion primerOpcion = new Opcion("1er Opcion");
        Opcion segundaOpcion = new Opcion("2da Opcion");
        Opcion terceraOpcion = new Opcion("3era Opcion");
        Opcion cuartaOpcion = new Opcion("4ta Opcion");
        Opcion quintaOpcion = new Opcion("5ta Opcion");


        List<Opcion> respuestasOrdenadasCorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion, segundaOpcion, terceraOpcion,cuartaOpcion,quintaOpcion));
        ListaOpciones opcionesOrdenadasCorrectamente = new ListaOpciones(respuestasOrdenadasCorrectamenteList);


        OrderedChoice preguntaGroupChoice = new OrderedChoice(consigna, opcionesOrdenadasCorrectamente);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista (new ListaOpciones(opcionesOrdenadasCorrectamente));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista (new ListaOpciones(opcionesOrdenadasCorrectamente));


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(1, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testOrderedChoiceJugador1YJugador2OrdenanIncorrectamenteLasOpcionesAsignandolesCeroPuntosACadaUno() {
        String consigna = "Ordene correctamente las opciones:";


        Opcion primerOpcion = new Opcion("1er Opcion");
        Opcion segundaOpcion = new Opcion("2da Opcion");
        Opcion terceraOpcion = new Opcion("3era Opcion");
        Opcion cuartaOpcion = new Opcion("4ta Opcion");
        Opcion quintaOpcion = new Opcion("5ta Opcion");


        List<Opcion> respuestasOrdenadasCorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion, segundaOpcion, terceraOpcion,cuartaOpcion,quintaOpcion));
        ListaOpciones opcionesOrdenadasCorrectamente = new ListaOpciones(respuestasOrdenadasCorrectamenteList);
        List<Opcion> respuestasOrdenadasInorrectamenteList = new ArrayList<>(Arrays.asList(primerOpcion,terceraOpcion ,segundaOpcion ,cuartaOpcion,quintaOpcion));
        ListaOpciones opcionesOrdenadasInorrectamente = new ListaOpciones(respuestasOrdenadasInorrectamenteList);


        OrderedChoice preguntaGroupChoice = new OrderedChoice(consigna, opcionesOrdenadasCorrectamente);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasInorrectamente));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista(new ListaOpciones(opcionesOrdenadasInorrectamente));


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaGroupChoice);

        assertEquals(0, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

    @Test
    public void testOrderedChoiceJugador1OrdenaCorrectamenteLasOpcionesYJugador2OrdenaInorrectamenteLasOpcionesAsignandolesCorrectamenteLosPuntajes() {
        String consigna = "Ordene correctamente las opciones:";


        Opcion primerOpcion = new Opcion("1er Opcion");
        Opcion segundaOpcion = new Opcion("2da Opcion");
        Opcion terceraOpcion = new Opcion("3era Opcion");
        Opcion cuartaOpcion = new Opcion("4ta Opcion");
        Opcion quintaOpcion = new Opcion("5ta Opcion");


        ListaOpciones opcionesOrdenadasCorrectamente = new ListaOpciones(new ArrayList<>(Arrays.asList(primerOpcion, segundaOpcion, terceraOpcion,cuartaOpcion,quintaOpcion)));
        ListaOpciones opcionesOrdenadasInorrectamente = new ListaOpciones(new ArrayList<>(Arrays.asList(primerOpcion,terceraOpcion ,segundaOpcion ,cuartaOpcion,quintaOpcion)));


        OrderedChoice preguntaOrderedChoice = new OrderedChoice(consigna, opcionesOrdenadasCorrectamente);

        RespuestaEnLista respuestasJugador1 = new RespuestaEnLista (new ListaOpciones(opcionesOrdenadasCorrectamente));
        RespuestaEnLista respuestasJugador2 = new RespuestaEnLista (new ListaOpciones(opcionesOrdenadasInorrectamente));


        Jugador juan = new Jugador("Juan");
        Jugador maria = new Jugador("Maria");

        Kahoot kahoot = new Kahoot(juan, maria);

        kahoot.setRespuestaJugador1(respuestasJugador1);
        kahoot.setRespuestaJugador2(respuestasJugador2);

        kahoot.evaluarRespuestas(preguntaOrderedChoice);

        assertEquals(1, kahoot.getPuntajeJugador1());
        assertEquals(0, kahoot.getPuntajeJugador2());
    }

}

