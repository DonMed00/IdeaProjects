package botetin2;

import java.sql.*;

public class Ex03 {
    public static void main(String[] args) {

        String sql = String.format("INSERT INTO ofertaeducativa(codOe,nombre,descripcion) VALUES ('FPB','FP Básica Informática y comunicaciones', 'La formación profesional básica de informática y comunicaciones tiene una duración de 2000 horas repartidas entre dos cursos académicos incluyendo 240 horas de Formación en centros de trabajo (FCT) en empresas del Sector')");

        try {
            Statement sentencia;
            Connection conexion;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");

            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);

            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
