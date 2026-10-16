package uniquindio.edu.co.model;

/**
 * Representa una sala de proyección del complejo cinematográfico CinePlus.
 * Contiene información de su capacidad máxima, distribución de asientos en filas y columnas,
 * y su tipo (Tradicional, VIP o 3D) para el cálculo de recargos.
 */
public class Sala {

    // Atributos de la clase Sala
    private int numero;
    private String nombre;
    private TipoSala tipo;
    private int capacidadMaxima;
    private int filas;
    private int columnas;

    /**
     * Constructor de la clase Sala.
     *
     * @param numero          Número identificador de la sala
     * @param nombre          Nombre descriptivo de la sala
     * @param tipo            Tipo de sala (TRADICIONAL, VIP, SALA_3D)
     * @param capacidadMaxima Capacidad máxima de espectadores permitidos
     * @param filas           Cantidad de filas de asientos
     * @param columnas        Cantidad de columnas de asientos
     */
    public Sala(int numero, String nombre, TipoSala tipo, int capacidadMaxima, int filas, int columnas) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
        this.filas = filas;
        this.columnas = columnas;
    }

    /**
     * Calcula el porcentaje de recargo aplicable al precio base de la boleta
     * según el tipo de sala donde se realiza la proyección.
     * - Tradicional: 0 % de recargo
     * - VIP: 30 % de recargo (+0.30)
     * - 3D: 20 % de recargo (+0.20)
     *
     * @return El porcentaje de recargo en formato decimal (0.0, 0.20 o 0.30)
     */
    public double calcularRecargo() {
        if (tipo == TipoSala.VIP) {
            return 0.30; // 30% de recargo
        } else if (tipo == TipoSala.SALA_3D) {
            return 0.20; // 20% de recargo
        }
        return 0.0; // Tradicional mantiene el precio base
    }

    /**
     * Valida que la capacidad máxima sea consistente con las filas y columnas configuradas.
     *
     * @return true si la capacidad es válida, false en caso contrario
     */
    public boolean validarCapacidad() {
        return capacidadMaxima > 0 && capacidadMaxima <= (filas * columnas);
    }

    // Getters y Setters
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
        return "Sala #" + numero + " - " + nombre + " (" + tipo + "), Capacidad: " + capacidadMaxima +
               " [" + filas + " filas x " + columnas + " columnas]";
    }
}
