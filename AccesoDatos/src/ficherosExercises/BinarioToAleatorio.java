package ficherosExercises;

import java.io.*;

public class BinarioToAleatorio {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        File ficheroBinario = new File(ruta,"ejemplo.dat");
        File ficheroAleatorio = new File(ruta, "aleatorio.dat");
        RandomAccessFile aleatorio;
        ObjectInputStream objIn;
        Agenda agenda;
        StringBuffer buffer;
        int id=1;
        boolean flag = true;
        try {
            ficheroAleatorio.createNewFile();
            aleatorio = new RandomAccessFile(ficheroAleatorio,"rw");
            objIn = new ObjectInputStream(new FileInputStream(ficheroBinario));
            while(true){
             agenda = (Agenda) objIn.readObject();
             aleatorio.writeBoolean(flag);
             aleatorio.writeInt(id);
             buffer = new StringBuffer(agenda.getName());
             buffer.setLength(20);
             aleatorio.writeChars(buffer.toString());
             aleatorio.writeInt(agenda.getTel());
                buffer = new StringBuffer(agenda.getAddress());
                buffer.setLength(20);
                aleatorio.writeChars(buffer.toString());

                buffer = new StringBuffer(agenda.getBirth());
                buffer.setLength(20);
                aleatorio.writeChars(buffer.toString());
             aleatorio.writeInt(agenda.getPostal());
             aleatorio.writeBoolean(agenda.isMoney());
             aleatorio.writeDouble(agenda.getAmount());
             id++;
            }
        }catch(EOFException e){
            System.out.println("Fin lectura");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
