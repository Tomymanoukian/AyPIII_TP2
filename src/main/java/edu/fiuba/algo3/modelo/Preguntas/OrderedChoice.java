package edu.fiuba.algo3.modelo.Preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaEnLista;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeOpcionesInvalidaException;
import edu.fiuba.algo3.modelo.opciones.ListaOpciones;

public class OrderedChoice extends Pregunta implements PreguntaSinPenalidad {

    private final ListaOpciones opcionesOrdenadas;

    public OrderedChoice(String unaConsigna, ListaOpciones unaListaDeOpciones) {
        super();
        if (unaListaDeOpciones.cantidadDeOpciones() < 2 || unaListaDeOpciones.cantidadDeOpciones() > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesOrdenadas = unaListaDeOpciones;
    }

    public static OrderedChoice recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        ListaOpciones opcionesOrdenadas = ListaOpciones.recuperar(jsonPregunta.getAsJsonArray("opcionesOrdenadas"));
        return new OrderedChoice(consigna, opcionesOrdenadas);
    }

    public ListaOpciones getOpciones() {
        return opcionesOrdenadas;
    }

    public String getConsigna() {
        return super.getConsigna();
    }

    public Puntaje calcularPuntajePara(Respuesta respuesta) {

        RespuestaEnLista respuestaEnLista = (RespuestaEnLista) respuesta;

        Puntaje puntaje = new Puntaje(0);
        if (respuestaEnLista.esIgual(opcionesOrdenadas)) {
            puntaje.establecerPuntos(1);
        }
        return puntaje;
    }

    public ListaOpciones getOpcionesDesordenadas() {

        ListaOpciones opcionesDesordenadas = new ListaOpciones(opcionesOrdenadas);
        opcionesDesordenadas.desordenar();
        return opcionesDesordenadas;
    }


    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuestaEnLista) {
        return this.calcularPuntajePara(respuestaEnLista);
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonOrderedChoice = new JsonObject();
        jsonOrderedChoice.addProperty("tipoDePregunta", OrderedChoice.class.getName());
        jsonOrderedChoice.addProperty("consigna", consigna);
        jsonOrderedChoice.add("opcionesOrdenadas", opcionesOrdenadas.guardar());
        return jsonOrderedChoice;
    }

    @Override
    public String getTipoDePregunta() {
        return "Ordered choice";
    }

    @Override
    public Exclusividad getExclusividad() {
        return new Exclusividad();
    }
}
