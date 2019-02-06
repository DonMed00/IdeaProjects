package botetin2;

import java.sql.*;

import static utilidades.Teclado.leerString;

public class Ex15 {
    public static void main(String[] args) {
        Connection conexion;
        String dia = "", codProf;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();

            System.out.println("Introduce codigo de profesor: ");
            codProf = leerString();

            String sql = "select dayname(now())";

            ResultSet resul = sentencia.executeQuery(sql);
            switch (String.valueOf(resul)) {
                case "MONDAY":
                    dia = "Lunes";
                    break;
                case "TUESDAY":
                    dia = "Martes";
                    break;
                case "WEDNESDAY":
                    dia = "Miercoles";
                    break;
                case "THURSDAY":
                    dia = "Jueves";
                    break;
                case "FRIDAY":
                    dia = "Viernes";
                    break;

            }

            sql = String.format("select p.nombre, p.apellidos, a.nombre, r.codOe, r.codCurso from profesor p join reparto r on p.codProf=r.codProf join asignatura a on r.codAsig=a.codAsig join horario h on r.codAsig=h.codAsig join tramohorario t on h.codTramo=t.codTramo where time(now()) between horaInicio and HoraFin and dia='%s' and p.codProf='%s'", dia, codProf);

            resul = sentencia.executeQuery(sql);


            while (resul.next()) {
                System.out.printf("El profesor %s %s se encuentra ahora mismo impartiendo %s del curso %s %s", resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getString(5));
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
