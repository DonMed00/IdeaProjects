package botetin2;



import java.io.*;
import java.sql.*;

public class Ex01 {
    public static void main(String[] args) {

        Connection conexion = null;
        Statement sentencia;

        File file= new File("C:\\Users\\Usuario\\Desktop\\AccesoDatos\\2018-2019_script_horario.sql");
        BufferedReader reader;
        String cadena="";
        String aux="";


        try {
            reader = new BufferedReader(new FileReader(file));

            while((cadena = reader.readLine()) != null){
                aux+=cadena;
            }


            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");


            sentencia = conexion.createStatement();
            sentencia.executeUpdate(aux);


            conexion.close();
            sentencia.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
