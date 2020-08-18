package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListaOpciones {

    private final List<Opcion> listaOpciones;

    public ListaOpciones() {
        listaOpciones = new ArrayList<>();
    }

    public ListaOpciones(List<Opcion> unaLista) {

        listaOpciones = new ArrayList<>();
        listaOpciones.addAll(unaLista);
    }

    public ListaOpciones(ListaOpciones unaListaDeRespuestas) {

        listaOpciones = new ArrayList<>();
        listaOpciones.addAll(unaListaDeRespuestas.obtenerLista());
    }

    public static ListaOpciones recuperar(JsonArray jsonOpciones) {

        ListaOpciones opciones = new ListaOpciones();

        for (JsonElement jsonOpcion : jsonOpciones) {
            Opcion opcion = Opcion.recuperar(jsonOpcion.getAsJsonObject());
            opciones.agregar(opcion);
        }

        return opciones;
    }

    public void agregar(Opcion opcion) {
        listaOpciones.add(opcion);
    }

    public void agregarTodo(ListaOpciones otraListaOpciones) {
        listaOpciones.addAll(otraListaOpciones.obtenerLista());
    }

    public boolean contieneTodo(ListaOpciones otraLista) {
        return (this.obtenerCoincidencias(otraLista) == otraLista.cantidadDeOpciones());
    }

    public boolean contieneLoMismo(ListaOpciones otraLista) {
        return (this.cantidadDeOpciones() == otraLista.cantidadDeOpciones() &&
                this.obtenerCoincidencias(otraLista) == otraLista.cantidadDeOpciones());
    }

    public Opcion obtener(int posicion) {
        return listaOpciones.get(posicion);
    }

    public List<Opcion> obtenerLista() {
        return listaOpciones;
    }

    public int obtenerCoincidencias(ListaOpciones otraLista) {
        return otraLista.calculoDeCoincidencias(listaOpciones);
    }

    public int calculoDeCoincidencias(List<Opcion> otraLista) {

        int coincidencias = 0;
        Iterator<Opcion> iterador1 = otraLista.iterator();
        Iterator<Opcion> iterador2 = listaOpciones.iterator();

        for (int i = 0; i < otraLista.size(); i++) {
            Opcion otraOpcion = iterador1.next();

            for (int j = 0; j < listaOpciones.size(); j++) {

                Opcion opcion = iterador2.next();

                if (opcion.getOpcion().equals(otraOpcion.getOpcion())) {
                    coincidencias++;
                }
            }
            iterador2 = listaOpciones.iterator();
        }
        return coincidencias;
    }

    public int cantidadDeOpciones() {
        return listaOpciones.size();
    }

    public boolean esIgual(ListaOpciones otraLista) {
        Iterator<Opcion> iterador1 = listaOpciones.iterator();
        Iterator<Opcion> iterador2 = otraLista.obtenerLista().iterator();

        if (this.cantidadDeOpciones() != otraLista.cantidadDeOpciones()) {
            return false;
        }

        for (int i = 0; i < otraLista.cantidadDeOpciones(); i++) {
            Opcion unaOpcion = iterador1.next();
            Opcion otraOpcion = iterador2.next();

            if (!unaOpcion.esIgualA(otraOpcion)) {
                return false;
            }
        }
        return true;
    }

    public Puntaje calcularPuntaje() {

        Puntaje puntaje = new Puntaje();

        for (Opcion opcion : listaOpciones) {
            puntaje.sumarPuntos(opcion.getPuntaje());
        }
        return puntaje;
    }

    public void desordenar() {
        Collections.shuffle(listaOpciones);
    }

    public void eliminar(String opcionAEliminar) {

        Opcion opcion = this.obtenerOpcionDe(opcionAEliminar);

        if (opcion != null) {
            listaOpciones.remove(opcion);
        }
    }

    public Opcion obtenerOpcionDe(String opcionBuscada){

        Iterator<Opcion> iterador = listaOpciones.iterator();
        boolean contiene = false;
        Opcion opcion = null;

        while( iterador.hasNext() && !contiene ) {

            Opcion opcionIterador = iterador.next();

            if (opcionIterador.tieneLaMisma(opcionBuscada)) {
                contiene = true;
                opcion = opcionIterador;
            }
        }
        return opcion;
    }

    public boolean contieneAlguna(ListaOpciones opciones) {
        return (this.obtenerCoincidencias(opciones) != 0);
    }

    public void establecer(int posicion, Opcion unaOpcion) {
        listaOpciones.set(posicion, unaOpcion);
    }

    public JsonArray guardar() {

        JsonArray jsonArrayDeOpciones = new JsonArray();

        for (Opcion opcion : listaOpciones) {
            jsonArrayDeOpciones.add(opcion.guardar());
        }

        return jsonArrayDeOpciones;
    }

    public void quitarOpcion(Opcion opcion) {
        listaOpciones.remove(opcion);
    }
}
