package examen;

import java.io.Serializable;
import java.time.LocalDate;

public class Alumno implements Serializable {

    private String nombre;
    private LocalDate fnac;
    private int n_asignaturas;
    private double altura;
    private boolean repetidor;


    public Alumno(String nombre, LocalDate fnac, int n_asignaturas, double altura, boolean repetidor) {
        this.nombre = nombre;
        this.fnac = fnac;
        this.n_asignaturas = n_asignaturas;
        this.altura = altura;
        this.repetidor = repetidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public int getN_asignaturas() {
        return n_asignaturas;
    }

    public void setN_asignaturas(int n_asignaturas) {
        this.n_asignaturas = n_asignaturas;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }
}
