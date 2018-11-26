package ficherosExercises;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;

public class Ex15 {
    public static void main(String[] args) {
        File json = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\ficheroJson.json");
        File f15 = new File("C:\\Users\\Usuario\\IdeaProjects\\AccesoDatos\\src\\ficherosExercises\\fichTexto.txt");
        FileReader rd = null;
        FileWriter wr = null;
        String start = "Agenda";
        String end = "END OF THE Agenda";
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ListaContactos listaContacto;
        Gson gson = new Gson();
        Type typeListaContactos = new TypeToken<ListaContactos>(){}.getType();

        try {
            rd = new FileReader(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listaContacto = gson.fromJson(rd, typeListaContactos);

        try {
            f15.createNewFile();
            wr = new FileWriter(f15);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wr.write(String.format("%090d\n", 0).replace("0", "*"));
            wr.write(String.format("%40s\n", start));
            wr.write(String.format("%090d\n", 0).replace("0", "*"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Agenda agenda: listaContacto.getListAgenda()) {
            try {
                wr.write(String.format("Name:%16s%s\n", "", agenda.getName()));
                wr.write(String.format("Phone:%24s\n", agenda.getTel()));
                wr.write(String.format("Address:%13s%s\n", "", agenda.getAddress()));
                wr.write(String.format("Zip code:%12s%s\n", "", agenda.getPostal()));
                wr.write(String.format("Birthdate:%21s\n", agenda.getBirth()));
                wr.write(String.format("I owe money?:%8s%s\n", "", agenda.isMoney() ? "Yes" : "No"));
                wr.write(String.format("How much should you? %f\n", agenda.getAmount()));
                wr.write(String.format("%090d\n", 0).replace("0", "*"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            wr.write(String.format("%50s\n", end));
            wr.write(String.format("%090d\n", 0).replace("0", "*"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
