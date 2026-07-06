package com.plataforma.cursos.model;

import java.util.ArrayList;
import java.util.List;

import com.plataforma.cursos.exception.EstudianteNoEncontradoException;

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

    public boolean estaLleno(){
        return estudiantes.size() >= capacidadMaxima;
    }

    public void agregarEstudiante(Estudiante estudiante){
        if (!estaLleno()) {
            this.estudiantes.add(estudiante);
        }
    }

    public void eliminarEstudiante(String id) throws EstudianteNoEncontradoException{
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId().equals(id)) {
                this.estudiantes.remove(estudiante);
            }
        }
        throw new EstudianteNoEncontradoException("Estudiante con id: " + id + ", no encontrado en el curso: " + nombre);
    }

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", codigo=" + codigo + ", capacidadMaxima=" + capacidadMaxima
                + ", estudiantes=" + estudiantes + "]";
    }
}