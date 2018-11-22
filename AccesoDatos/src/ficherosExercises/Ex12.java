package ficherosExercises;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Ex12 {
    public static void main(String[] args)  {
        SAXParserFactory saxParserFactory = SAXParserFactory.newDefaultInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            GestionContenido handler = new GestionContenido();
            saxParser.parse("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\Agenda.xml",handler);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
