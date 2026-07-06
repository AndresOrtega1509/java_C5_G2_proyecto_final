package com.plataforma.cursos.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;

import com.plataforma.cursos.exception.CursoLlenoException;
import com.plataforma.cursos.model.Curso;

public class CursoService {
    private static final Logger logger = LogManager.getLogger(CursoService.class);

    private List<Curso> cursos;

    public CursoService(){
        logger.info("CursoService inicializado");
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso){
        logger.info("Agregando curso: {}", curso.getNombre());
        this.cursos.add(curso);
    }

    public List<Curso> listarCursos(){
        logger.info("Listando los cursos disponibles");
        return cursos;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        logger.info("Buscando curso con el codigo: " + codigo);
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                logger.info("Curso encontrado: " + curso.getNombre());
                return curso;
            }
        }
        logger.warn("No se encontro el curso con el codigo indicado: {}", codigo);
        throw new CursoLlenoException("Curso con codigo: " + codigo + ", no encontrado");
    }
}