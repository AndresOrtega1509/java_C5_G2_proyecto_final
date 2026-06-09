package modelo;

public abstract class Multimedia {
    //Atributos proteguidos
    private String titulo;
    private int duracion; //Segundos

    //Constructores
    public Multimedia(){
        this.titulo = "Desconocido";
        this.duracion = 0;
    }

    public Multimedia(String titulo){
        this.titulo = titulo;
        this.duracion = 0;
    }

    public Multimedia(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    //Getters
    public String getTitulo(){
        return this.titulo;
    }

    public int getDuracion() {
        return this.duracion;
    }

    //Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDuracionSegundos(int duracion) {
        this.duracion = duracion;
    }

    //Este metodo es abstracto y debe ser implementado por las subclases
    public abstract String getInfo();
}
