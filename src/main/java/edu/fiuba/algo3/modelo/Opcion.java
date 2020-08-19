package edu.fiuba.algo3.modelo;

import com.google.gson.JsonObject;

public class Opcion {

    private final String opcion;
    private final Puntaje puntaje;

    public Opcion(String unaRespuesta) {

        opcion = unaRespuesta;
        puntaje = new Puntaje();
    }

    public Opcion(String unaRespuesta, Puntaje unPuntaje) {

        opcion = unaRespuesta;
        puntaje = unPuntaje;
    }

    public Opcion (Opcion unaOpcion) {

        opcion = unaOpcion.getOpcion();
        puntaje = unaOpcion.getPuntaje();
    }

    public static Opcion recuperar(JsonObject jsonOpcion) {

        String opcion = jsonOpcion.get("opcion").getAsString();
        Puntaje puntaje = Puntaje.recuperar(jsonOpcion.getAsJsonObject("puntaje"));
        return new Opcion(opcion, puntaje);
    }


    public boolean esIgualA(Opcion unaOpcion) {
        return this.getOpcion().equals(unaOpcion.getOpcion());
    }

    public String getOpcion() {
        return opcion;
    }

    public Puntaje getPuntaje() { return puntaje; }

    public JsonObject guardar() {

        JsonObject jsonOpcion = new JsonObject();
        jsonOpcion.addProperty("opcion", opcion);
        jsonOpcion.add("puntaje", puntaje.guardar());
        return jsonOpcion;
    }

    public boolean tieneLaMisma(String opcionBuscada) {
        return (this.opcion.equals(opcionBuscada));
    }
}
