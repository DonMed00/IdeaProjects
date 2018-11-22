package ficherosExercises;

import java.io.*;

import static utilidades.Teclado.leerBoolean;
import static utilidades.Teclado.leerString;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        File origen;
        File destino;
        File archivo;
        String nombreDestino;
        String nombreOrigen;
        boolean noExisteOrigen = false;
        boolean noExisteDestino = false;
        boolean esDirectorio = false;
        boolean booleano;
        BufferedReader reader;
        BufferedWriter writer;


        do {
            System.out.printf("\nIntroduce el nombre del fichero origen: ");
            nombreOrigen = leerString();
            origen = new File(ruta, nombreOrigen);
            if (!origen.exists()) {
                System.out.printf("\nNo existe el fichero origen");
                noExisteOrigen = true;
            } else {
                noExisteOrigen = false;
            }
        } while (noExisteOrigen);

        do {
            System.out.printf("\nIntroduce el nombre del destino: ");
            nombreDestino= leerString();
            destino = new File(ruta, nombreDestino);
            if (!destino.exists()) {
                System.out.printf("\nNo existe el fichero destino");
                noExisteDestino = true;
            } else {
                noExisteDestino = false;
            }
        } while (noExisteDestino);

        if(destino.isDirectory()){
            esDirectorio = true;
        }
        if(esDirectorio){
            String linea;
            archivo = new File(destino.getAbsolutePath(),nombreDestino);
            archivo.createNewFile();
            reader = new BufferedReader(new FileReader(origen));
            writer = new BufferedWriter(new FileWriter(archivo));
            while((linea = reader.readLine()) != null){
                writer.write(linea);
                writer.newLine();
            }
            reader.close();
            writer.close();
        }else{
            booleano= leerBoolean("Introduce true o false","True","False");
            if(booleano){
                if(destino.exists()){
                    int i;

                    reader = new BufferedReader(new FileReader(origen));
                    writer = new BufferedWriter(new FileWriter(destino));
                    while((i = reader.read()) !=-1){
                        writer.write(i);
                    }
                    reader.close();
                    writer.close();

                }
            }else{
                String cadena;
                reader = new BufferedReader(new FileReader(origen));
                writer = new BufferedWriter(new FileWriter(destino));

                while((cadena = reader.readLine()) != null){
                    writer.write(cadena);
                    writer.newLine();
                }
                reader.close();
                writer.close();
            }

        }
    }
}