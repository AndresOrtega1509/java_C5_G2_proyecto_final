package com.plataforma.cursos.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String codigo;
    private int capacidadMaxima;
    private List<Estudiante> estudiantes;

    public Curso(String nombre, String codigo, int capacidadMaxima){
        this.nombre = nombre;
        this.codigo = codigo;
        this.capacidadMaxima = capacidadMaxima;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", codigo=" + codigo + ", capacidadMaxima=" + capacidadMaxima
                + ", estudiantes=" + estudiantes + "]";
    }
}