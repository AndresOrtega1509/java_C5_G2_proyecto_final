package app;

import modelo.BibliotecaMusical;
import modelo.Cancion;
import modelo.CuentaSpotify;
import modelo.Playlist;
import java.util.Scanner;

public class SpotifyApp {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        CuentaSpotify cuenta1 = crearCuentaSpotify("Andres01", "123", 100, 4);
        //Crear canciones de prueba
        Cancion cancion1 = new Cancion("Traicion", 240, "Romeo");
        Cancion cancion2 = new Cancion("Fiesta", 200, "Arcangel");
        Cancion cancion3 = new Cancion("Baile", 220, "Maluma");

        //Crear playlist de prueba
        Playlist playlist1 = new Playlist("Favoritos", 10);
        Playlist playlist2 = new Playlist("Populares", 5);

        //Agregar canciones a la biblioteca musical (catalogo)
        cuenta1.agregarCancionABiblioteca(cancion1);
        cuenta1.agregarCancionABiblioteca(cancion2);
        cuenta1.agregarCancionABiblioteca(cancion3);

        // Iniciar sesión en la cuenta de spotify
        cuenta1.iniciarSesion("Andres01", "123");

        //Agregar playlist a la cuenta de spotify
        cuenta1.agregarPlaylist(playlist1);

        //Agregar canción a playlist
        cuenta1.agregarCancionAPlaylist("Favoritos", cancion1);

        // Cerrar sesión
        cuenta1.cerrarSesion();

        // Simulación de interacción con el usuario a través de la consola
        int opcionMenuPrincipal;

        do {
            mostrarMenuPrincipal();
            opcionMenuPrincipal = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcionMenuPrincipal) {
                case 1:
                    // Iniciar sesión
                    System.out.print("Ingrese su usuario: ");
                    String usuario = scanner.next();
                    System.out.print("Ingrese su contraseña: ");
                    String password = scanner.next();
                    scanner.nextLine(); // Limpiar buffer
                    cuenta1.iniciarSesion(usuario, password);
                    break;
                case 2:
                    // Gestionar biblioteca musical
                    int opcionMenuBiblioteca;
                    do {
                        mostrarMenuBiblioteca();
                        opcionMenuBiblioteca = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        switch (opcionMenuBiblioteca) {
                            case 1:
                                // Listar canciones de la biblioteca (catalogo)
                                cuenta1.getBiblioteca().listarCatalogo();
                                break;
                            case 2:
                                // Agregar nueva canción a la biblioteca (catalogo)
                                System.out.print("Ingrese el título de la canción: ");
                                String titulo = scanner.nextLine();
                                System.out.print("Ingrese el artista de la canción: ");
                                String artista = scanner.nextLine();
                                System.out.print("Ingrese la duración de la canción en segundos: ");
                                int duracion = scanner.nextInt();
                                scanner.nextLine(); // Limpiar buffer
                                Cancion nuevaCancion = new Cancion(titulo, duracion, artista);
                                cuenta1.getBiblioteca().agregarCancion(nuevaCancion);
                                break;
                            case 3:
                                // Buscar canción por nombre
                                System.out.print("Ingrese el nombre de la canción a buscar: ");
                                String nombreCancion = scanner.nextLine();
                                Cancion cancionEncontrada = cuenta1.getBiblioteca().buscarPorNombre(nombreCancion);
                                if (cancionEncontrada != null) {
                                    System.out.println("Canción encontrada: " + cancionEncontrada.getInfo());
                                }
                                break;
                            case 4:
                                // Eliminar canción del catalogo
                                System.out.println("-- Canciones en la biblioteca --");
                                cuenta1.getBiblioteca().listarCatalogo();
                                System.out.print("Ingrese el número de la canción a eliminar de la biblioteca: ");
                                int numCancion = scanner.nextInt();
                                scanner.nextLine(); // Limpiar buffer
                                cuenta1.eliminarCancionDeBiblioteca(numCancion - 1);
                                break;
                            case 5:
                                // Volver al menú principal
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    }while (opcionMenuBiblioteca != 5);
                    break;
                case 3:
                    // Gestionar playlists
                    int opcionMenuPlaylists;
                    do {
                        mostrarMenuPlaylists();
                        opcionMenuPlaylists = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        switch (opcionMenuPlaylists) {
                            case 1:
                                // Crear nueva playlist
                                System.out.print("Ingrese el nombre de la nueva playlist: ");
                                String nombrePlaylist = scanner.nextLine();
                                System.out.print("Ingrese la capacidad máxima de canciones para la playlist: ");
                                int capacidadPlaylist = scanner.nextInt();
                                scanner.nextLine(); // Limpiar buffer
                                Playlist nuevaPlaylist = new Playlist(nombrePlaylist, capacidadPlaylist);
                                cuenta1.agregarPlaylist(nuevaPlaylist);
                                break;
                        
                            case 2:
                                // Listar playlists del usuario
                                cuenta1.listarPlaylists();
                                break;

                            case 3:
                                // Agregar canción a playlist
                                System.out.print("Ingrese el nombre de la playlist: ");
                                String nombre = scanner.nextLine();
                                System.out.println("-- Canciones en la biblioteca --");
                                cuenta1.getBiblioteca().listarCatalogo();
                                System.out.print("Ingrese el número de la canción a agregar a la playlist: ");
                                int numCancion = scanner.nextInt();
                                scanner.nextLine(); // Limpiar buffer
                                Cancion cancionSeleccionada = cuenta1.getBiblioteca().obtenerCancionIndice(numCancion - 1);
                                if (cancionSeleccionada != null) {
                                    cuenta1.agregarCancionAPlaylist(nombre, cancionSeleccionada);
                                } 
                                break;

                            case 4:
                                // Listar canciones de una playlist
                                System.out.print("Ingrese el nombre de la playlist: ");
                                String nombrePlaylistVer = scanner.nextLine();
                                Playlist playlistEncontrada = cuenta1.buscarPlaylist(nombrePlaylistVer);
                                System.out.println("-- Canciones en la playlist --");
                                playlistEncontrada.listarCanciones();
                                break;
                            
                            case 5:
                                // Volver al menú principal
                                break;

                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }while (opcionMenuPlaylists != 5);
                    break;
                case 4:
                    // Reproducir canciones
                    int opcionMenuReproduccion;
                    do {
                        mostrarMenuReproduccion();
                        opcionMenuReproduccion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        switch (opcionMenuReproduccion) {
                            case 1:
                                // Reproducir canción desde playlist
                                System.out.print("Ingrese el nombre de la playlist: ");
                                String nombrePlaylistReproducir = scanner.nextLine();
                                Playlist playlistReproducir = cuenta1.buscarPlaylist(nombrePlaylistReproducir);
                                System.out.println("-- Canciones en la playlist --");
                                if (playlistReproducir != null) {
                                    playlistReproducir.listarCanciones();
                                    System.out.print("Ingrese el número de la canción a reproducir: ");
                                    int numCancionReproducir = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar buffer
                                    cuenta1.reproducir(nombrePlaylistReproducir, numCancionReproducir - 1);
                                } else {
                                    System.out.println("No se encontró una playlist con el nombre: " + nombrePlaylistReproducir);
                                }
                                break;

                            case 2:
                                // Detener reproducción de canción
                                System.out.print("Ingrese el nombre de la playlist: ");
                                String nombrePlaylistDetener = scanner.nextLine();
                                Playlist playlistDetener = cuenta1.buscarPlaylist(nombrePlaylistDetener);
                                System.out.println("-- Canciones en la playlist --");
                                if (playlistDetener != null) {
                                    playlistDetener.listarCanciones();
                                    System.out.print("Ingrese el número de la canción a detener: ");
                                    int numCancionDetener = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar buffer
                                    cuenta1.detener(nombrePlaylistDetener, numCancionDetener - 1);
                                } else {
                                    System.out.println("No se encontró una playlist con el nombre: " + nombrePlaylistDetener);
                                }
                                break;

                            case 3:
                                // Volver al menú principal
                                break;

                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    } while (opcionMenuReproduccion != 3);
                    break;
                case 5:
                    // Cerrar sesión
                    cuenta1.cerrarSesion();
                    break;
                case 6:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionMenuPrincipal != 6);

        scanner.close();
    }

    public static void mostrarMenuPrincipal(){
        String menu = """
                === MINI-SPOTIFY ===
                1. Iniciar sesión
                2. Gestionar Biblioteca Musical
                3. Gestionar Playlists
                4. Reproducir Canciones
                5. Cerrar sesión
                6. Salir del programa
                """;
        System.out.print(menu);
        System.out.print("Ingrese la opción deseada: ");
    }

    public static void mostrarMenuBiblioteca(){
        String menu = """
                === GESTIONAR BIBLIOTECA MUSICAL ===
                1. Listar canciones
                2. Agregar canción
                3. Buscar canción por nombre
                4. Eliminar canción
                5. Volver al menú principal
                """;
        System.out.print(menu);
        System.out.print("Ingrese la opción deseada: ");
    }

    public static void mostrarMenuPlaylists(){
        String menu = """
                === GESTIONAR PLAYLISTS ===
                1. Crear playlist
                2. Listar playlists
                3. Agregar canción a playlist
                4. Ver canciones
                5. Volver al menú principal
                """;
        System.out.print(menu);
        System.out.print("Ingrese la opción deseada: ");
    }

    public static void mostrarMenuReproduccion(){
        String menu = """
                === REPRODUCIR CANCIONES ===
                1. Reproducir canción desde playlist
                2. Detener reproducción de canción
                3. Volver al menú principal
                """;
        System.out.print(menu);
        System.out.print("Ingrese la opción deseada: ");
    }

    public static CuentaSpotify crearCuentaSpotify(String usuario, String password, int maxPlaylists, int capacidadBiblioteca){
        CuentaSpotify nuevCuentaSpotify = new CuentaSpotify(usuario, password, maxPlaylists, capacidadBiblioteca);
        return nuevCuentaSpotify;
    }
}
