package botetin2;

import java.sql.*;

public class Ex07 {
    public static void main(String[] args) {
        Connection conexion ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM profesor order by 3";
            ResultSet resul = sentencia.executeQuery(sql);

            System.out.println("Profesores ordenados por apellidos asc:");
            while (resul.next ()) {
                System.out.printf("%s, %s, %s, %s. %n", resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
            }

            sql = "SELECT * FROM profesor order by 4 desc";
            resul = sentencia.executeQuery(sql);

            System.out.println("\n\nProfesores ordenados por fecha de alta desc:");
            while (resul.next ()) {
                System.out.printf("%s, %s, %s, %s. %n", resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
            }


            sentencia.close();
            conexion.close();

            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
