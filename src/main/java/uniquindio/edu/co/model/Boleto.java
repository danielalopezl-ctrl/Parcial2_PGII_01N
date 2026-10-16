package uniquindio.edu.co.model;

/**
 * Representa un boleto (boleta) cinematográfico individual adquirido en una venta para una función específica.
 * Conserva el código único, la fila, el número de asiento y el valor individual pagado.
 * Corresponde a la clase Boleto del diagrama de clases UML.
 */
public class Boleto {

    // Atributos de la clase Boleto
    private String codigo;
    private String fila;
    private int numeroAsiento;
    private double valorPagado;
    private Funcion funcion;

    /**
     * Constructor de la clase Boleto.
     *
     * @param codigo        Código único del boleto
     * @param fila          Fila del asiento seleccionado
     * @param numeroAsiento Número de columna o asiento dentro de la fila
     * @param valorPagado   Valor individual efectivamente pagado por el boleto
     * @param funcion       Función cinematográfica a la que corresponde el boleto
     */
    public Boleto(String codigo, String fila, int numeroAsiento, double valorPagado, Funcion funcion) {
        this.codigo = codigo;
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
        this.valorPagado = valorPagado;
        this.funcion = funcion;
    }

    /**
     * Retorna el valor individual pagado por el boleto.
     *
     * @return Valor numérico del boleto
     */
    public double calcularValor() {
        return valorPagado;
    }

    /**
     * Valida que los datos del asiento sean válidos (fila no vacía y número de asiento positivo).
     *
     * @return true si los datos del asiento son consistentes, false de lo contrario
     */
    public boolean validarAsientoDisponible() {
        return fila != null && !fila.trim().isEmpty() && numeroAsiento > 0;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return "Boleto #" + codigo + " | Asiento: Fila " + fila + " - Asiento " + numeroAsiento +
               " | Valor pagado: $" + valorPagado;
    }
}
