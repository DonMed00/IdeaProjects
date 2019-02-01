package botetin2;

import java.sql.*;

import static utilidades.Teclado.leerString;

public class Ex11 {
    public static void main(String[] args) {
        Connection conexion ;
        String codOe,codCurso,codAsig;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();

            System.out.println("Introduce oferta educativa:");
            codOe=leerString();

            System.out.println("Introduce curso: ");
            codCurso=leerString();
            System.out.println("Introduce asignatura: ");
            codAsig=leerString();

            String sql = String.format("select a.codAsig, nombre, t.* from tramohorario t join horario h on t.codTramo=h.codTramo join asignatura a on h.codAsig=a.codAsig join reparto r on a.codAsig=r.codAsig join curso c on r.codCurso=c.codCurso and r.codOe=c.codOe where c.codOe='%s' and c.codCurso='%s' and a.codAsig='%s'",codOe,codCurso,codAsig);
            ResultSet resul = sentencia.executeQuery(sql);

            System.out.printf("Horarios de %s del curso %s %s:\n",codAsig,codOe,codCurso);
            while (resul.next ()) {
                System.out.printf("%s, %s, %s %s %s %s. %n", resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6));
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
