package ficherosExercises;

import utilidades.Teclado;

import java.io.*;

import static utilidades.Teclado.leerBoolean;
import static utilidades.Teclado.leerNumero;
import static utilidades.Teclado.leerString;

public class Ex08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        Agenda agenda;
        File  fichero;
        DataOutputStream dataOut;
        DataInputStream dataIN = null;
        ObjectInputStream objectIN = null;
        ObjectOutputStream objectOut;
        boolean elegir;
        boolean repetir;

        String name;
        int tel;
        String address;
        int postal;
        String birth;
        boolean money;
        double amount;

        elegir = Teclado.leerBoolean("Elige opcion","1","2");

        if(elegir) {
            fichero = new File(ruta,"ejemplo1.dat");
            try {
                dataOut = new DataOutputStream(new FileOutputStream(fichero));
                agenda = new Agenda();
                do {
                    System.out.println("Introduce nombre");
                    agenda.setName(leerString());
                    System.out.println("Introduce teléfono");
                    agenda.setTel(leerNumero(Teclado.Tipo.INT));
                    System.out.println("Introduce dirección");
                    agenda.setAddress(leerString());
                    System.out.println("Introduce fecha nacimiento");
                    agenda.setBirth(leerString());
                    System.out.println("Introduce CP");
                    agenda.setPostal(leerNumero(Teclado.Tipo.INT));
                    agenda.setMoney(leerBoolean("¿Debo dinero?","Si","No"));
                    if(agenda.isMoney()) {
                        System.out.println("Introduce cantidad debida");
                        agenda.setAmount(leerNumero(Teclado.Tipo.DOUBLE));
                    }else{
                        agenda.setAmount(0.0);
                    }

                    dataOut.writeUTF(agenda.getName());
                    dataOut.writeInt(agenda.getTel());
                    dataOut.writeUTF(agenda.getAddress());
                    dataOut.writeInt(agenda.getPostal());
                    dataOut.writeUTF(agenda.getBirth());
                    dataOut.writeBoolean(agenda.isMoney());
                    dataOut.writeDouble(agenda.getAmount());

                    repetir = Teclado.leerBoolean("¿Meter otro dato?","Si","No");
                }while(repetir);

                dataOut.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

                try {
                    dataIN = new DataInputStream(new FileInputStream(fichero));
                    while (true) {
                        name = dataIN.readUTF();
                        tel = dataIN.readInt();
                        address = dataIN.readUTF();
                        postal = dataIN.readInt();
                        birth = dataIN.readUTF();
                        money = dataIN.readBoolean();
                        amount = dataIN.readDouble();
                        System.out.printf("Agenda\nNombre: %s\nTelf: %d\nDireccion: %s\nCP: %d\nFnac: %s\nDebo Dinero: %s\nCantidad: %.1f €\n", name, tel, address, postal, birth, money ? "si" : "no", amount);

                    }
                } catch (EOFException e) {
                    System.out.println("Fin de lectura");

                }
            dataIN.close();

        }else {
            fichero = new File(ruta,"ejemplo.dat");
            try {

                if(fichero.exists()) {
                    objectOut = new MiObjectOutputStream(new FileOutputStream(fichero,true));//Para seguir añadiendo contenido a un fichero existente.
                }else{
                    objectOut = new ObjectOutputStream(new FileOutputStream(fichero));
                }
                do {
                    agenda = new Agenda();
                    System.out.println("Introduce nombre");
                    agenda.setName(leerString());
                    System.out.println("Introduce teléfono");
                    agenda.setTel(leerNumero(Teclado.Tipo.INT));
                    System.out.println("Introduce dirección");
                    agenda.setAddress(leerString());
                    System.out.println("Introduce fecha nacimiento");
                    agenda.setBirth(leerString());
                    System.out.println("Introduce CP");
                    agenda.setPostal(leerNumero(Teclado.Tipo.INT));
                    agenda.setMoney(leerBoolean("¿Debo dinero?","Si","No"));
                    if(agenda.isMoney()) {
                        System.out.println("Introduce cantidad debida");
                        agenda.setAmount(leerNumero(Teclado.Tipo.DOUBLE));
                    }else{
                        agenda.setAmount(0.0);
                    }
                    objectOut.writeObject(agenda);
                    repetir = Teclado.leerBoolean("¿Meter otro dato?","Si","No");
                }while(repetir);
                objectOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                Agenda agendaAux;
                objectIN = new ObjectInputStream(new FileInputStream(fichero));
                while (true) {
                    agendaAux = (Agenda) objectIN.readObject();
                    System.out.printf("\nNombre: %s\nTelf: %d\nDireccion: %s\nCP: %d\nFnac: %s\nDebo Dinero: %s\nCantidad: %.1f €\n", agendaAux.getName(), agendaAux.getTel(), agendaAux.getAddress(), agendaAux.getPostal(), agendaAux.getBirth(), agendaAux.isMoney() ? "si" : "no", agendaAux.getAmount());

                }
            }catch(EOFException e){
                System.out.println("Fin de lectura");
            }
            objectIN.close();

        }



    }
}
