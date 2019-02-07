package botetin2;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import static utilidades.Teclado.leerString;

public class Ex15 {
    public static void main(String[] args) {
        Connection conexion;
        String dia, codProf, hora;


        LocalDateTime date = LocalDateTime.now();
        Locale l = new Locale("es", "ES");
        DayOfWeek diaHoy = DayOfWeek.from(date);
        hora = date.format(DateTimeFormatter.ofPattern("HH:mm"));

        dia = diaHoy.getDisplayName(TextStyle.FULL, l);

        if (dia.equals("sabado") || dia.equals("domingo")) {
            System.out.println("Es fin de semana, no hay clases");
        } else {


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
                Statement sentencia = conexion.createStatement();

                System.out.println("Introduce codigo de profesor: ");
                codProf = leerString();

                String sql;
                ResultSet resul;

                sql = String.format("select p.nombre, p.apellidos, a.nombre, r.codOe, r.codCurso from profesor p join reparto r on p.codProf=r.codProf join asignatura a on r.codAsig=a.codAsig join horario h on r.codAsig=h.codAsig join tramohorario t on h.codTramo=t.codTramo where time(now()) between horaInicio and HoraFin and p.codProf='%s' and dia='%s'", codProf, dia);

                resul = sentencia.executeQuery(sql);

                while (resul.next()) {
                    System.out.printf("Estamos a %s a las %s\nEl profesor %s %s se encuentra \nimpartiendo %s del curso %s %s\n", dia, hora, resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getString(5));
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
}
