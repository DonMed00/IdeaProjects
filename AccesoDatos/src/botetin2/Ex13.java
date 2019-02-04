package botetin2;

import java.sql.*;

import static utilidades.Teclado.leerString;

public class Ex13 {
    public static void main(String[] args) {
        Connection conexion;
        String codOe, codCurso;
        int contador = 0;
        boolean desdoble=false;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1010");
            Statement sentencia = conexion.createStatement();


            System.out.println("Introduce codigo de oferta: ");
            codOe = leerString();

            System.out.println("Introduce codigo de curso: ");
            codCurso = leerString();

            String sql = "select distinct dia from tramohorario order by 1", sql3 = String.format("select horaInicio,codAsig, dia from horario h join tramohorario t on h.codTramo=t.codTramo where codOe='%s' and codCurso ='%s' order by 1,3",codOe,codCurso);
            ResultSet resul = sentencia.executeQuery(sql);


            while (resul.next()) {
                System.out.printf("%15s", resul.getString(1));
            }
            System.out.println();
            resul = sentencia.executeQuery(sql3);


            while (resul.next()) {
                if (!resul.getString(2).startsWith("@")) {
                    if (contador == 0) {
                        if (!desdoble) {
                            System.out.printf("%s %6s", resul.getString(1), resul.getString(2));
                        }else{
                            System.out.printf("%s %5s*", resul.getString(1), resul.getString(2));
                            desdoble=false;
                        }
                    } else {
                        if (!desdoble) {
                            System.out.printf("%15s", resul.getString(2));
                        }else{
                            System.out.printf("%14s*", resul.getString(2));
                            desdoble=false;
                        }

                    }
                }else{
                    contador--;
                    desdoble=true;
                }
                contador++;
                if (contador == 5) {
                    System.out.println();
                    contador = 0;
                }

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
