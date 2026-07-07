package com.plataforma.cursos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.plataforma.cursos.exception.CursoLlenoException;
import com.plataforma.cursos.model.Curso;
import com.plataforma.cursos.service.CursoService;

public class CursoServiceTest {
    private CursoService cursoService;

    @BeforeEach
    void setUp() {
        cursoService = new CursoService();
    }

    @Test
    void testAgregarCursoCorrectamente() {
        Curso curso1 = new Curso("Economia", "C001", 10);
        Curso curso2 = new Curso("HCI", "C002", 15);
        cursoService.agregarCurso(curso1);
        cursoService.agregarCurso(curso2);

        assertEquals(curso1, cursoService.buscarCursoPorCodigo(curso1.getCodigo()));
        assertEquals("HCI", cursoService.listarCursos().get(1).getNombre());
        assertTrue(cursoService.listarCursos().size() == 2);
    }

    @Test
    void testListarCursosVacio() {
        assertEquals(0, cursoService.listarCursos().size());
    }

    @Test
    void testBuscarCursoPorCodigo() {
        Curso curso = new Curso("Java", "C002", 30);
        Curso curso2 = new Curso("Python", "C003", 25);
        Curso curso3 = new Curso("JavaScript", "C004", 20);
        cursoService.agregarCurso(curso);
        cursoService.agregarCurso(curso2);
        cursoService.agregarCurso(curso3);
        Curso cursoEncontrado = cursoService.buscarCursoPorCodigo("C003");
        assertEquals("Python", cursoEncontrado.getNombre());
    }

    @Test
    void testBuscarCursoPorCodigoNoEncontrado() {
        Curso curso = new Curso("Java", "C001", 30);
        cursoService.agregarCurso(curso);
        CursoLlenoException exception = assertThrows(CursoLlenoException.class, () -> {
            cursoService.buscarCursoPorCodigo("C003");
        });
        assertEquals("Curso con codigo: C003, no encontrado", exception.getMessage());
    }
}