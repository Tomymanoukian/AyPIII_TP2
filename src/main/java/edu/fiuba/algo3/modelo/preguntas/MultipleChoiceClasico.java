package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceClasico extends MultipleChoice implements PreguntaSinPenalidad{

    public MultipleChoiceClasico(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeOpciones() + unasOpcionesIncorrectas.cantidadDeOpciones()) > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    public static MultipleChoiceClasico recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        ListaOpciones opcionesCorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesCorrectas"));
        ListaOpciones opcionesIncorrectas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesIncorrectas"));
        return new MultipleChoiceClasico(consigna, opcionesCorrectas, opcionesIncorrectas);
    }

    public String getConsigna() {
        return super.getConsigna();
    }

    public Puntaje calcularPuntajePara(Respuesta respuesta) {

        RespuestaEnLista respuestaEnLista = (RespuestaEnLista) respuesta;
        Puntaje puntaje = new Puntaje(0);

        if (respuestaEnLista.contieneLoMismo(opcionesCorrectas))
            puntaje.establecerPuntos(1);

        return puntaje;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        return(this.calcularPuntajePara(respuesta));
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonMultipleChoiceClasico = new JsonObject();
        jsonMultipleChoiceClasico.addProperty("tipoDePregunta", MultipleChoiceClasico.class.getName());
        jsonMultipleChoiceClasico.addProperty("consigna", consigna);
        jsonMultipleChoiceClasico.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceClasico.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceClasico;
    }

    @Override
    public String getTipoDePregunta() {
        return "Multiple Choice clásico";
    }

    @Override
    public Exclusividad getExclusividad() {
        return new Exclusividad();
    }
}
