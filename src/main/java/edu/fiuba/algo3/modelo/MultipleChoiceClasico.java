package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceClasico extends  MultipleChoice{
    private final ListaOpciones opcionesCorrectas;
    private final ListaOpciones opcionesIncorrectas;

    public MultipleChoiceClasico(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) > 5) {
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

    public ListaOpciones getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public ListaOpciones getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }

    public Puntaje calcularPuntajePara(Respuesta respuesta) {
        Puntaje puntaje = new Puntaje(0);
        if (respuesta.contieneLoMismo(opcionesCorrectas)) {
            puntaje.establecerPuntos(1);
        }
        return puntaje;
    }
    public ListaOpciones getTodasLasOpcionesMezcladas(){
        ListaOpciones todasLasOpciones = new ListaOpciones();
        todasLasOpciones.agregarTodo(opcionesCorrectas);
        todasLasOpciones.agregarTodo(opcionesIncorrectas);
        todasLasOpciones.desordenar();

        return todasLasOpciones;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        return(this.calcularPuntajePara(respuesta));
    }

    @Override
    public Boolean aceptaMultiplicador() {return false;}

    @Override
    public Boolean aceptaExclusividad() {return true;}

    @Override
    public JsonObject guardar() {
        JsonObject jsonMultipleChoiceClasico = new JsonObject();
        jsonMultipleChoiceClasico.addProperty("tipoDePregunta", MultipleChoiceClasico.class.getName());
        jsonMultipleChoiceClasico.addProperty("consigna", consigna);
        jsonMultipleChoiceClasico.add("opcionesCorrectas", opcionesCorrectas.guardar());
        jsonMultipleChoiceClasico.add("opcionesIncorrectas", opcionesIncorrectas.guardar());
        return jsonMultipleChoiceClasico;
    }
}
