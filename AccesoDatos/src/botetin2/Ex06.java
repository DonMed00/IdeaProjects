package botetin2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex06 {
    public static void main(String[] args) {
        String sql ="delete from ofertaeducativa where codOe='FPB'";


        try {
            Statement sentencia;
            Connection conexion;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");

            sentencia = conexion.createStatement();

            sentencia.executeUpdate(sql);

            sql ="delete from profesor where codProf='DAS'";
            sentencia.executeUpdate(sql);

            sql ="delete from asignatura where codAsig in ('OACE','MMSCI')";
            sentencia.executeUpdate(sql);

            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
