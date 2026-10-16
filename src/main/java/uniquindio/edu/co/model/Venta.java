package uniquindio.edu.co.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una venta de boletas realizada en taquilla por un operario a un cliente.
 * Cada venta pertenece a una función cinematográfica específica y contiene una o varias boletas.
 * El valor total se calcula sumando los valores individuales de las boletas adquiridas.
 */
public class Venta {

    // Atributos de la clase Venta
    private String codigo;
    private LocalDateTime fecha;
    private Cliente cliente;
    private Operador operador;
    private List<Boleto> boletos;

    /**
     * Constructor de la clase Venta.
     *
     * @param codigo   Código único identificador de la venta
     * @param fecha    Fecha y hora de realización de la venta
     * @param cliente  Cliente que adquiere las boletas
     * @param operador Operario de taquilla responsable del registro de la venta
     */
    public Venta(String codigo, LocalDateTime fecha, Cliente cliente, Operador operador) {
        this.codigo = codigo;
        this.fecha = fecha != null ? fecha : LocalDateTime.now();
        this.cliente = cliente;
        this.operador = operador;
        this.boletos = new ArrayList<>();
    }

    /**
     * Agrega una boleta a la lista de boletas adquiridas en esta venta.
     *
     * @param boleto Boleta individual a asociar
     */
    public void agregarBoleto(Boleto boleto) {
        this.boletos.add(boleto);
    }

    /**
     * Calcula la suma de los valores base con recargo de todas las boletas de la venta
     * antes de aplicar el descuento personal del cliente.
     *
     * @return Valor numérico del subtotal
     */
    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (Boleto b : boletos) {
            if (b.getFuncion() != null) {
                subtotal += b.getFuncion().calcularPrecioBoleta();
            } else {
                subtotal += b.getValorPagado();
            }
        }
        return subtotal;
    }

    /**
     * Calcula el monto en dinero correspondiente al descuento del cliente aplicado sobre el subtotal.
     *
     * @return Valor monetario del descuento otorgado
     */
    public double calcularDescuento() {
        if (cliente == null) return 0.0;
        return calcularSubtotal() * cliente.calcularDescuento();
    }

    /**
     * Calcula el valor total de la venta sumando los valores individuales pagados de todas las boletas adquiridas.
     * Cumple con el requerimiento 5 del parcial.
     *
     * @return Valor total a pagar por la venta
     */
    public double calcularTotal() {
        double total = 0.0;
        for (Boleto b : boletos) {
            total += b.getValorPagado();
        }
        return total;
    }

    // Getters y Setters
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
        return "Venta #" + codigo + " | Fecha: " + fecha +
               " | Cliente: " + (cliente != null ? cliente.getNombreCompleto() : "N/A") +
               " | Operador: " + (operador != null ? operador.getNombreCompleto() : "N/A") +
               " | Boletas: " + boletos.size() +
               " | Total pagado: $" + calcularTotal();
    }
}
