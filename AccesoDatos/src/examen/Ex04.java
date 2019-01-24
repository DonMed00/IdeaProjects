package examen;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilidades.Teclado.leerString;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        File json = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\examen\\ficheroJson.json");
        BufferedReader reader = null;
        Pattern pattern;
        Matcher matcher;
        String cadena;

        try {
            reader = new BufferedReader(new FileReader(json));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Introduce nombre a encontrar");
        pattern = Pattern.compile(".*nombre.*(" + leerString() + ")\",");

        while ((cadena = reader.readLine()) != null) {
            matcher = pattern.matcher(cadena);
            if (matcher.find()) {
                System.out.println(matcher.group(1));
                for (int i = 0; i < 8; i++) {

                    cadena = reader.readLine();
                    System.out.println(cadena);
                }
            }
        }

    }
}
