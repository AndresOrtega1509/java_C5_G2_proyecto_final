package com.plataforma.cursos.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;

import com.plataforma.cursos.exception.CursoLlenoException;
import com.plataforma.cursos.exception.EstudianteNoEncontradoException;
import com.plataforma.cursos.model.Curso;
import com.plataforma.cursos.model.Estudiante;
import com.plataforma.cursos.model.Inscripcion;

public class InscripcionService {
    private static final Logger logger = LogManager.getLogger(InscripcionService.class);

    private List<Inscripcion> inscripciones;

    public InscripcionService(){
        logger.info("Se inicializa InscripcionService");
        this.inscripciones = new ArrayList<>();
    }

    public void inscribirEstudiante(Curso curso, Estudiante estudiante){
        logger.info("Inscribiendo estudiante: {} al curso: {}", estudiante.getNombre(), curso.getNombre());
        if (curso.estaLleno()) {
            logger.warn("No se puede inscribir al estudiante: {}. El curso: {} esta lleno", estudiante.getNombre(), curso.getNombre());
            throw new CursoLlenoException("El curso: " + curso.getNombre() + ", esta lleno. No se puede inscribir al estudiante: " + estudiante.getNombre());
        }
        Inscripcion inscripcion = new Inscripcion(estudiante, curso);
        this.inscripciones.add(inscripcion);
        curso.agregarEstudiante(estudiante);
        logger.info("Estudiante: {} inscrito exitosamente al curso: {}", estudiante.getNombre(), curso.getNombre());
    }

    public List<Inscripcion> listarInscripciones(){
        logger.info("Listando todas las inscripciones");
        return inscripciones;
    }

    public List<Inscripcion> listarInscripcionesPorEstudiante(Estudiante estudiante) throws EstudianteNoEncontradoException{
        logger.info("Listando inscripciones para el estudiante: {}", estudiante.getNombre());
        List<Inscripcion> inscripcionesEstudiante = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getEstudiante().getId().equals(estudiante.getId())) {
                inscripcionesEstudiante.add(inscripcion);
            }
        }
        if (inscripcionesEstudiante.size() == 0) {
            logger.warn("No se encontraron inscripciones para el estudiante: {}", estudiante.getNombre());
            throw new EstudianteNoEncontradoException("No se encontraron inscripciones para el estudiante: " + estudiante.getNombre());
        }
        logger.info("Se encontraron {} inscripciones para el estudiante: {}", inscripcionesEstudiante.size(), estudiante.getNombre());
        return inscripcionesEstudiante;
    }
}