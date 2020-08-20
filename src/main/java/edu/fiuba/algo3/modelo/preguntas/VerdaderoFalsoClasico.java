package edu.fiuba.algo3.modelo.preguntas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.bonus.Exclusividad;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;

public class VerdaderoFalsoClasico extends VerdaderoFalso implements PreguntaSinPenalidad {

    public static VerdaderoFalsoClasico recuperar(JsonObject jsonPregunta) {

        String consigna = jsonPregunta.get("consigna").getAsString();
        Opcion opcionCorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionCorrecta"));
        Opcion opcionIncorrecta = Opcion.recuperar(jsonPregunta.getAsJsonObject("opcionIncorrecta"));
        return new VerdaderoFalsoClasico(consigna, opcionCorrecta, opcionIncorrecta);
    }

    private VerdaderoFalsoClasico(String unaConsigna, Opcion unaOpcionCorrecta, Opcion unaOpcionIncorrecta) {

        consigna = unaConsigna;
        opcionCorrecta = unaOpcionCorrecta;
        opcionIncorrecta = unaOpcionIncorrecta;
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectaVerdadero(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(0));
        return new VerdaderoFalsoClasico(unaConsigna, opcionVerdadera, opcionFalsa);
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(0));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(1));
        return new VerdaderoFalsoClasico(unaConsigna, opcionFalsa, opcionVerdadera);
    }

    @Override
    public JsonObject guardar() {

        JsonObject jsonVoFClasico = new JsonObject();
        jsonVoFClasico.addProperty("tipoDePregunta",VerdaderoFalsoClasico.class.getName());
        jsonVoFClasico.addProperty("consigna",consigna);
        jsonVoFClasico.add("opcionCorrecta",opcionCorrecta.guardar());
        jsonVoFClasico.add("opcionIncorrecta",opcionIncorrecta.guardar());
        return jsonVoFClasico;
    }

    @Override
    public String getTipoDePregunta() {
        return "Verdadero/Falso clásico";
    }

    @Override
    public Exclusividad getExclusividad() {
        return new Exclusividad();
    }
}
