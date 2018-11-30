package ficherosExercises;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static utilidades.Teclado.leerString;

public class Ex16 {
    public static void main(String[] args) throws IOException {
        File json = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\ficheroJson.json");
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
        pattern = Pattern.compile(".*name.*(" + leerString() + ")\",");
        boolean a = true;

        while ((cadena = reader.readLine()) != null && a) {
            matcher = pattern.matcher(cadena);

            if (matcher.find()) {
                System.out.println(matcher.group(1));
                a = false;
            }
        }
    }
}



