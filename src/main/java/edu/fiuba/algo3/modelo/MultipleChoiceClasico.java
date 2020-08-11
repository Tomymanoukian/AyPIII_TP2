package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeOpcionesInvalidaException;

public class MultipleChoiceClasico extends Pregunta {
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

    @Override
    public Puntaje evaluarRespuestaPara(Respuesta respuesta) {

        return(this.calcularPuntajePara(respuesta));
    }

    @Override
    public Boolean aceptaMultiplicador() {return false;}

    @Override
    public Boolean aceptaExclusividad() {return true;}
}
