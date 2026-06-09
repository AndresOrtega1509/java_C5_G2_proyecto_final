package app;

import modelo.Cancion;
import modelo.Playlist;

public class App {
    public static void main(String[] args) {
        Cancion cancion1 = new Cancion("Triller", 180, "Mike");
        Cancion cancion2 = new Cancion("La dama", 90, "Pipe");

        Playlist playlist = new Playlist("Bad", 2);

        playlist.agregarCancion(cancion1);
        playlist.agregarCancion(cancion2);
        playlist.reproducirCancion(2);
        
    }
}
