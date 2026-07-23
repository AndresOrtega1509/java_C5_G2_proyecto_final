package com.devsenior.andres.repository;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.andres.model.Genero;
import com.devsenior.andres.model.Pelicula;
import com.devsenior.andres.model.Usuario;
import com.devsenior.andres.model.Visualizacion;

public class DataRepository {
    public List<Usuario> usuarios = new ArrayList<>();
    public List<Pelicula> peliculas = new ArrayList<>();
    public List<Visualizacion> visualizaciones = new ArrayList<>();

    public DataRepository(){
        Usuario usuario1 = new Usuario(1, "Andres");
        Usuario usuario2 = new Usuario(2, "Carlos");
        Usuario usuario3 = new Usuario(3, "Felipe");
        Usuario usuario4 = new Usuario(4, "Laura");
        Usuario usuario5 = new Usuario(5, "Sara");
        Usuario usuario6 = new Usuario(6, "Luis");
        Usuario usuario7 = new Usuario(7, "Miguel");
        Usuario usuario8 = new Usuario(8, "Angie");
        Usuario usuario9 = new Usuario(9, "Karen");
        Usuario usuario10 = new Usuario(10, "Steven");

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);
        usuarios.add(usuario6);
        usuarios.add(usuario7);
        usuarios.add(usuario8);
        usuarios.add(usuario9);
        usuarios.add(usuario10);

        Pelicula pelicula1 = new Pelicula(1, "Inception", Genero.CIENCIA_FICCION, 148);
        Pelicula pelicula2 = new Pelicula(2, "The Dark Knight", Genero.ACCION, 152);
        Pelicula pelicula3 = new Pelicula(3, "Forrest Gump", Genero.DRAMA, 142);
        Pelicula pelicula4 = new Pelicula(4, "The Matrix", Genero.CIENCIA_FICCION, 136);
        Pelicula pelicula5 = new Pelicula(5, "The Godfather", Genero.DRAMA, 175);
        Pelicula pelicula6 = new Pelicula(6, "Pulp Fiction", Genero.COMEDIA, 154);
        Pelicula pelicula7 = new Pelicula(7, "The Shawshank Redemption", Genero.DRAMA, 142);
        Pelicula pelicula8 = new Pelicula(8, "The Conjuring", Genero.TERROR, 112);
        Pelicula pelicula9 = new Pelicula(9, "Get Out", Genero.TERROR, 104);
        Pelicula pelicula10 = new Pelicula(10, "A Quiet Place", Genero.TERROR, 90);
        Pelicula pelicula11 = new Pelicula(11, "Mad Max: Fury Road", Genero.ACCION, 120);
        Pelicula pelicula12 = new Pelicula(12, "John Wick", Genero.ACCION, 101);

        peliculas.add(pelicula1);
        peliculas.add(pelicula2);
        peliculas.add(pelicula3);
        peliculas.add(pelicula4);
        peliculas.add(pelicula5);
        peliculas.add(pelicula6);
        peliculas.add(pelicula7);
        peliculas.add(pelicula8);
        peliculas.add(pelicula9);
        peliculas.add(pelicula10);
        peliculas.add(pelicula11);
        peliculas.add(pelicula12);

        Visualizacion visualizacion1 = new Visualizacion(usuario1, pelicula1, 130);
        Visualizacion visualizacion2 = new Visualizacion(usuario2, pelicula2, 150);
        Visualizacion visualizacion3 = new Visualizacion(usuario3, pelicula3, 140);
        Visualizacion visualizacion4 = new Visualizacion(usuario4, pelicula4, 135);
        Visualizacion visualizacion5 = new Visualizacion(usuario5, pelicula5, 170);
        Visualizacion visualizacion6 = new Visualizacion(usuario6, pelicula6, 150);
        Visualizacion visualizacion7 = new Visualizacion(usuario7, pelicula7, 140);
        Visualizacion visualizacion8 = new Visualizacion(usuario8, pelicula8, 110);
        Visualizacion visualizacion9 = new Visualizacion(usuario9, pelicula9, 100);
        Visualizacion visualizacion10 = new Visualizacion(usuario10, pelicula10, 90);
        Visualizacion visualizacion11 = new Visualizacion(usuario1, pelicula11, 120);
        Visualizacion visualizacion12 = new Visualizacion(usuario2, pelicula12, 101);
        Visualizacion visualizacion13 = new Visualizacion(usuario3, pelicula1, 148);
        Visualizacion visualizacion14 = new Visualizacion(usuario4, pelicula2, 152);
        Visualizacion visualizacion15 = new Visualizacion(usuario5, pelicula3, 142);

        visualizaciones.add(visualizacion1);
        visualizaciones.add(visualizacion2);
        visualizaciones.add(visualizacion3);
        visualizaciones.add(visualizacion4);
        visualizaciones.add(visualizacion5);
        visualizaciones.add(visualizacion6);
        visualizaciones.add(visualizacion7);
        visualizaciones.add(visualizacion8);
        visualizaciones.add(visualizacion9);
        visualizaciones.add(visualizacion10);
        visualizaciones.add(visualizacion11);
        visualizaciones.add(visualizacion12);
        visualizaciones.add(visualizacion13);
        visualizaciones.add(visualizacion14);
        visualizaciones.add(visualizacion15);
    }
}