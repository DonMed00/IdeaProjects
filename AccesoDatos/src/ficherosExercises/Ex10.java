package ficherosExercises;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        File fichero = new File(ruta,"ejemplo.dat");
        ListaContactos listaContactos = new ListaContactos();
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

        System.out.println("Comienzo de copia...");

        try{
            while(true){
                Agenda agenda =(Agenda) dataIS.readObject();
                listaContactos.add(agenda);
            }
        }catch(EOFException eo){
            System.out.println("Fin lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dataIS.close();
        disableWarning();
        try{
            XStream xstream = new XStream();
            xstream.alias("ListaContactosAgenda",ListaContactos.class);
            xstream.alias("DatosContacto", Agenda.class);
            xstream.addImplicitCollection(ListaContactos.class,"listAgenda");
            xstream.toXML(listaContactos,new FileOutputStream("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\Agenda.xml"));
            System.out.println("Creando fichero XML....");
        }catch (Exception e){
            System.out.println("no vale");
        }
    }


    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

}
