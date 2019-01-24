package examen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


public class GestionContenido extends DefaultHandler {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    File fichNuevo;
    FileWriter writer;
    String cadena;
    static int i = 0;
    String nombre;
    LocalDate fnac;
    int nAsig;
    double altura;
    boolean repetidor;
    ListaAlumnos listaAlumnos = new ListaAlumnos();
    Alumno alumno;


    public GestionContenido() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {

        fichNuevo = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\examen\\ficheroJson.json");
        System.out.println("Inicio documento XML");
        try {

            writer = new FileWriter(fichNuevo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin documento XML");

        try {

            writer.write(gson.toJson(listaAlumnos));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {
        System.out.println("Copiando...");


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!qName.isEmpty()) {
            if (qName.equals("nombre")) {
                nombre = cadena;
            } else if (qName.equals("fnac")) {
                fnac = LocalDate.parse(cadena);
            } else if (qName.equals("n__asignaturas")) {
                nAsig = Integer.valueOf(cadena);
            } else if (qName.equals("altura")) {
                altura = Double.valueOf(cadena);
            }
            if (qName.equals("repetidor")) {
                repetidor = Boolean.valueOf(cadena);
                i++;
                if (altura != 0) {
                    alumno = new Alumno(nombre, fnac, nAsig, altura, repetidor);
                    listaAlumnos.add(alumno);
                    altura = 0;
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        cadena = new String(ch, start, length).trim();
    }

}
