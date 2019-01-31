package botetin2;

import java.sql.*;

public class Ex08 {
    public static void main(String[] args) {
        Connection conexion ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT p.*,ifnull(codOe,''), ifnull(codCurso,'Este profesor no es tutor')'Curso' FROM profesor p left join curso on codProf=codTutor";
            ResultSet resul = sentencia.executeQuery(sql);

            System.out.println("Profesores y cursos de los que son tutores:\n");
            while (resul.next ()) {
                System.out.printf("%s, %s, %s, %s, %s %s. %n", resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6));
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
