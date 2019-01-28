package botetin2;

import java.sql.*;

public class Ex04 {
    public static void main(String[] args) {
        String sql = String.format("INSERT INTO profesor values ('DAS','David','Ayala Soriano',now())");
        String sql2 = String.format("INSERT INTO curso values ('FPB','1A','DAS')");
        String sql3 = String.format("INSERT INTO asignatura values (?,?,?,?)");
        String sql4 = String.format("INSERT INTO reparto values (?,?,?,?)");


        PreparedStatement preparedStatement;


        try {
            Statement sentencia;
            Connection conexion;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");

            sentencia = conexion.createStatement();

            sentencia.executeUpdate(sql);
            sentencia.executeUpdate(sql2);
            preparedStatement = conexion.prepareStatement(sql3);

            preparedStatement.setString(1,"OACE");
            preparedStatement.setString(2,"Operaciones auxiliares para la configuración y la explotación");
            preparedStatement.setInt(3,7);
            preparedStatement.setInt(4,245);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1,"MMSCI");
            preparedStatement.setString(2,"Montaje y mantenimiento de sistemas y componentes informáticos");
            preparedStatement.setInt(3,9);
            preparedStatement.setInt(4,315);

            preparedStatement.executeUpdate();


            preparedStatement = conexion.prepareStatement(sql4);

            preparedStatement.setString(1,"FPB");
            preparedStatement.setString(2,"1A");
            preparedStatement.setString(3,"OACE");
            preparedStatement.setString(4,"DAS");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1,"FPB");
            preparedStatement.setString(2,"1A");
            preparedStatement.setString(3,"MMSCI");
            preparedStatement.setString(4,"MGD");
            preparedStatement.executeUpdate();






        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }


