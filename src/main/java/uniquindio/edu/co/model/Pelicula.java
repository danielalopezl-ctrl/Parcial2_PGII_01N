package uniquindio.edu.co.model;

/**
 * Representa una película del catálogo cinematográfico administrado por CinePlus.
 * Conserva el código único, título, duración en minutos, género y clasificación por edad.
 */
public class Pelicula {

    // Atributos de la clase Pelicula
    private String codigo;
    private String titulo;
    private int duracionMinutos;
    private Genero genero;
    private String clasificacion;

    /**
     * Constructor de la clase Pelicula.
     *
     * @param codigo          Código único identificador de la película
     * @param titulo          Título de la película
     * @param duracionMinutos Duración en minutos de la película
     * @param genero          Género cinematográfico (ACCION, COMEDIA, DRAMA, TERROR, ANIMACION)
     * @param clasificacion   Clasificación por edad (ej. "Todo público", "Mayores de 12", "+18")
     */
    public Pelicula(String codigo, String titulo, int duracionMinutos, Genero genero, String clasificacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.clasificacion = clasificacion;
    }

    /**
     * Permite actualizar la información básica de la película.
     *
     * @param titulo          Nuevo título
     * @param duracionMinutos Nueva duración en minutos
     * @param genero          Nuevo género
     * @param clasificacion   Nueva clasificación por edad
     */
    public void actualizarDatos(String titulo, int duracionMinutos, Genero genero, String clasificacion) {
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.clasificacion = clasificacion;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "Pelicula #" + codigo + " | Título: '" + titulo + '\'' +
               " | Duración: " + duracionMinutos + " min | Género: " + genero +
               " | Clasificación: " + clasificacion;
    }
}
