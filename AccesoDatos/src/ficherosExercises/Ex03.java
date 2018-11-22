package ficherosExercises;

import utilidades.Teclado;

import java.io.File;
import java.util.Arrays;

import static utilidades.Teclado.leerString;

public class Ex03 {
    public static void main(String [] args){
        File directorio;
        File aux;
        String nombre;
        String [] ficheros;
        String [] ficheros2;
        nombre = leerString();
        directorio = new File(nombre);
        ficheros = directorio.list();

        if(directorio.exists()){
            System.out.printf("El directorio contiene %s\n", directorio.listFiles());
            for(int i=0;i<ficheros.length;i++){
                System.out.printf("El archivo %s es %s\n",directorio.listFiles()[i].getName() , directorio.listFiles()[i].isDirectory()?"directorio":"fichero");
                if(directorio.listFiles()[i].isDirectory()){
                }
            }
        }else{
            System.out.printf("El directorio no existe");
        }

    }
}
