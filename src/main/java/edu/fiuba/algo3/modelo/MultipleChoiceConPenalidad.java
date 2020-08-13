package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceConPenalidad extends Pregunta {
    private final ListaOpciones opcionesCorrectas;
    private final ListaOpciones opcionesIncorrectas;

    public MultipleChoiceConPenalidad(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    public static MultipleChoiceConPenalidad recuperar(JsonObject jsonPregunta) {
        String consigna = jsonPregunta.get("consigna").getAsString();
        ListaOpciones opcionesCorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesCorrectas"));
        ListaOpciones opcionesIncorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesIncorrectas"));
        return new MultipleChoiceConPenalidad(consigna, opcionesCorrectas, opcionesIncorrectas);
    }


    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {
        return respuesta.calcularPuntaje();
    }

    public ListaOpciones getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public ListaOpciones getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }

    @Override
    public Boolean aceptaMultiplicador() {
        return true;
    }

    @Override
    public Boolean aceptaExclusividad() {
        return false;
    }

    @Override
    public JsonObject guardar() {
        JsonObject jsonMultipleChoiceConPenalidad = new JsonObject();
        jsonMultipleChoiceConPenalidad.addProperty("tipoDePregunta",MultipleChoiceConPenalidad.class.getName());
        jsonMultipleChoiceConPenalidad.addProperty("consigna", consigna);
        jsonMultipleChoiceConPenalidad.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceConPenalidad.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceConPenalidad;
    }
}

