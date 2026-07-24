package com.devsenior.andres.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.devsenior.andres.model.Genero;
import com.devsenior.andres.model.Pelicula;
import com.devsenior.andres.model.Usuario;
import com.devsenior.andres.model.Visualizacion;
import com.devsenior.andres.repository.DataRepository;

public class AnalyticsService {
    private DataRepository dataRepository;

    public AnalyticsService(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    public List<Map.Entry<Pelicula, Long>> mostrarPeliculasMasVistas(){
        var resultado = dataRepository.visualizaciones
                            .stream()
                            .collect(Collectors.groupingBy(Visualizacion::getPelicula, Collectors.counting()))
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.<Pelicula, Long>comparingByValue().reversed())
                            .toList();
        return resultado;             
    }

    public List<Map.Entry<Genero, List<Pelicula>>> agruparPeliculasPorGenero() {
        var resultado = dataRepository.peliculas
                            .stream()
                            .collect(Collectors.groupingBy(Pelicula::getGenero))
                            .entrySet()
                            .stream()
                            .toList();
        return resultado;
    }

    public Map<Usuario, Integer> obtenerTiempoTotalVistoPorUsuario(){
        var resultado = dataRepository.visualizaciones
                      .stream()
                      .collect(Collectors.groupingBy(u -> u.getUsuario(), 
                               Collectors.summingInt(Visualizacion::getMinutosVistos)));
        return resultado;
    }

    public List<Map.Entry<Usuario, Integer>> obtenerTopUsuariosVisualizacionesPeliculas(){
        var resultado = obtenerTiempoTotalVistoPorUsuario()
                      .entrySet()
                      .stream()
                      .sorted(Map.Entry.<Usuario, Integer>comparingByValue().reversed())
                      .limit(3)
                      .toList();
        return resultado;
    }

    public Map<Genero, Double> obtenerPromedioDuracionPeliculasPorGenero(){
        var resultado = dataRepository.peliculas
                                      .stream()
                                      .collect(Collectors.groupingBy(Pelicula::getGenero, 
                                        Collectors.averagingInt(Pelicula::getDuracion)));
        return resultado;
    }
}