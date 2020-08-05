package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorSinNombreException;

public class Multiplicador {

    private int factorDeMultiplicacion;

    public Multiplicador () {

        factorDeMultiplicacion = 0;
    }

    public Multiplicador (int unNumero) {

        factorDeMultiplicacion = unNumero;
    }

    public void setFactorDeMultiplicacion (int unNumero) {

        factorDeMultiplicacion = unNumero;
    }

    public int getFactorDeMultiplicacion () {

        return factorDeMultiplicacion;
    }
}
