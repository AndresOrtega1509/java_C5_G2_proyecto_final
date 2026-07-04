package com.plataforma.cursos.model;

import java.time.LocalDate;

public class Inscripcion {
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fechaInscripcion;

    public Inscripcion(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaInscripcion = LocalDate.now();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    
    @Override
    public String toString() {
        return "Inscripcion [estudiante=" + estudiante + ", curso=" + curso + ", fechaInscripcion=" + fechaInscripcion
                + "]";
    }
}