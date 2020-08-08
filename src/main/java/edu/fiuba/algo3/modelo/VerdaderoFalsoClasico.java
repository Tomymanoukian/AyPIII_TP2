package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoClasico extends VerdaderoFalso {

    private VerdaderoFalsoClasico(String unaConsigna, Opcion unaOpcionCorrecta, Opcion unaOpcionIncorrecta) {

        consigna = unaConsigna;
        opcionCorrecta = unaOpcionCorrecta;
        opcionIncorrecta = unaOpcionIncorrecta;
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectaVerdadero(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(1));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(0));
        return new VerdaderoFalsoClasico(unaConsigna, opcionVerdadera, opcionFalsa);
    }

    public static VerdaderoFalsoClasico crearVerdaderoFalsoCorrectoFalso(String unaConsigna) {

        Opcion opcionVerdadera = new Opcion("Verdadero", new Puntaje(0));
        Opcion opcionFalsa = new Opcion("Falso", new Puntaje(1));
        return new VerdaderoFalsoClasico(unaConsigna, opcionFalsa, opcionVerdadera);
    }
}
