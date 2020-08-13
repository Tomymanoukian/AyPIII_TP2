package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

public abstract class Pregunta {
    protected String consigna;

    public static Pregunta recuperar(JsonObject jsonPregunta) {
        //Dependiendo del tipo de pregunta lee el json de formas diferentes
        String tipoDePregunta =  jsonPregunta.get("tipoDePregunta").getAsString();

        if(VerdaderoFalsoClasico.class.getName().equals(tipoDePregunta)){
            return  VerdaderoFalsoClasico.recuperar(jsonPregunta);
        }
        if(VerdaderoFalsoConPenalidad.class.getName().equals(tipoDePregunta)){
            return  VerdaderoFalsoConPenalidad.recuperar(jsonPregunta);
        }
        if(MultipleChoiceClasico.class.getName().equals(tipoDePregunta)){
            return  MultipleChoiceClasico.recuperar(jsonPregunta);
        }
        if(MultipleChoiceParcial.class.getName().equals(tipoDePregunta)){
            return  MultipleChoiceParcial.recuperar(jsonPregunta);
        }
        if(MultipleChoiceConPenalidad.class.getName().equals(tipoDePregunta)){
            return  MultipleChoiceConPenalidad.recuperar(jsonPregunta);
        }
        if(OrderedChoice.class.getName().equals(tipoDePregunta)){
            return  OrderedChoice.recuperar(jsonPregunta);
        }
        if(GroupChoice.class.getName().equals(tipoDePregunta)){
            return  GroupChoice.recuperar(jsonPregunta);
        }
        return null;
    }

    public String getConsigna() {
        return  consigna;
    }

    public abstract Puntaje evaluarRespuestaPara(Respuesta respuesta);

    public abstract Boolean aceptaMultiplicador();

    public abstract Boolean aceptaExclusividad();

    public abstract JsonObject guardar();
}