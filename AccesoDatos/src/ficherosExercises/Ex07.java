package ficherosExercises;

import java.io.*;

import static utilidades.Teclado.leerBoolean;
import static utilidades.Teclado.leerString;

public class Ex07 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        String encriptacion;
        File fichero = new File(ruta, "hola.txt");
        File ficheroEncript = new File(ruta, "a.txt");
        File ficheroDesencr = new File(ruta, "b.txt");
        BufferedReader reader;
        BufferedWriter writer;
        int i;
        int j = 0;
        boolean elegir;
        elegir = leerBoolean("Elige opción", "Encriptar", "Desencriptar");

        System.out.println("Introduce palabra de encriptación: ");
        encriptacion = leerString();

        if (elegir) {
            try {
                fichero.createNewFile();
                ficheroEncript.createNewFile();
                reader = new BufferedReader(new FileReader(fichero));
                writer = new BufferedWriter(new FileWriter(ficheroEncript));
                while ((i = reader.read()) != -1) {
                    if (j >= encriptacion.length()) {
                        j = 0;
                    }
                    writer.write(i + encriptacion.charAt(j));
                    j++;
                }
                reader.close();
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            try {
                fichero.createNewFile();
                ficheroEncript.createNewFile();
                ficheroDesencr.createNewFile();
                reader = new BufferedReader(new FileReader(ficheroEncript));
                writer = new BufferedWriter(new FileWriter(ficheroDesencr));
                while ((i = reader.read()) != -1) {
                    if (j >= encriptacion.length()) {
                        j = 0;
                    }
                    writer.write(i - encriptacion.charAt(j));
                    j++;
                }
                reader.close();
                writer.close();
                System.out.println("Archivo desencriptado");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
