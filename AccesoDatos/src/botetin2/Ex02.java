package botetin2;

import java.sql.*;

import static utilidades.Teclado.leerString;

public class Ex02 {
    public static void main(String[] args) {
        String tipo;
        String tabla = null;
        Connection conexion = null;
        int cont=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul;
            do {
                System.out.println("Introduce el nombre de la tabla correcto:");
                tabla = leerString();
                resul =dbmd.getColumns(null, null, tabla, null);
            }while(!resul.next());
            System.out.printf("\nLa tabla es %s\n",resul.getString(3));

            System.out.printf("\nLas columnas de la tabla son:\n");
            while (resul.next ()) {
                tipo= resul.getString(4);
                System.out.printf("%s ", tipo);

            }
            resul = dbmd.getPrimaryKeys(null, null, tabla);

            System.out.println("\nLa primary key está compuesta por: ");

            while (resul.next ()) {
                tipo= resul.getString(4);
                System.out.printf("%s ", tipo);

            }

            resul = dbmd.getImportedKeys(null,null,tabla);

            System.out.println("\nLas claves ajenas son: ");

            while (resul.next ()) {
                tipo= resul.getString(4);
                System.out.printf("%s ", tipo);

            }

            resul = dbmd.getExportedKeys(null,null,tabla);
            System.out.printf("\nLa clave primaria de esta tabla se usa en:\n ");

            while (resul.next ()) {
                tipo= resul.getString(7);
                System.out.printf("%s ", tipo);
                cont ++;

            }



            conexion.close();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


}
