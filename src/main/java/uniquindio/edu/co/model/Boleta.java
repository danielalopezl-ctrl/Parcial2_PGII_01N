package uniquindio.edu.co.model;

public class Boleta {

    private String codigo;
    private String fila;
    private int numeroAsiento;
    private double valorPagado;
    private Funcion funcion;

    public Boleta (String codigo, String fila, int numeroAsiento, double valorPagado, Funcion funcion) {
        this.codigo = codigo;
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
        this.valorPagado = valorPagado;
        this.funcion = funcion;
    }

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
        return "Boleta{" +
                "codigo='" + codigo + '\'' +
                ", fila='" + fila + '\'' +
                ", numeroAsiento=" + numeroAsiento +
                ", valorPagado=" + valorPagado +
                ", funcion=" + funcion +
                '}';
    }
}


