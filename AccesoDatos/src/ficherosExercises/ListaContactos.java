package ficherosExercises;

import java.util.ArrayList;
import java.util.List;

public class ListaContactos {
    private List<Agenda> listAgenda = new ArrayList<Agenda>();

    public void add(Agenda agenda){
        listAgenda.add(agenda);
    }

    public List<Agenda> getListAgenda() {
        return listAgenda;
    }
}
