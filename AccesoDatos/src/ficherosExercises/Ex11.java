package ficherosExercises;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Ex11 {
    public static void main(String[] args) throws IOException {
        File fichXML = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\Agenda.xml");
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        File ficheroAntiguo = new File(ruta, "ejemplo1.dat");
        File ficheroNuevo = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\AgendaNueva.dat");
        DataOutputStream dataOut = null;
        FileInputStream dataIN1 = null;
        FileInputStream dataIN2 = null;
        XStream xstream = new XStream();
        xstream.alias("ListaContactosAgenda", ListaContactos.class);
        xstream.alias("DatosContacto", Agenda.class);
        xstream.addImplicitCollection(ListaContactos.class, "listAgenda");
        ListaContactos listaContactos = (ListaContactos) xstream.fromXML(fichXML);
        int contador=0;
        try {
            ficheroNuevo.createNewFile();
            dataOut = new DataOutputStream(new FileOutputStream(ficheroNuevo));
            for (Agenda agenda : listaContactos.getListAgenda()) {
                dataOut.writeUTF(agenda.getName());
                dataOut.writeInt(agenda.getTel());
                dataOut.writeUTF(agenda.getAddress());
                dataOut.writeInt(agenda.getPostal());
                dataOut.writeUTF(agenda.getBirth());
                dataOut.writeBoolean(agenda.isMoney());
                dataOut.writeDouble(agenda.getAmount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataOut.close();
        try {
            dataIN1 = new FileInputStream(ficheroAntiguo);
            dataIN2 = new FileInputStream(ficheroNuevo);

            for (int i = 0; i < ficheroNuevo.length(); i++) {
                if (dataIN1.read() == dataIN2.read()) {
                    contador++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dataIN1.close();
        dataIN2.close();
        
        if(contador==ficheroNuevo.length()){
            System.out.println("Los ficheros son exactamente iguales!!");
        }
    }
}



