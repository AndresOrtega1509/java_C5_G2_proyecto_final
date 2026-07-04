package com.plataforma.cursos.model;

public class Estudiante {
    private String nombre, id, correo;

    public Estudiante(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", id=" + id + ", correo=" + correo + "]";
    }
}