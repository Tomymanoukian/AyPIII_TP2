package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Bonus.Exclusividad;
import edu.fiuba.algo3.modelo.Bonus.Multiplicador;
import edu.fiuba.algo3.modelo.excepciones.ErrorSinBonusesException;
import edu.fiuba.algo3.modelo.excepciones.JugadorSinNombreException;

import java.util.Stack;

public class Jugador {

    private Puntaje puntaje;
    private String nombre;
    private Stack <Multiplicador> multiplicadoresX2;
    private Stack <Multiplicador> multiplicadoresX3;
    private Stack <Exclusividad> exclusividades;

    public Jugador(String unNombre) {

        if (unNombre.equals("")) {
            throw new JugadorSinNombreException();
        }
        nombre = unNombre;
        puntaje = new Puntaje();

        multiplicadoresX2 = new Stack<>();
        multiplicadoresX2.push(new Multiplicador(2));

        multiplicadoresX3 = new Stack<>();
        multiplicadoresX3.push(new Multiplicador(3));

        exclusividades = new Stack <>();
        exclusividades.push(new Exclusividad());
        exclusividades.push(new Exclusividad());
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void sumarPuntos(Puntaje unPuntaje) {
        puntaje.sumarPuntos(unPuntaje);
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    public Stack<Multiplicador> getMultiplicadoresX2() { return multiplicadoresX2;}

    public Stack<Multiplicador> getMultiplicadoresX3() { return multiplicadoresX3;}

    public Stack<Exclusividad> getExclusividades() { return exclusividades;}

    public Exclusividad utilizarExclusividad() {

        if (exclusividades.empty()) {
            throw new ErrorSinBonusesException();
        }

        return exclusividades.pop();
    }

    public Multiplicador utilizarMultiplicadorX2 () {

        if (multiplicadoresX2.empty()) {
            throw new ErrorSinBonusesException();
        }

        return multiplicadoresX2.pop();
    }

    public Multiplicador utilizarMultiplicadorX3() {

        if (multiplicadoresX3.empty()) {
            throw new ErrorSinBonusesException();
        }

        return multiplicadoresX3.pop();
    }
}
