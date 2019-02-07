package botetin2;

import java.sql.*;


public class Ex16 {
    public static void main(String[] args) {
        Connection conexion ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();


            String sql = "select a.codAsig, a.nombre, horasSemanales,count(codOe and codCurso)'Cursos distintos', count(distinct codOe )'Ofertas distintos' from asignatura a join reparto r on a.codAsig=r.codAsig where horasSemanales>2 group by 1,2,3 order by 4 desc";

            ResultSet resul = sentencia.executeQuery(sql);
            while (resul.next ()) {
                System.out.printf("La asignatura %s tiene %s horas semanales\ny se imparte en %s ofertas y en %s cursos distintos\n\n",resul.getString(2),resul.getString(3),resul.getString(4),resul.getString(5));
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
