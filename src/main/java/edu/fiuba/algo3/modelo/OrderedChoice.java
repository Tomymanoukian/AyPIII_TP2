package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class OrderedChoice extends Pregunta {

    private final ListaOpciones opcionesOrdenadas;

    public OrderedChoice(String unaConsigna, ListaOpciones unaListaDeOpciones) {
        super();
        if (unaListaDeOpciones.cantidadDeRespuestas() < 2 || unaListaDeOpciones.cantidadDeRespuestas() > 5) {
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


    public ListaOpciones getOpcionesOrdenadas() {return opcionesOrdenadas;}

    public String getConsigna() {
        return super.getConsigna();
    }

    public Puntaje calcularPuntajePara(Respuesta respuestaEnLista) {
        Puntaje puntaje = new Puntaje(0);
        if(respuestaEnLista.esIgual(opcionesOrdenadas)){
            puntaje.establecerPuntos(1);
        }
        return puntaje;
    }

    public OrderedChoice desordenarOpciones(){
        opcionesOrdenadas.desordenar();
        return this;
    }


    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuestaEnLista) {
        return this.calcularPuntajePara(respuestaEnLista);
    }

    @Override
    public Boolean aceptaMultiplicador() {return false;}

    @Override
    public Boolean aceptaExclusividad() {return true;}

    @Override
    public JsonObject guardar() {
        JsonObject jsonOrderedChoice = new JsonObject();
        jsonOrderedChoice.addProperty("tipoDePregunta",OrderedChoice.class.getName());
        jsonOrderedChoice.addProperty("consigna", consigna);
        jsonOrderedChoice.add("opcionesOrdenadas", opcionesOrdenadas.guardar());
        return jsonOrderedChoice;
    }
}
