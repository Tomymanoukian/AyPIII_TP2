package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Bonus.Multiplicador;
import edu.fiuba.algo3.modelo.ListaOpciones;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceConPenalidad extends MultipleChoice implements PreguntaConPenalidad {

    public MultipleChoiceConPenalidad(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) > 5) {
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

        RespuestaEnLista respuestaEnLista = (RespuestaEnLista) respuesta;

        return respuestaEnLista.calcularPuntaje();
    }

    @Override
    public Boolean aceptaMultiplicador() {return true;}

    @Override
    public Boolean aceptaExclusividad() {return false;}

    @Override
    public JsonObject guardar() {

        JsonObject jsonMultipleChoiceConPenalidad = new JsonObject();
        jsonMultipleChoiceConPenalidad.addProperty("tipoDePregunta",MultipleChoiceConPenalidad.class.getName());
        jsonMultipleChoiceConPenalidad.addProperty("consigna", consigna);
        jsonMultipleChoiceConPenalidad.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceConPenalidad.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceConPenalidad;
    }

    @Override
    public Multiplicador getMultiplicador() {
        return new Multiplicador();
    }
}
