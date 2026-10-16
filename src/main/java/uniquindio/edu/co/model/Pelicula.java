package uniquindio.edu.co.model;

public class Pelicula {
    private String codigo;
    private String titulo;
    private int duracionMinutos;
    private Genero genero;
    private String clasificacion;

    public Pelicula(String codigo, String titulo, int duracionMinutos, Genero genero, String clasificacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.clasificacion = clasificacion;
    }

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
        return "Pelicula{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                ", genero=" + genero +
                ", clasificacion='" + clasificacion + '\'' +
                '}';
    }
}

