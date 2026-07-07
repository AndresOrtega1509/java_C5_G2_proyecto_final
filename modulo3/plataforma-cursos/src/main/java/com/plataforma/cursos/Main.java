package com.plataforma.cursos;

import org.apache.logging.log4j.*;

import com.plataforma.cursos.service.CursoService;
import com.plataforma.cursos.service.InscripcionService;
import com.plataforma.cursos.model.Curso;
import com.plataforma.cursos.model.Estudiante;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Iniciando aplicación");
        CursoService cursoService = new CursoService();
        InscripcionService inscripcionService = new InscripcionService();

        // Crear cursos
        Curso curso1 = new Curso("Java Básico", "C001", 30);
        Curso curso2 = new Curso("Python Intermedio", "C002", 25);
        Curso curso3 = new Curso("JavaScript Avanzado", "C003", 20);

        // Agregar cursos al servicio
        cursoService.agregarCurso(curso1);
        cursoService.agregarCurso(curso2);
        cursoService.agregarCurso(curso3);

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "E001", "juan.perez@email.com");
        Estudiante estudiante2 = new Estudiante("María García", "E002", "maria.garcia@email.com");

        // Inscribir estudiantes a cursos
        inscripcionService.inscribirEstudiante(curso1, estudiante1);
        inscripcionService.inscribirEstudiante(curso2, estudiante2);
    }
}