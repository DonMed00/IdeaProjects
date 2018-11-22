package ficherosExercises;

import java.io.File;
import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args){
        String dir = ".";
        File directorio = new File(dir);
        File subdir;
        directorio.mkdir();
        subdir = new File("C:\\Users\\Don MeD\\IdeaProjects\\AccesoDatos\\.\\directorio\\subdir");
        subdir.mkdir();
        File fichero1 = new File(dir,"fich1");
        File fichero2 = new File(dir,"fich2");
        File fichero3 = new File(subdir,"fich3");
        File ficheroNuevo = new File(subdir,"fichNuevo");

        fichero3.delete();

        System.out.println(directorio.getAbsolutePath());
        System.out.println(subdir.getAbsolutePath());
        System.out.println(Arrays.toString(subdir.list()));



    }
}
