package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceParcial extends MultipleChoice{
    private final ListaOpciones opcionesCorrectas;
    private final ListaOpciones opcionesIncorrectas;

    public MultipleChoiceParcial(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) > 5) {
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
    public Puntaje evaluarRespuestaPara(Respuesta unaRespuestaEnLista) {
        if(unaRespuestaEnLista.contieneAlguna(opcionesIncorrectas)){
            return new Puntaje(0);
        }
        return unaRespuestaEnLista.calcularPuntaje();
    }

    public ListaOpciones getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public ListaOpciones getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }

    @Override
    public ListaOpciones getTodasLasOpcionesMezcladas() {
        ListaOpciones todasLasOpciones = new ListaOpciones();
        todasLasOpciones.agregarTodo(opcionesCorrectas);
        todasLasOpciones.agregarTodo(opcionesIncorrectas);
        todasLasOpciones.desordenar();

        return todasLasOpciones;
    }

    @Override
    public Boolean aceptaMultiplicador() {return false;}

    @Override
    public Boolean aceptaExclusividad() {return true;}

    @Override
    public JsonObject guardar() {
        JsonObject jsonMultipleChoiceParcial = new JsonObject();
        jsonMultipleChoiceParcial.addProperty("tipoDePregunta", MultipleChoiceParcial.class.getName());
        jsonMultipleChoiceParcial.addProperty("consigna", consigna);
        jsonMultipleChoiceParcial.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceParcial.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceParcial;
    }
}
