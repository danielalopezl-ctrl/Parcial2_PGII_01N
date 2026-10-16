package uniquindio.edu.co.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta {

    private String codigo;
    private LocalDateTime fecha;
    private Cliente cliente;
    private Operador operador;
    private List<Boleto> boletos;

    /**
     * metodo constructor
     * @param codigo de la venta
     * @param fecha de la venta
     * @param cliente de la venta
     * @param operador de la venta
     */

    public Venta(String codigo, LocalDateTime fecha, Cliente cliente, Operador operador) {
        this.codigo = codigo;
        this.fecha = fecha != null ? fecha : LocalDateTime.now();
        this.cliente = cliente;
        this.operador = operador;
        this.boletos = new ArrayList<>();
    }

    public void agregarBoleto(Boleto boleto) {
        this.boletos.add(boleto);
    }

    /**
     * Metodo para la suma de los precio de las boletas con el recargo antes del descuento
     * @return
     */

    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (Boleto b : boletos) {
            // El precio de la boleta con recargo de la sala
            subtotal += b.getFuncion().calcularPrecioBoleta();
        }
        return subtotal;
    }

    /**
     * metodo para calcular el monto ahorrado por el descuento del cliente
     * @return
     */

    public double calcularDescuento() {
        if (cliente == null) return 0.0;
        return calcularSubtotal() * cliente.calcularDescuento();
    }

    /**
     * metodo para calcular el valor final pagado por la venta
     * @return
     */

    public double calcularTotal() {
        double total = 0.0;
        for (Boleto b : boletos) {
            total += b.getValorPagado();
        }
        return total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", operador=" + operador +
                ", boletos=" + boletos +
                '}';
    }
}
