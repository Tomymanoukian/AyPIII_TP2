package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.excepciones.EstaPreguntaNoAceptaExclusividadesException;
import edu.fiuba.algo3.modelo.excepciones.EstaPreguntaNoAceptaMultiplicadoresException;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoValidoException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class KahootTest {

    @Test
    public void testSeCreaUnKahootConDosJugadoresConPuntaje0(){

        Jugador pablo = new Jugador("Pablo");
        Jugador matias = new Jugador("Matias");

        Kahoot kahoot = new Kahoot(pablo, matias);

        assertEquals(0,kahoot.getPuntajeJugador1().getPuntos());
        assertEquals(0,kahoot.getPuntajeJugador2().getPuntos());

    }

    @Test
    public void testSeCreaUnKahootConDosJugadoresPidiendoleElPuntajeAlJugador1(){

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        assertEquals(0,kahoot.getPuntajeJugador1().getPuntos());

    }

    @Test
    public void testSeCreaUnKahootConDosJugadoresPidiendoleElPuntajeAlJugador2(){

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        assertEquals(0,kahoot.getPuntajeJugador2().getPuntos());

    }

    @Test
    public void testJugadoresAplicanUnMultiplicadorAUnVerdaderoFalsoClasicoLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        VerdaderoFalsoClasico unVerdaderoFalsoClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");

        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX2(unVerdaderoFalsoClasico, martin));
        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX3(unVerdaderoFalsoClasico, martin));
    }

    @Test
    public void testJugadoresAplicanUnaExclusividadAUnVerdaderoFalsoConPenalidadLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        VerdaderoFalsoConPenalidad unVerdaderoFalsoConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso("bar");

        assertThrows(EstaPreguntaNoAceptaExclusividadesException.class, ()-> kahoot.agregarExclusividad(unVerdaderoFalsoConPenalidad, martin));
        assertThrows(EstaPreguntaNoAceptaExclusividadesException.class, ()-> kahoot.agregarExclusividad(unVerdaderoFalsoConPenalidad, jose));
    }

    @Test
    public void testJugadoresAplicanUnMultiplicadorAUnMultipleChoiceClasicoLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String unaConsigna = "bar";

        Opcion opcionCorrecta1 = new Opcion("1");
        Opcion opcionCorrecta2 = new Opcion("2");
        Opcion opcionIncorrecta3 = new Opcion("3");
        Opcion opcionIncorrecta4 = new Opcion("4");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasIncorrectas.agregar(opcionIncorrecta3);
        respuestasIncorrectas.agregar(opcionIncorrecta4);

        MultipleChoiceClasico unMultipleChoiceClasico = new MultipleChoiceClasico (unaConsigna, respuestasCorrectas, respuestasIncorrectas);

        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX2(unMultipleChoiceClasico, martin));
        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX3(unMultipleChoiceClasico, jose));
    }

    @Test
    public void testJugadoresAplicanUnMultiplicadorAUnMultipleChoiceParcialLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String unaConsigna = "bar";

        Opcion opcionCorrecta1 = new Opcion("1");
        Opcion opcionCorrecta2 = new Opcion("2");
        Opcion opcionIncorrecta3 = new Opcion("3");
        Opcion opcionIncorrecta4 = new Opcion("4");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasIncorrectas.agregar(opcionIncorrecta3);
        respuestasIncorrectas.agregar(opcionIncorrecta4);

        MultipleChoiceParcial unMultipleChoiceParcial = new MultipleChoiceParcial (unaConsigna, respuestasCorrectas, respuestasIncorrectas);

        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX2(unMultipleChoiceParcial, martin));
        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX3(unMultipleChoiceParcial, jose));
    }

    @Test
    public void testJugadoresAplicanExclusividadAUnMultipleChoiceConPenalidadLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        ListaOpciones respuestasCorrectas = new ListaOpciones();
        ListaOpciones respuestasIncorrectas = new ListaOpciones();
        String consigna = "bar";

        Opcion opcionCorrecta1 = new Opcion("1");
        Opcion opcionCorrecta2 = new Opcion("2");
        Opcion opcionIncorrecta3 = new Opcion("3");
        Opcion opcionIncorrecta4 = new Opcion("4");

        respuestasCorrectas.agregar(opcionCorrecta1);
        respuestasCorrectas.agregar(opcionCorrecta2);
        respuestasIncorrectas.agregar(opcionIncorrecta3);
        respuestasIncorrectas.agregar(opcionIncorrecta4);

        MultipleChoiceConPenalidad unMultipleChoiceConPenalidad = new MultipleChoiceConPenalidad (consigna, respuestasCorrectas, respuestasIncorrectas);

        assertThrows(EstaPreguntaNoAceptaExclusividadesException.class, ()-> kahoot.agregarExclusividad(unMultipleChoiceConPenalidad, martin));
        assertThrows(EstaPreguntaNoAceptaExclusividadesException.class, ()-> kahoot.agregarExclusividad(unMultipleChoiceConPenalidad, jose));
    }

    @Test
    public void testJugadoresAplicanUnMultiplicadorAUnOrderedChoiceLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        String consigna = "bar";

        Opcion opcion1ra = new Opcion("1");
        Opcion opcion2da = new Opcion("2");
        Opcion opcion3ra = new Opcion("3");

        ListaOpciones listaDeOpciones = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1ra, opcion2da, opcion3ra)));

        OrderedChoice unOrderedChoice = new OrderedChoice(consigna, listaDeOpciones);

        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX2(unOrderedChoice, martin));
        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX3(unOrderedChoice, jose));
    }

    @Test
    public void testJugadoresAplicanUnMultiplicadorAUnGroupChoiceLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        String consigna = "bar";

        Opcion opcion1DeGrupoA = new Opcion("respuesta1GrupoA");
        Opcion opcion2DeGrupoA = new Opcion("respuesta2GrupoA");
        Opcion opcion1DeGrupoB = new Opcion("respuesta1GrupoB");
        Opcion opcion2DeGrupoB = new Opcion("respuesta2GrupoB");

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));

        GroupChoice unGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);

        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX2(unGroupChoice, martin));
        assertThrows(EstaPreguntaNoAceptaMultiplicadoresException.class, ()-> kahoot.agregarMultiplicadorX3(unGroupChoice, jose));
    }

    @Test
    public void testUtilizarBonusConOtroJugadorLanzaExcepcion() {

        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");
        Jugador otroJugador = new Jugador("otroJugador");

        Kahoot kahoot = new Kahoot(martin, jose);

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("consigna");
        VerdaderoFalsoConPenalidad vofConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoFalso("consigna");

        /*String consigna = "bar";

        Opcion opcion1DeGrupoA = new Opcion("respuesta1GrupoA");
        Opcion opcion2DeGrupoA = new Opcion("respuesta2GrupoA");
        Opcion opcion1DeGrupoB = new Opcion("respuesta1GrupoB");
        Opcion opcion2DeGrupoB = new Opcion("respuesta2GrupoB");

        ListaOpciones opcionesGrupoA = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoA, opcion2DeGrupoA)));
        ListaOpciones opcionesGrupoB = new ListaOpciones(new ArrayList<>(Arrays.asList(opcion1DeGrupoB, opcion2DeGrupoB)));

        GroupChoice unGroupChoice = new GroupChoice(consigna, opcionesGrupoA, opcionesGrupoB);*/

        assertThrows(JugadorNoValidoException.class, ()-> kahoot.agregarMultiplicadorX2(vofConPenalidad, otroJugador));
        assertThrows(JugadorNoValidoException.class, ()-> kahoot.agregarMultiplicadorX3(vofConPenalidad, otroJugador));
        assertThrows(JugadorNoValidoException.class, ()-> kahoot.agregarExclusividad(vofClasico, otroJugador));
    }

    @Test
    public void devuelveCorrectamenteAlJugador1GanadorYAlJugador2Perdedor(){
        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(martin, jose);

        martin.sumarPuntos(new Puntaje(20));
        jose.sumarPuntos(new Puntaje(10));

        assertEquals(martin, kahoot.getJugadorGanador());
        assertEquals(jose, kahoot.getJugadorPerdedor());

    }

    @Test
    public void devuelveCorrectamenteAlJugador2GanadorYAlJugador1Perdedor(){
        Jugador martin = new Jugador("Martin");
        Jugador jose = new Jugador("Jose");

        Kahoot kahoot = new Kahoot(jose, martin);

        martin.sumarPuntos(new Puntaje(20));
        jose.sumarPuntos(new Puntaje(10));

        assertEquals(martin, kahoot.getJugadorGanador());
        assertEquals(jose, kahoot.getJugadorPerdedor());

    }
}