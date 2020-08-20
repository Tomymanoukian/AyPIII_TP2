package edu.fiuba.algo3.modelo.Bonus;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.excepciones.JugadorSinNombreException;

public class Multiplicador {

    private int factorDeMultiplicacion;

    public Multiplicador (int unFactorDeMultiplicacion) {

        factorDeMultiplicacion = unFactorDeMultiplicacion;
    }

    public void aplicarMultiplicador(Puntaje unPuntaje) {

        unPuntaje.multiplicarPuntos(factorDeMultiplicacion);
    }
}
