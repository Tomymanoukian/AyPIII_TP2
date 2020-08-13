package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceConPenalidad extends MultipleChoice{
    private final ListaOpciones opcionesCorrectas;
    private final ListaOpciones opcionesIncorrectas;

    public MultipleChoiceConPenalidad(String unaConsigna, ListaOpciones unasOpcionesCorrectas, ListaOpciones unasOpcionesIncorrectas) {
        super();
        if ((unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) < 2 ||
                (unasOpcionesCorrectas.cantidadDeRespuestas() + unasOpcionesIncorrectas.cantidadDeRespuestas()) > 5) {
            throw new CantidadDeOpcionesInvalidaException();
        }
        consigna = unaConsigna;
        opcionesCorrectas = unasOpcionesCorrectas;
        opcionesIncorrectas = unasOpcionesIncorrectas;
    }

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {
        return respuesta.calcularPuntaje();
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
    public Boolean aceptaMultiplicador() {return true;}

    @Override
    public Boolean aceptaExclusividad() {return false;}
}

