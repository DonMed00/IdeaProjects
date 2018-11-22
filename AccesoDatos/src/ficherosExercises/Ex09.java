package ficherosExercises;

import utilidades.Teclado;

import java.io.*;

import static utilidades.Teclado.leerBoolean;
import static utilidades.Teclado.leerNumero;
import static utilidades.Teclado.leerString;


public class Ex09 {
    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises";
        File ficheroAleatorio = new File(ruta, "aleatorio.dat");
        RandomAccessFile aleatorio = new RandomAccessFile(ficheroAleatorio, "r");
        int opcion;
        int id;
        System.out.println("Elige una opción");
        System.out.println("1. Mostrar todos los contactos");
        System.out.println("2. Mostrar un contacto");
        System.out.println("3. Añadir un contacto");
        System.out.println("4. Eliminar un contacto");
        System.out.println("5. Modificar deudas");
        System.out.println("6. Compactación fichero");
        opcion = Teclado.leerEntre(1, 6, Teclado.Incluido.TODOS, Teclado.Tipo.INT);

        switch (opcion) {
            case 1:
                mostrarContactos(aleatorio, ficheroAleatorio);
                break;
            case 2:
                int aux = (int) aleatorio.length();
                System.out.println("Introduce el contacto a ver: ");
                id = Teclado.leerEntre(1, aux / 142, Teclado.Incluido.TODOS, Teclado.Tipo.INT);
                mostrarContacto(aleatorio, ficheroAleatorio, id);
                break;
            case 3:
                boolean posicion = leerBoolean("¿Por el final o en posición libre?","FINAL","LIBRE");
                addContacto(aleatorio, ficheroAleatorio, posicion);

        }
    }

    private static void mostrarContactos(RandomAccessFile aleatorio, File ficheroAleatorio) {
        int id = 1;
        int posicion = 0;
        try {
            while (posicion < aleatorio.length()) {
                mostrarContacto(aleatorio, ficheroAleatorio, id);
                id++;
                posicion = (id - 1) * 142;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarContacto(RandomAccessFile aleatorio, File ficheroAleatorio, int id) {
        int posicion = (id - 1) * 142;
        final int BUFFERLENGHT = 20;
        try {
            aleatorio = new RandomAccessFile(ficheroAleatorio, "r");
            aleatorio.seek(posicion + 4);
            if (aleatorio.readBoolean()) {
                aleatorio.seek(posicion + 1);
                id = aleatorio.readInt();
                System.out.println("\nIdentificador: " + id);
                aleatorio.seek(posicion + 5);
                System.out.print("Nombre: ");
                for (int i = 0; i < BUFFERLENGHT; i++) {
                    System.out.print(aleatorio.readChar());
                }
                System.out.println("\nTeléfono: " + aleatorio.readInt());
                System.out.print("Dirección: ");
                for (int i = 0; i < BUFFERLENGHT; i++) {
                    System.out.print(aleatorio.readChar());
                }

                System.out.print("\nFecha de nacimiento: ");
                for (int i = 0; i < BUFFERLENGHT; i++) {
                    System.out.print(aleatorio.readChar());
                }
                System.out.println("\nCódigo postal: " + aleatorio.readInt());
                if (aleatorio.readBoolean()) {
                    System.out.printf("Debe %.2f€\n", aleatorio.readDouble());
                } else {
                    System.out.println("No debe dinero");
                    aleatorio.readDouble();
                }
            }
        } catch (EOFException eo) {
            System.out.println("Fin de lectura");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addContacto(RandomAccessFile aleatorio, File ficheroAleatorio, boolean posicion) {
        Agenda agenda;
        StringBuffer buffer;
        Boolean repetir;
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
            agenda.setMoney(leerBoolean("¿Debo dinero?", "Si", "No"));
            if (agenda.isMoney()) {
                System.out.println("Introduce cantidad debida");
                agenda.setAmount(leerNumero(Teclado.Tipo.DOUBLE));
            } else {
                agenda.setAmount(0);
            }
            if (posicion) {
                try {
                    aleatorio = new RandomAccessFile(ficheroAleatorio, "rw");

                    aleatorio.seek(aleatorio.length());
                    aleatorio.writeBoolean(true);
                    aleatorio.writeInt((int) aleatorio.length() / 142 + 1);
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
                } catch (EOFException e) {
                    System.out.println("Fin lectura");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            repetir = Teclado.leerBoolean("¿Meter otro dato?", "Si", "No");
        } while (repetir);
    }
}
