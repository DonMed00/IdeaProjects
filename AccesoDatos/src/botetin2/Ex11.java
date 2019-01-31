package botetin2;

import java.sql.*;

public class Ex11 {
    public static void main(String[] args) {
        Connection conexion ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();
            String sql = "select a.codAsig, nombre, t.* from tramohorario t join horario h on t.codTramo=h.codTramo join asignatura a on h.codAsig=a.codAsig join reparto r on a.codAsig=r.codAsig join curso c on r.codCurso=c.codCurso and r.codOe=c.codOe where c.codOe";
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
