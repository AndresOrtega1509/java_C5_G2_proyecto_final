package modelo;

public class BibliotecaMusical {
    //Atributo
    private Cancion[] catalogo;
    // Atributos auxiliares del arreglo
    private int contadorCatalogo;
    private int maxCatalogo;

    //Constructor
    public BibliotecaMusical(int maxCatalogo){
        this.maxCatalogo = maxCatalogo;
        this.catalogo = new Cancion[maxCatalogo];
        this.contadorCatalogo = 0;
    }

    //Getter
    public int getMaxCatalogo() {
        return maxCatalogo;
    }
    
    //Metodos
    // Agregación
    public void agregarCancion(Cancion c) {
        if (contadorCatalogo < maxCatalogo) {
            catalogo[contadorCatalogo] = c;
            contadorCatalogo++;
            System.out.println("Se ha agregado la canción: " + c.getTitulo() + ", al catalogo");
        } else {
            System.out.println("No se puede agregar la canción: " +
                    c.getTitulo() +
                    ", el catalogo está lleno");
        }
    }

    public Cancion buscarPorNombre(String nombre){
        for(int i = 0 ; i < contadorCatalogo ; i++){
            if (catalogo[i].getTitulo().equalsIgnoreCase(nombre)) {
                return catalogo[i];
            }
        }
        System.out.println("Canción no encontrada con el nombre: " + nombre);
        return null;
    }

    public void listarCatalogo() {
        Cancion cancionInicial = catalogo[0];
        if (cancionInicial != null) {
            for (int i = 0; i < contadorCatalogo; i++) {
                    System.out.println((i + 1) + ". " + catalogo[i].getInfo());
            }
        } else {
            System.out.println("El catalogo está vacio.");
        }
    }

    public Cancion obtenerCancionIndice(int index){
        if (index >= 0 && index < contadorCatalogo) {
            return catalogo[index];
        } else {
            System.out.println("Índice fuera de rango. No se puede obtener la canción.");
            return null;
        }
    }

    public void eliminarCancionDeBiblioteca(int indice){
        if (obtenerCancionIndice(indice) != null) {
            for (int i = indice; i < contadorCatalogo - 1; i++) {
                catalogo[i] = catalogo[i + 1];
            }
            catalogo[contadorCatalogo - 1] = null;
            contadorCatalogo--;
            System.out.println("Canción eliminada correctamente.");
        }
    }

}
