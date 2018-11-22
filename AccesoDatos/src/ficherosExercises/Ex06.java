package ficherosExercises;

import java.io.*;

public class Ex06 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        File fichero = new File(ruta, "hola.txt");
        File f1 = new File(ruta,"1.txt");
        File f2 = new File(ruta,"2.txt");
        File f3 = new File(ruta,"3.txt");
        FileReader reader;
        FileWriter writer;
        FileWriter writer1;
        FileWriter writer2;
        char[] c = new char[15];
        int i=0;
        try {
            fichero.createNewFile();
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            reader = new FileReader(fichero);
            writer = new FileWriter(f1);
            writer1 = new FileWriter(f2);
            writer2 = new FileWriter(f3);
            while ((i = reader.read(c)) != -1){
                if (i == 15) {
                    writer.write(c, 0, 5);
                    writer1.write(c, 5, 5);
                    writer2.write(c, 10, 5);
                }else if (i >= 10 && i < 15) {
                    writer.write(c, 0, 5);
                    writer1.write(c, 5, 5);
                    writer2.write(c, 10, i - 10);
                } else if (i < 10 && i >= 5) {
                    writer.write(c, 0, 5);
                    writer1.write(c, 5, i - 5);
                } else if (i < 5) {
                    writer.write(c, 0, i);
                }
        }
            writer.append(".");
            writer1.append(".");
            writer2.append(".");

            writer.close();
            writer1.close();
            writer2.close();
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
