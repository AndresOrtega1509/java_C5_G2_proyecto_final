package modelo;

public class CuentaSpotify {
    //Atributos
    private String usuario;
    private String password;
    private Playlist[] playlists;
    private BibliotecaMusical biblioteca;
    private boolean sesionIniciada;
    // Atributos auxiliares del arreglo
    private int contadorPlaylists;
    private int maxPlaylists; // Representa la longitud del arreglo playlists
    private int capacidadBiblioteca; // Representa la longitud del arreglo catalogo

    //Constructor
    public CuentaSpotify(String usuario, String password, int maxPlaylists, int capacidadBiblioteca){
        this.usuario = usuario;
        this.password = password;
        this.sesionIniciada = false;
        this.maxPlaylists = maxPlaylists;
        this.playlists = new Playlist[maxPlaylists];
        this.capacidadBiblioteca = capacidadBiblioteca;
        this.biblioteca = new BibliotecaMusical(capacidadBiblioteca);
        this.contadorPlaylists = 0;
    }

    //Getters and Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }

    public BibliotecaMusical getBiblioteca() {
        return biblioteca;
    }

    //Metodos
    public void iniciarSesion(String usuario, String password){
        if (this.usuario.equals(usuario) && this.password.equals(password)) {
            this.sesionIniciada = true;
            System.out.println("Inicio de sesion exitoso");
        }else{
            System.out.println("Las credenciales son incorrectas");
        }
    }

    public void agregarPlaylist(Playlist p) {
        if (sesionIniciada) {
            if (contadorPlaylists < maxPlaylists) {
                playlists[contadorPlaylists] = p;
                contadorPlaylists++;
                System.out.println("La playlist: " + p.getNombre() + ", se ha creado correctamente");
            } else {
                System.out.println("No se puede agregar la playlist: " +
                        p.getNombre() +
                        ", capacidad maxima alcanzada.");
            }
        }else{
            System.out.println("Inicie sesión para agregar la playlist.");
        }
    }

    public void agregarCancionAPlaylist(String playlist, Cancion c){
        if (sesionIniciada) {
            Playlist playlistEncontrada = buscarPlaylist(playlist);
            if (playlistEncontrada != null) {
                playlistEncontrada.agregarCancion(c);
            }else{
                System.out.println("No se encontró una playlist con el nombre: " + playlist);
            }   
        }else{
            System.out.println("Inicie sesión para agregar la canción a la playlist.");
        }
    }

    public void reproducir(String playlist, int indexCancion){
        if (sesionIniciada) {
            Playlist playlistEncontrada = buscarPlaylist(playlist);
            if (playlistEncontrada != null) {
                    playlistEncontrada.reproducirCancion(indexCancion);
            }else{
                System.out.println("No se encontró una playlist con el nombre: " + playlist);
            }
        }else{
            System.out.println("Inicie sesión para reproducir la canción.");
        }
    }

    public void detener(String playlist, int indexCancion) {
        if (sesionIniciada) {
            Playlist playlistEncontrada = buscarPlaylist(playlist);
            if (playlistEncontrada != null) {
                playlistEncontrada.detenerCancion(indexCancion);
            } else {
                System.out.println("No se encontró una playlist con el nombre: " + playlist);
            }
        } else {
            System.out.println("Inicie sesión para detener la canción.");
        }
    }

    public void cerrarSesion(){
        this.sesionIniciada = false;
        System.out.println("Se ha cerrado la sesión");
    }

    public Playlist buscarPlaylist(String nombrePlaylist){
        for(int i = 0 ; i < contadorPlaylists ; i++){
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlaylist)) {
                return playlists[i];
            }
        }
        return null;
    }

    public void listarPlaylists() {
        Playlist playlistInicial = playlists[0];
        if (playlistInicial != null) {
            for (int i = 0; i < contadorPlaylists; i++) {
                System.out.println((i + 1) + ". " + playlists[i].getInfo());
            }
        } else {
            System.out.println("No hay playlists para listar.");
        }
    }

    public void agregarCancionABiblioteca(Cancion cancion){
        biblioteca.agregarCancion(cancion);
    }

    public void eliminarCancionDeBiblioteca(int indice){
        biblioteca.eliminarCancionDeBiblioteca(indice);
    }
    
}
