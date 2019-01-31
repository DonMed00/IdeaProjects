package botetin2;

import java.sql.*;

public class Ex09 {
    public static void main(String[] args) {
        Connection conexion ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT p.*,ifnull(codOe,''), ifnull(codCurso,'Este profesor no es tutor')'Curso' FROM profesor p left join curso on codProf=codTutor";
            ResultSet resul = sentencia.executeQuery(sql);
            ResultSetMetaData rsmd = resul.getMetaData();
            String nula;
            int nColumnas = rsmd.getColumnCount();
            System.out.printf("Número de columnas recuperadas: %d%n", nColumnas) ;
            for (int i = 1; i <= nColumnas; i++) {
                System.out.printf("Columna %d: %n ", i);
                System.out.printf("Nombre columna: %s \n",rsmd.getColumnName(i));
                System.out.printf("Tipo dato columna: %s \n",rsmd.getColumnTypeName(i));

                if (rsmd.isNullable(i) == 0) {
                    nula = "NO";
                }else {
                    nula = "SI";
                }
                System.out.printf(" Puede ser nula?: %s %n ", nula);
                System.out.printf(" Máximo ancho de la columna: %d %n\n", rsmd.getColumnDisplaySize(i));
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
