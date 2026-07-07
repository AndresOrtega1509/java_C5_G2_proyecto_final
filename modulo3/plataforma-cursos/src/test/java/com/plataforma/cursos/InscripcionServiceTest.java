package com.plataforma.cursos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.plataforma.cursos.exception.CursoLlenoException;
import com.plataforma.cursos.exception.EstudianteNoEncontradoException;
import com.plataforma.cursos.model.Curso;
import com.plataforma.cursos.model.Estudiante;
import com.plataforma.cursos.service.InscripcionService;

public class InscripcionServiceTest {
    private InscripcionService inscripcionService;

    @BeforeEach
    void setUp(){
        inscripcionService = new InscripcionService();
    }

    @Test
    void testInscribirEstudianteCursoCorrectamente() {
        Curso curso = new Curso("Futbol", " F001", 3);
        Estudiante estudiante = new Estudiante("Andres", "E001", "andres@gmail.com");
        Estudiante estudiante2 = new Estudiante("Sara", "E002", "Sara@hotmail.com");
        Estudiante estudiante3 = new Estudiante("Pedro", "E003", "pedro@gmail.com");
        inscripcionService.inscribirEstudiante(curso, estudiante);
        inscripcionService.inscribirEstudiante(curso, estudiante2);
        inscripcionService.inscribirEstudiante(curso, estudiante3);
        assertEquals(estudiante3.getId(), inscripcionService.listarInscripciones().get(2).getEstudiante().getId());
        assertEquals(curso.getCodigo(), inscripcionService.listarInscripciones().get(2).getCurso().getCodigo());
    }

    @Test
    void testInscribirEstudianteCursoLleno(){
        Curso curso = new Curso("Futbol", " F001", 2);
        Estudiante estudiante = new Estudiante("Andres", "E001", "andres@gmail.com");
        Estudiante estudiante2 = new Estudiante("Sara", "E002", "Sara@hotmail.com");
        inscripcionService.inscribirEstudiante(curso, estudiante);
        inscripcionService.inscribirEstudiante(curso, estudiante2);
        CursoLlenoException cursoLlenoException = assertThrows(CursoLlenoException.class, () -> {
            inscripcionService.inscribirEstudiante(curso, new Estudiante("Pedro", "E003", "pedro@gmail.com"));
        });
        assertEquals("El curso: Futbol, esta lleno. No se puede inscribir al estudiante: Pedro", cursoLlenoException.getMessage());
    }

    @Test
    void testListarInscripciones() {
        Curso curso = new Curso("Futbol", " F001", 2);
        Estudiante estudiante = new Estudiante("Andres", "E001", "andres@gmail.com");
        Estudiante estudiante2 = new Estudiante("Sara", "E002", "Sara@hotmail.com");
        inscripcionService.inscribirEstudiante(curso, estudiante);
        inscripcionService.inscribirEstudiante(curso, estudiante2);
        assertEquals(2, inscripcionService.listarInscripciones().size());
    }

    @Test
    void testListarInscripcionesPorEstudianteCorrectamente() throws EstudianteNoEncontradoException{
        Curso curso1 = new Curso("Futbol", " F001", 2);
        Curso curso2 = new Curso("Tenis", "T001", 8);
        Estudiante estudiante1 = new Estudiante("Andres", "E001", "andres@gmail.com");
        Estudiante estudiante2 = new Estudiante("Sara", "E002", "Sara@hotmail.com");
        inscripcionService.inscribirEstudiante(curso1, estudiante1);
        inscripcionService.inscribirEstudiante(curso1, estudiante2);
        inscripcionService.inscribirEstudiante(curso2, estudiante2);
        
        assertEquals(2, inscripcionService.listarInscripcionesPorEstudiante(estudiante2).size());
        assertEquals("E001",
                    inscripcionService.listarInscripcionesPorEstudiante(estudiante1).get(0).getEstudiante().getId());
        assertEquals("T001",
                    inscripcionService.listarInscripcionesPorEstudiante(estudiante2).get(1).getCurso().getCodigo());
        
    }

    @Test
    void testListarInscripcionesPorEstudianteSinInscripciones() {
        Curso curso = new Curso("Futbol", " F001", 2);
        Estudiante estudiante = new Estudiante("Andres", "E001", "andres@gmail.com");
        Estudiante estudiante2 = new Estudiante("Sara", "E002", "Sara@hotmail.com");
        EstudianteNoEncontradoException exception = assertThrows(EstudianteNoEncontradoException.class, () -> {
            inscripcionService.listarInscripcionesPorEstudiante(estudiante2);
        });
        assertEquals("No se encontraron inscripciones para el estudiante: " + estudiante2.getNombre(), exception.getMessage());
    }
}