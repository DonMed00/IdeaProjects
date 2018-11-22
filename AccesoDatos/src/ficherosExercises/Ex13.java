package ficherosExercises;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex13 {
    public static void main(String[] args) throws IOException {
        String hojaEstilo = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\plantilla.xsl";
        String datosContactos = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\Agenda.xml";
        File pagHTML = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\mipagina.html");

        FileOutputStream os = new FileOutputStream(pagHTML);
        Source estilos = new StreamSource(hojaEstilo);
        Source datos = new StreamSource(datosContactos);

        Result result = new StreamResult(os);

        try {
            Transformer transformer= TransformerFactory.newInstance().newTransformer(estilos);
            transformer.transform(datos,result);
        } catch (TransformerConfigurationException e) {
            System.out.println("Error: " +e);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        os.close();
    }
}
