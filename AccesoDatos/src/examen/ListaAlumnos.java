package examen;

import java.util.ArrayList;
import java.util.List;

public class ListaAlumnos {

    private List<Alumno> listAlumno = new ArrayList<Alumno>();

    public void add(Alumno alumno) {
        listAlumno.add(alumno);
    }

    public List<Alumno> getListAlumno() {
        return listAlumno;
    }
}

