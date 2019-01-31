package botetin2;

import java.sql.*;

public class Ex10 {
    public static void main(String[] args) {
        Connection conexion ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();
            String sql = "select o.nombre, codCurso, p.nombre, apellidos from curso c join ofertaeducativa o on c.codOe=o.codOe join profesor p on codTutor=codProf";
            ResultSet resul = sentencia.executeQuery(sql);

            System.out.println("Cursos:\n");
            while (resul.next ()) {
                System.out.printf("%s, %s, %s %s. %n", resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
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
