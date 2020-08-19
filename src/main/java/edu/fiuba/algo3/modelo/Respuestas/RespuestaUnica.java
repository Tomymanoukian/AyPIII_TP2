package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public class RespuestaUnica implements Respuesta {

    private Opcion opcionSeleccionada;

    public RespuestaUnica(Opcion unaOpcionSeleccionada) {
        opcionSeleccionada = unaOpcionSeleccionada;
    }

    public Opcion getOpcionSeleccionada(){
        return opcionSeleccionada;
    }

    public boolean esIgualA(Opcion opcion) {
        return opcionSeleccionada.esIgualA(opcion);
    }

    public Puntaje getPuntaje() {
        return opcionSeleccionada.getPuntaje();
    }
}
