package modelo;

public class Playlist {
    //Atributos
    private String nombre;
    private Cancion[] canciones;
    //Atributos auxiliares del arreglo
    private int contadorCanciones;
    private int maxCanciones; //Representa la longitud del arreglo canciones

    //Constructor
    public Playlist(String nombre, int maxCanciones){
        this.nombre = nombre;
        this.maxCanciones = maxCanciones;
        this.canciones = new Cancion[maxCanciones];
        this.contadorCanciones = 0;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxCanciones() {
        return maxCanciones;
    }

    //Metodos:
    //Agregación
    public void agregarCancion(Cancion c){
        if (contadorCanciones < maxCanciones) {
            canciones[contadorCanciones] = c;
            contadorCanciones++;
        }else{
            System.out.println("No se puede agregar la canción: " + 
            c.getTitulo() + 
            ", ya se alcanzó el limite de canciones para esta playlist");
        }
    }

    //Sobrecarga + composición
    public void agregarCancion(String titulo, String artista, int duracion) {
        Cancion nuevaCancion = new Cancion(titulo, duracion, artista);
        if (contadorCanciones < maxCanciones) {
            canciones[contadorCanciones] = nuevaCancion;
            contadorCanciones++;
        } else {
            System.out.println("No se puede agregar la canción: " +
                    nuevaCancion.getTitulo() +
                    ", ya se alcanzó el limite de canciones para esta playlist");
        }
    }

    public void listarCanciones(){
        Cancion cancionInicial = canciones[0];
        if (cancionInicial != null) {
            System.out.println("Playlist: " + this.nombre);
            int contadorNumCancion = 0;
            for (Cancion cancion : canciones) {
                if (cancion != null) {
                    System.out.println((contadorNumCancion + 1) + ". " + cancion.getInfo());
                    contadorNumCancion++;
                }else{
                    break;
                }
            }
        }else{
            System.out.println("No hay canciones para listar.");
        }
    }

    public void reproducirCancion(int index){
        if (index >= 0 && index < contadorCanciones) {
            Cancion cancion = canciones[index];
            System.out.println("Reproduciendo: " + cancion.getInfo());
        }else{
            System.out.println("Índice de canción inválido");
        }
    }

    public boolean estaLlena(){
        return contadorCanciones >= maxCanciones;
    }

    
}
