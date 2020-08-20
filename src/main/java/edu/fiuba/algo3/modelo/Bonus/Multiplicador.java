package edu.fiuba.algo3.modelo.Bonus;

import edu.fiuba.algo3.modelo.Puntaje;

public class Multiplicador {

    private int factorDeMultiplicacion;

    public Multiplicador () {

        factorDeMultiplicacion = 1;
    }

    public Multiplicador (int unFactorDeMultiplicacion) {

        factorDeMultiplicacion = unFactorDeMultiplicacion;
    }

    public void aplicarMultiplicador(Puntaje unPuntaje) {

        unPuntaje.multiplicarPuntos(factorDeMultiplicacion);
    }
}
