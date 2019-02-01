package botetin2;

import java.sql.*;

import static utilidades.Teclado.leerString;

public class Ex12 {
    public static void main(String[] args) {
        Connection conexion ;
        String codAsig;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();


            System.out.println("Introduce asignatura: ");
            codAsig=leerString();

            String sql = String.format("select a.nombre,p.codProf,p.nombre,p.apellidos from asignatura a join reparto r on a.codAsig=r.codAsig join profesor p on r.codProf=p.codProf where a.codAsig ='%s'",codAsig);
            ResultSet resul = sentencia.executeQuery(sql);

            while (resul.next ()) {
                System.out.printf(" La asignatura %s es impartida por %s, %s %s . %n", resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
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
