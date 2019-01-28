package botetin2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex05 {
    public static void main(String[] args) {
        String sql = "update asignatura a join reparto r on a.codAsig=r.codAsig set horasSemanales=1.1*horasSemanales,horasTotales=1.1*horasTotales  where a.codAsig like ('M%') and codOe='FPB'";


        try {
            Statement sentencia;
            Connection conexion;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");

            sentencia = conexion.createStatement();

            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
