package com.devsenior.andres.ui;

import java.util.Scanner;
import com.devsenior.andres.service.AnalyticsService;

public class ConsoleUI {
    private AnalyticsService analyticsService;
    private Scanner sc;

    public ConsoleUI(AnalyticsService analyticsService){
        this.analyticsService = analyticsService;
        this.sc = new Scanner(System.in);
    }

    public void iniciar(){
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    analyticsService.mostrarPeliculasMasVistas().   
                    forEach(e -> System.out.println(e.getKey().getTitulo() + " -> " + e.getValue() + " visualizaciones"));
                    break;
                case 2:
                    analyticsService.agruparPeliculasPorGenero().forEach(p -> 
                    {
                        System.out.print("\n" + p.getKey() + " -> ");
                        p.getValue().forEach(n -> {
                            System.out.print(n.getTitulo() + " | ");
                        });
                    });
                    break;
                case 3:
                    analyticsService.obtenerTiempoTotalVistoPorUsuario()
                            .forEach((usuario, tiempo) -> System.out.println(usuario.getNombre() + " -> " + tiempo + " minutos"));
                    break;
                case 4:
                    int[] posicion = {1};
                    analyticsService.obtenerTopUsuariosVisualizacionesPeliculas()
                                    .forEach(u -> {
                                        System.out.println(posicion[0] + ". " + u.getKey().getNombre() 
                                        + " -> " + u.getValue() + " minutos");
                                        posicion[0]++; 
                                    });
                    break;
                case 5:
                    analyticsService.obtenerPromedioDuracionPeliculasPorGenero()
                                    .forEach((genero, duracion) -> System.out.println(genero + " -> " + duracion + " minutos"));
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Ingrese una opción valida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void mostrarMenu(){
        String menu = """
                === NETFLIX ANALYTICS ===
                1. Peliculas mas vistas
                2. Peliculas por genero
                3. Tiempo total visto por usuario
                4. Top usuarios
                5. Promedio duracion por genero
                0. Salir 
                """;
        System.out.print("\n" + menu);
        System.out.print("Ingrese una opcion: ");
    }
}