package ficherosExercises;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilidades.Teclado.leerString;

public class Ex16 {
    public static void main(String[] args) throws IOException {
        File json = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\ficheroJson.json");
        FileReader reader = null;
        String nombre;
        try {
            reader = new FileReader(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Introduce nombre a encontrar");
        nombre = leerString();

    }
}
