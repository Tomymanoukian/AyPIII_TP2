package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaOpciones {

    private final List<Opcion> listaOpcions;

    public ListaOpciones() {
        listaOpcions = new ArrayList<>();
    }

    public ListaOpciones(List<Opcion> unaLista) {
        listaOpcions = new ArrayList<>();
        listaOpcions.addAll(unaLista);
    }
    public ListaOpciones(ListaOpciones unaListaDeRespuestas) {
        listaOpcions = new ArrayList<>();
        listaOpcions.addAll(unaListaDeRespuestas.obtenerLista());
    }

    public void limpiar() {
        listaOpcions.clear();
    }

    public void agregar(Opcion opcion) {
        listaOpcions.add(opcion);
    }

    public void agregarTodo(ListaOpciones otraListaOpciones) {
        listaOpcions.addAll(otraListaOpciones.obtenerLista());
    }

    public boolean contieneTodo(ListaOpciones otraLista) {
        return listaOpcions.containsAll(otraLista.obtenerLista());
    }

    public boolean contieneLoMismo(ListaOpciones otraLista) {

        return listaOpcions.size() == otraLista.obtenerLista().size() &&
                listaOpcions.containsAll(otraLista.obtenerLista());
    }

    public Opcion obtener(int posicion) {
        return listaOpcions.get(posicion);
    }

    public List<Opcion> obtenerLista() {
        return listaOpcions;
    }

    public int obtenerCoincidencias(ListaOpciones otraLista) {
        return otraLista.calculoDeCoincidencias(listaOpcions);
    }

    public int calculoDeCoincidencias(List<Opcion> otraLista) {
        int coincidencias = 0;
        Iterator<Opcion> iterador1 = otraLista.iterator();
        Iterator<Opcion> iterador2 = listaOpcions.iterator();

        for (int i = 0; i < otraLista.size(); i++) {
            Opcion otraOpcion = iterador1.next();

            for (int j = 0; j < listaOpcions.size(); j++) {
                Opcion opcion = iterador2.next();
                if (opcion.getOpcion().equals(otraOpcion.getOpcion())) {
                    coincidencias++;
                }
            }
            iterador2 = listaOpcions.iterator();
        }
        return coincidencias;
    }


    public int cantidadDeRespuestas() {
        return listaOpcions.size();
    }

    public Opcion obtenerPrimero() {
        return listaOpcions.get(0);
    }

    public void aplicarPuntajesA(Jugador jugador) {
        listaOpcions.forEach(respuesta -> respuesta.aplicarPuntajeA(jugador));
    }
}
