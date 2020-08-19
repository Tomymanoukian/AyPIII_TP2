package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaUnica;
import edu.fiuba.algo3.modelo.excepciones.OpcionNoValidaException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoIndicandoleLaRespuestaCorrectaVerdadera() {
        VerdaderoFalsoClasico vofVerdaderaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("foo");
        Opcion opcionCorrecta = new Opcion("Verdadero");

        assert(vofVerdaderaCorrecta.getOpcionCorrecta().esIgualA(opcionCorrecta));
        Assert.assertEquals("foo", vofVerdaderaCorrecta.getConsigna());
    }

    @Test
    public void testCrearUnaPreguntaVerdaderoYFalsoClasicoLaRespuestaCorrectaFalso() {
        VerdaderoFalsoClasico vofFalsaCorrecta = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectoFalso("bar");
        Opcion opcionCorrecta = new Opcion("Falso");

        assert(vofFalsaCorrecta.getOpcionCorrecta().esIgualA(opcionCorrecta));
        Assert.assertEquals("bar", vofFalsaCorrecta.getConsigna());
    }


    @Test
    public void testVoFClasicoLanzaExcepcionSiSeLaDaUnaRespuestaNoValidaAlEvaluarRespuestas(){
        Opcion opcionInvalida = new Opcion("foo");
        Jugador jugador = new Jugador("Pedro");
        RespuestaUnica respuestaDelJugador = new RespuestaUnica(opcionInvalida);

        VerdaderoFalsoClasico vofClasico = VerdaderoFalsoClasico.crearVerdaderoFalsoCorrectaVerdadero("bar");

        assertThrows(OpcionNoValidaException.class, ()-> vofClasico.evaluarRespuestaPara(respuestaDelJugador));
    }
}
