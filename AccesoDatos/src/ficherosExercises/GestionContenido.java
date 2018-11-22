package ficherosExercises;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestionContenido extends DefaultHandler {
    File fichNuevo;
    FileWriter writer;
    boolean inicio=true;
     boolean atributo=false;
     boolean ultimaLinea=false;

    public GestionContenido() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Inicio documento XML");
        fichNuevo =new File("C:\\Users\\Don MeD\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\Nuevo.txt");
        try {

            fichNuevo.createNewFile();
            writer= new FileWriter(fichNuevo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin documento XML");

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {
        int i;
        String cadena="\tProcesando " + attributes.getLength() + " atributos...";

        //Recorremos los atributos
        if(name.equals("DatosContacto")&& ultimaLinea){
            try {
                writer.write("\n");
                ultimaLinea=false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cadena.trim());
        for (i = 0; i < attributes.getLength(); i++) {
            try {
                writer.write(" (" + attributes.getValue(i)+")");
                atributo=true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\t\tNombre: " + attributes.getQName(i));
            System.out.println("\t\tValor: " + attributes.getValue(i));
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.printf("\tFin Elemento: %s %n", localName);

            if(qName.equals("DatosContacto")) {
                inicio = true;
                ultimaLinea = true;



            }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cadena = new String(ch, start, length).trim();
        try {
            if(!cadena.isEmpty()) {
                if(inicio){
                    writer.write(cadena);
                    inicio=false;
                }else{
                    if(atributo) {
                        writer.write(cadena);
                        atributo=false;
                    }else{
                        writer.write(' ' + cadena);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf ("\tCaracteres: %s %n", cadena);
    }
}
