package botetin2;

import java.sql.*;

import static utilidades.Teclado.leerString;

public class Ex12 {
    public static void main(String[] args) {
        Connection conexion ;
        String codProf;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();


            System.out.println("Introduce codigo de profesor: ");
            codProf=leerString();

            String sql = String.format("select a.nombre,p.codProf,p.nombre,p.apellidos from asignatura a join reparto r on a.codAsig=r.codAsig join profesor p on r.codProf=p.codProf where r.codProf ='%s'",codProf);
            String sql1= String.format("select nombre, apellidos from profesor where codProf='%s'",codProf);
            ResultSet resul = sentencia.executeQuery(sql1);
            while (resul.next ()) {
                System.out.printf("El profesor %s %s imparte: \n", resul.getString(1),resul.getString(2));
            }

            resul = sentencia.executeQuery(sql);
            while (resul.next ()) {
                System.out.printf("%s. %n", resul.getString(1));
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
