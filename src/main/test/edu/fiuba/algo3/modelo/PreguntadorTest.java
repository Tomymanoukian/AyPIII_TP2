package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntadorTest {
    @Test
    public void testSeCreaConUnListaDePreguntasVacia() {
        Preguntador preguntador = new Preguntador();

        List<Pregunta> preguntas = preguntador.getPreguntas();

        assertEquals(0, preguntas.size());
        assert (preguntas.isEmpty());
    }

    @Test
    public void testEscribeYLeeVerdaderoFalsoClasico() {
        Preguntador preguntador = new Preguntador();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("consigna vof clasico");
        preguntasAEscribir.add(vofClasico);

        assert (preguntador.getPreguntas().isEmpty());

        preguntador.escribirPreguntas(preguntasAEscribir);
        preguntador.leerPreguntas();

        List<Pregunta> preguntas = preguntador.getPreguntas();
        VerdaderoFalsoClasico vofLeido = (VerdaderoFalsoClasico) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(vofClasico.getConsigna(), vofLeido.getConsigna());
        assert (vofClasico.getOpcionCorrecta().esIgualA(vofLeido.getOpcionCorrecta()));
        assert (vofClasico.getOpcionIncorrecta().esIgualA(vofLeido.getOpcionIncorrecta()));

    }

    @Test
    public void testEscribeYLeeVerdaderoFalsoConPenalidad() {
        Preguntador preguntador = new Preguntador();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();

        VerdaderoFalsoConPenalidad vofConPenalidad = VerdaderoFalsoConPenalidad.crearVerdaderoFalsoCorrectoVerdadero("consigna vof con penalidad");
        preguntasAEscribir.add(vofConPenalidad);

        assert (preguntador.getPreguntas().isEmpty());

        preguntador.escribirPreguntas(preguntasAEscribir);
        preguntador.leerPreguntas();

        List<Pregunta> preguntas = preguntador.getPreguntas();
        VerdaderoFalsoConPenalidad vofLeido = (VerdaderoFalsoConPenalidad) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(vofConPenalidad.getConsigna(), vofLeido.getConsigna());
        assert (vofConPenalidad.getOpcionCorrecta().esIgualA(vofLeido.getOpcionCorrecta()));
        assert (vofConPenalidad.getOpcionIncorrecta().esIgualA(vofLeido.getOpcionIncorrecta()));

    }

    @Test
    public void testEscribeYLeeMultipleChoiceClasico() {
        Preguntador preguntador = new Preguntador();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcionCorrecta1 = new Opcion("opcion correcta 1", new Puntaje(1));
        Opcion opcionCorrecta2 = new Opcion("opcion correcta 2", new Puntaje(1));
        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrecta1, opcionCorrecta2));

        Opcion opcionIncorrecta1 = new Opcion("opcion incorrecta 1", new Puntaje(0));
        Opcion opcionIncorrecta2 = new Opcion("opcion incorrecta 2", new Puntaje(0));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrecta1, opcionIncorrecta2));


        MultipleChoiceClasico multipleChoiceClasico = new MultipleChoiceClasico("consigna multiple choice calsico", opcionesCorrectas, opcionesIncorrectas);
        preguntasAEscribir.add(multipleChoiceClasico);

        assert (preguntador.getPreguntas().isEmpty());

        preguntador.escribirPreguntas(preguntasAEscribir);
        preguntador.leerPreguntas();

        List<Pregunta> preguntas = preguntador.getPreguntas();
        MultipleChoiceClasico multipleChoiceLeido = (MultipleChoiceClasico) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(multipleChoiceClasico.getConsigna(), multipleChoiceLeido.getConsigna());
        assert (multipleChoiceClasico.getOpcionesCorrectas().esIgual(multipleChoiceLeido.getOpcionesCorrectas()));
        assert (multipleChoiceClasico.getOpcionesIncorrectas().esIgual(multipleChoiceLeido.getOpcionesIncorrectas()));

    }

    @Test
    public void testEscribeYLeeMultipleChoiceConPenalidad() {
        Preguntador preguntador = new Preguntador();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcionCorrecta1 = new Opcion("opcion correcta 1", new Puntaje(1));
        Opcion opcionCorrecta2 = new Opcion("opcion correcta 2", new Puntaje(1));
        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrecta1, opcionCorrecta2));

        Opcion opcionIncorrecta1 = new Opcion("opcion incorrecta 1", new Puntaje(-1));
        Opcion opcionIncorrecta2 = new Opcion("opcion incorrecta 2", new Puntaje(-1));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrecta1, opcionIncorrecta2));


        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad("consigna multiple choice con penalidad", opcionesCorrectas, opcionesIncorrectas);
        preguntasAEscribir.add(multipleChoiceConPenalidad);

        assert (preguntador.getPreguntas().isEmpty());

        preguntador.escribirPreguntas(preguntasAEscribir);
        preguntador.leerPreguntas();

        List<Pregunta> preguntas = preguntador.getPreguntas();
        MultipleChoiceConPenalidad multipleChoiceLeido = (MultipleChoiceConPenalidad) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(multipleChoiceConPenalidad.getConsigna(), multipleChoiceLeido.getConsigna());
        assert (multipleChoiceConPenalidad.getOpcionesCorrectas().esIgual(multipleChoiceLeido.getOpcionesCorrectas()));
        assert (multipleChoiceConPenalidad.getOpcionesIncorrectas().esIgual(multipleChoiceLeido.getOpcionesIncorrectas()));

    }

    @Test
    public void testEscribeYLeeMultipleChoiceParcial() {
        Preguntador preguntador = new Preguntador();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcionCorrecta1 = new Opcion("opcion correcta 1", new Puntaje(1));
        Opcion opcionCorrecta2 = new Opcion("opcion correcta 2", new Puntaje(1));
        ListaOpciones opcionesCorrectas = new ListaOpciones(Arrays.asList(opcionCorrecta1, opcionCorrecta2));

        Opcion opcionIncorrecta1 = new Opcion("opcion incorrecta 1", new Puntaje(0));
        Opcion opcionIncorrecta2 = new Opcion("opcion incorrecta 2", new Puntaje(0));
        ListaOpciones opcionesIncorrectas = new ListaOpciones(Arrays.asList(opcionIncorrecta1, opcionIncorrecta2));


        MultipleChoiceParcial multipleChoiceParcial = new MultipleChoiceParcial("consigna multiple choice parcial", opcionesCorrectas, opcionesIncorrectas);
        preguntasAEscribir.add(multipleChoiceParcial);

        assert (preguntador.getPreguntas().isEmpty());

        preguntador.escribirPreguntas(preguntasAEscribir);
        preguntador.leerPreguntas();

        List<Pregunta> preguntas = preguntador.getPreguntas();
        MultipleChoiceParcial multipleChoiceLeido = (MultipleChoiceParcial) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(multipleChoiceParcial.getConsigna(), multipleChoiceLeido.getConsigna());
        assert (multipleChoiceParcial.getOpcionesCorrectas().esIgual(multipleChoiceLeido.getOpcionesCorrectas()));
        assert (multipleChoiceParcial.getOpcionesIncorrectas().esIgual(multipleChoiceLeido.getOpcionesIncorrectas()));

    }

    @Test
    public void testEscribeYLeeOrderdChoice() {
        Preguntador preguntador = new Preguntador();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();


        Opcion opcion1 = new Opcion("opcion 1", new Puntaje(0));
        Opcion opcion2 = new Opcion("opcion 2", new Puntaje(0));
        Opcion opcion3 = new Opcion("opcion 3", new Puntaje(0));
        Opcion opcion4 = new Opcion("opcion 4", new Puntaje(0));
        ListaOpciones opcionesOrdenadas = new ListaOpciones(Arrays.asList(opcion1, opcion2, opcion3, opcion4));


        OrderedChoice orderedChoiceParcial = new OrderedChoice("consigna ordered choice", opcionesOrdenadas);
        preguntasAEscribir.add(orderedChoiceParcial);

        assert (preguntador.getPreguntas().isEmpty());

        preguntador.escribirPreguntas(preguntasAEscribir);
        preguntador.leerPreguntas();

        List<Pregunta> preguntas = preguntador.getPreguntas();
        OrderedChoice orderedChoiceLeido = (OrderedChoice) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(orderedChoiceParcial.getConsigna(), orderedChoiceLeido.getConsigna());
        assert (orderedChoiceParcial.getOpcionesOrdenadas().esIgual(orderedChoiceLeido.getOpcionesOrdenadas()));

    }

    @Test
    public void testEscribeYLeeGroupChoice() {
        Preguntador preguntador = new Preguntador();
        List<Pregunta> preguntasAEscribir = new ArrayList<>();

        Opcion opcionGrupoA1 = new Opcion("opcion grupo A 1", new Puntaje(0));
        Opcion opcionGrupoA2 = new Opcion("opcion grupo A 2", new Puntaje(0));
        ListaOpciones opcionesGrupoA = new ListaOpciones(Arrays.asList(opcionGrupoA1,opcionGrupoA2));

        Opcion opcionGrupoB1 = new Opcion("opcion grupo B 1", new Puntaje(0));
        Opcion opcionGrupoB2 = new Opcion("opcion grupo B 2", new Puntaje(0));
        ListaOpciones opcionesGrupoB = new ListaOpciones(Arrays.asList(opcionGrupoB1,opcionGrupoB2));

        GroupChoice groupChoiceParcial = new GroupChoice("consigna ordered choice", opcionesGrupoA,opcionesGrupoB);
        preguntasAEscribir.add(groupChoiceParcial);

        assert (preguntador.getPreguntas().isEmpty());

        preguntador.escribirPreguntas(preguntasAEscribir);
        preguntador.leerPreguntas();

        List<Pregunta> preguntas = preguntador.getPreguntas();
        GroupChoice groupChoiceLeido = (GroupChoice) preguntas.get(0);

        assertEquals(1, preguntas.size());
        assertEquals(groupChoiceParcial.getConsigna(), groupChoiceLeido.getConsigna());
        assert (groupChoiceParcial.getOpcionesGrupoA().esIgual(groupChoiceLeido.getOpcionesGrupoA()));
        assert (groupChoiceParcial.getOpcionesGrupoB().esIgual(groupChoiceLeido.getOpcionesGrupoB()));

    }
}