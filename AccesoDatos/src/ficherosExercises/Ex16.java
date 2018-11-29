package ficherosExercises;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static utilidades.Teclado.leerString;

public class Ex16 {
    public static void main(String[] args) throws IOException {
        File json = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\ficheroJson.json");
        BufferedReader reader = null;
        Pattern pattern, pattern2;
        Matcher matcher, matcher2;
        String cadena;
        try {
            reader = new BufferedReader(new FileReader(json));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Introduce nombre a encontrar");
        pattern = Pattern.compile(".*(" + leerString() + ").*");
        pattern2 = Pattern.compile(".*(" + "}," + ").*");
        boolean a = false;

        while ((cadena = reader.readLine()) != null) {
            matcher = pattern.matcher(cadena);

            if (matcher.find() || a) {
                System.out.println(cadena.trim());
            }


            matcher2 = pattern.matcher(cadena);
            if (!matcher2.find()) {
                System.out.println(cadena.trim());
            }

        }
    }
}



