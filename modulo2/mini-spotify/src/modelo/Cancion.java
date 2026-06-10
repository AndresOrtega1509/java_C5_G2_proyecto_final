package modelo;

public class Cancion extends Multimedia implements Reproducible{
    //Atributo
    private String artista;

    //Constructor
    public Cancion() {
        super();
        this.artista = "Desconocido";
    }

    public Cancion(String titulo, int duracion, String artista){
        super(titulo, duracion);
        this.artista = artista;
    }

    //Getter
    public String getArtista() {
        return artista;
    }
    
    //Setter
    public void setArtista(String artista) {
        this.artista = artista;
    }

    //Implementación del metodo abstracto
    @Override
    public String getInfo() {
        return "Canción: " + getTitulo() + ", Duración: " + getDuracion() + " segundos" + ", Artista: " + this.artista;
    }

    //Implementación polimórfica
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo: " + getInfo());
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo: " + getInfo());
    }

    //Sobreescritura de toString
    @Override
    public String toString() {
        return getInfo();
    }
}
