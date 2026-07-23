package com.devsenior.andres.model;

public class Visualizacion {
    private Usuario usuario;
    private Pelicula pelicula;
    private int minutosVistos;

    public Visualizacion(Usuario usuario, Pelicula pelicula, int minutosVistos) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.minutosVistos = minutosVistos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getMinutosVistos() {
        return minutosVistos;
    }

    public void setMinutosVistos(int minutosVistos) {
        this.minutosVistos = minutosVistos;
    }

    @Override
    public String toString() {
        return "Visualizacion [usuario=" + usuario + ", pelicula=" + pelicula + ", minutosVistos=" + minutosVistos
                + "]";
    }
}