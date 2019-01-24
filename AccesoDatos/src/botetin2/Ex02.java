package botetin2;

import java.sql.*;

public class Ex02 {
    public static void main(String[] args) {
        String tipo;
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul, resul2;
            resul =dbmd.getColumns(null, null, "profesor", null);
            resul2 = dbmd.getPrimaryKeys(null, null, "profesor");
            System.out.println("Las columnas son");
            while (resul.next ()) {
                tipo= resul.getString(4);
                System.out.printf("%s ", tipo);

            }
            System.out.println("\nLas primary keys son: ");

            while (resul2.next ()) {
                tipo= resul2.getString(4);
                System.out.printf("%s ", tipo);

            }



            conexion.close();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


}
