package ficherosExercises;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Ex14 {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        ListaContactos listaContactos = null;
        File json = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\ficheroJson.json");
        FileWriter wr = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        xstream.alias("ListaContactosAgenda", ListaContactos.class);
        xstream.alias("DatosContacto", Agenda.class);
        xstream.addImplicitCollection(ListaContactos.class, "listAgenda");
        try {
            listaContactos = (ListaContactos) xstream.fromXML(new FileInputStream("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\Agenda.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            wr = new FileWriter(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            wr.write(gson.toJson(listaContactos));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
