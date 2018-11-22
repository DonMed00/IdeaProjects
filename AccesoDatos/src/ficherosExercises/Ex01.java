package ficherosExercises;

import java.io.File;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args){
        File fichero;
        String nombreFichero;
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.printf("Introduce el nombre del fichero: ");
        nombreFichero = entradaEscaner.nextLine ();
        fichero=new File(".",nombreFichero);
        if(fichero.exists()) {
            System.out.printf("Nombre del fichero: %s\n", fichero.getName());
            System.out.printf("Ruta absoluta: %s\n", fichero.getAbsolutePath());
            System.out.printf("Ruta relativa: %s\n", fichero.getPath());
            System.out.printf("Se ejecuta: %s\n", fichero.canExecute() ? "si" : "no");
            System.out.printf("Tamaño: %d", fichero.length());
        }else{
            System.out.printf("No existe");
        }

    }
}
