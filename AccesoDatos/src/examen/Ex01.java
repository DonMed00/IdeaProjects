package examen;

import java.io.*;
import java.time.LocalDate;

public class Ex01 {
    public static void main(String[] args) {

        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\examen";
        Alumno alumno[] = new Alumno[4];
        File fichero;
        ObjectOutputStream objectOut;

        alumno[0] = new Alumno("Antonio Serrano", LocalDate.of(2000, 10, 11), 3, 60.89, true);
        alumno[1] = new Alumno("Pepe Santos", LocalDate.of(1999, 1, 9), 6, 70.56, false);
        alumno[2] = new Alumno("Ana Lozano", LocalDate.of(1998, 2, 23), 2, 65.45, true);
        alumno[3] = new Alumno("Pedro Torres", LocalDate.of(1997, 3, 14), 6, 69.47, false);
        fichero = new File(ruta, "ficheroBinario.dat");
        try {
            if (fichero.exists()) {
                objectOut = new MiObjectOutputStream(new FileOutputStream(fichero, true));//Para seguir añadiendo contenido a un fichero existente.
                objectOut.writeObject(alumno[2]);
                objectOut.writeObject(alumno[3]);

            } else {
                fichero.createNewFile();
                objectOut = new ObjectOutputStream(new FileOutputStream(fichero));
                objectOut.writeObject(alumno[0]);
                objectOut.writeObject(alumno[1]);

            }
            objectOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

