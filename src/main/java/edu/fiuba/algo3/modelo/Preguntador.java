package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.excepciones.ErrorDeEscrituraException;
import edu.fiuba.algo3.modelo.excepciones.ErrorDeLecturaException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Preguntador {
    static String FILENAME_RELATIVE_PATH = "preguntas.json";
    private List<Pregunta> preguntasDelJuego;

    public Preguntador() {
        preguntasDelJuego = new ArrayList<>();
    }


    public void leerPreguntas()  {
        try {
            String texto = Files.readString(Path.of(FILENAME_RELATIVE_PATH));

            JsonArray arrayPreguntas = JsonParser.parseString(texto).getAsJsonArray();

            for (JsonElement jsonPregunta : arrayPreguntas) {
                Pregunta pregunta = Pregunta.recuperar(jsonPregunta.getAsJsonObject());
                preguntasDelJuego.add(pregunta);

            }
        } catch (IOException ex) {
            throw new ErrorDeLecturaException();
        }

    }

    public void escribirPreguntas(List<Pregunta> preguntasAEscribir) {
        try {
            Gson gson = new Gson();

            String json = gson.toJson(this.guardar(preguntasAEscribir));

            FileWriter writer = new FileWriter(FILENAME_RELATIVE_PATH);
            writer.write(json);
            writer.close();
        } catch (IOException ex) {
            throw new ErrorDeEscrituraException();
        }


    }

    private JsonArray guardar(List<Pregunta> preguntasAEscribir) {
        JsonArray jsonArrayPreguntas = new JsonArray();
        for (Pregunta pregunta : preguntasAEscribir) {
            jsonArrayPreguntas.add(pregunta.guardar());
        }
        return jsonArrayPreguntas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntasDelJuego;
    }
}
