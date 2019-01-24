package examen;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\examen";
        File fichero = new File(ruta, "ficheroBinario.dat");
        ListaAlumnos listaAlumnos = new ListaAlumnos();
        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(fichero));

        System.out.println("Comienzo de copia...");
        try{
            while(true){
                Alumno alumno =(Alumno) objectIn.readObject();
                listaAlumnos.add(alumno);
            }
        }catch(EOFException eo){
            System.out.println("Fin de lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        objectIn.close();

        try{
            XStream xstream = new XStream();
            xstream.alias("ListaAlumnos",ListaAlumnos.class);
            xstream.alias("DatosAlumno", Alumno.class);
            xstream.addImplicitCollection(ListaAlumnos.class,"listAlumno");
            xstream.toXML(listaAlumnos,new FileOutputStream("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\examen\\ficheroXML.xml"));
            System.out.println("Creando fichero XML...");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}