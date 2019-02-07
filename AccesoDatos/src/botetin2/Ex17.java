package botetin2;

import java.sql.*;

import static utilidades.Teclado.leerString;

public class Ex17 {
    public static void main(String[] args) {

        Connection conexion ;//nuestro objeto de conexión a bbdd.

        String codCurso,codOe;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();

            System.out.println("Introduce codigo de curso: ");
            codCurso=leerString();

            System.out.println("Introduce codigo de oferta: ");
            codOe=leerString();


            String sql = String.format("select verProf('%s','%s')",codCurso,codOe);

            ResultSet resul = sentencia.executeQuery(sql);
            while (resul.next ()) {
                System.out.printf("El curso %s %s tiene \ncomo tutor a %s",codOe.toUpperCase(),codCurso.toUpperCase(),resul.getString(1));
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
