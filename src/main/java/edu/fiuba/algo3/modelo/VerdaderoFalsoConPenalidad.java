package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

public class VerdaderoFalsoConPenalidad extends VerdaderoFalso {

    private VerdaderoFalsoConPenalidad(String unaConsigna, Opcion unaOpcionCorrecta, Opcion unaOpcionIncorrecta) {

        consigna = unaConsigna;
        opcionCorrecta = unaOpcionCorrecta;
        opcionIncorrecta = unaOpcionIncorrecta;
    }
    public static VerdaderoFalsoConPenalidad recuperar(JsonObject jsonPregunta) {
        String consigna = jsonPregunta.get("consigna").getAsString();
        Opcion opcionCorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionCorrecta"));
        Opcion opcionIncorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionIncorrecta"));
        return new VerdaderoFalsoConPenalidad(consigna, opcionCorrecta, opcionIncorrecta);
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoVerdadero(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(-1));
        return new VerdaderoFalsoConPenalidad(unaConsigna, opcionVerdadera, opcionFalsa);
    }

    public static VerdaderoFalsoConPenalidad crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(-1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(1));
        return new VerdaderoFalsoConPenalidad(unaConsigna, opcionFalsa, opcionVerdadera);
    }

    @Override
    public Boolean aceptaMultiplicador() {return true;}

    @Override
    public Boolean aceptaExclusividad() {return false;}

    @Override
    public JsonObject guardar() {
        JsonObject jsonVoFConPenalidad = new JsonObject();
        jsonVoFConPenalidad.addProperty("tipoDePregunta", VerdaderoFalsoConPenalidad.class.getName());
        jsonVoFConPenalidad.addProperty("consigna", consigna);
        jsonVoFConPenalidad.add("opcionCorrecta", opcionCorrecta.guardar());
        jsonVoFConPenalidad.add("opcionIncorrecta", opcionIncorrecta.guardar());
        return jsonVoFConPenalidad;
    }
}
