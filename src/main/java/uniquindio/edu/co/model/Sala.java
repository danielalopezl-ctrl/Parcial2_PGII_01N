package uniquindio.edu.co.model;


public class Sala {

    private int numero;
    private String nombre;
    private TipoSala tipo;
    private int capacidadMaxima;
    private int filas;
    private int columnas;
    private TipoSala tiposalas;

    public Sala(int numero, String nombre, TipoSala tipo, int capacidadMaxima, int filas, int columnas, TipoSala[] tipos) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
        this.filas = filas;
        this.columnas = columnas;
        this.tiposalas = tiposalas;
    }

    // Devuelve el recargo según el tipo de sala
    public double calcularRecargo() {
        if (tipo == TipoSala.Vip) {
            return 0.30; // 30%
        } else if (tipo == TipoSala.Sala_3D) {
            return 0.20; // 20%
        }
        return 0.0; // Tradicional no tiene recargo
    }

    public boolean validarCapacidad() {
        return capacidadMaxima > 0 && capacidadMaxima <= (filas * columnas);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", capacidadMaxima=" + capacidadMaxima +
                ", filas=" + filas +
                ", columnas=" + columnas +
                '}';
    }
}


