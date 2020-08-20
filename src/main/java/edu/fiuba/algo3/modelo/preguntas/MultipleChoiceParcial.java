package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceParcial extends MultipleChoice implements PreguntaSinPenalidad {

    public MultipleChoiceParcial(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    public static MultipleChoiceParcial recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        ListaOpciones opcionesCorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesCorrectas"));
        ListaOpciones opcionesIncorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesIncorrectas"));
        return new MultipleChoiceParcial(consigna, opcionesCorrectas, opcionesIncorrectas);
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        RespuestaEnLista respuestaEnLista = (RespuestaEnLista) respuesta;

        if(respuestaEnLista.contieneAlguna(opcionesIncorrectas)){
            return new Puntaje(0);
        }
        return respuestaEnLista.calcularPuntaje();
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonMultipleChoiceParcial = new JsonObject();
        jsonMultipleChoiceParcial.addProperty("tipoDePregunta", MultipleChoiceParcial.class.getName());
        jsonMultipleChoiceParcial.addProperty("consigna", consigna);
        jsonMultipleChoiceParcial.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceParcial.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceParcial;
    }

    @Override
    public String getTipoDePregunta() {
        return "Multiple Choice con puntaje parcial";
    }

    @Override
    public Exclusividad getExclusividad() {
        return new Exclusividad();
    }
}
