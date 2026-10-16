package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un cliente del complejo cinematográfico CinePlus.
 * Extiende de Persona incorporando su código de afiliación y el porcentaje de descuento
 * aplicable a todas sus compras de boletas.
 */
public class Cliente extends Persona {

    // Atributos específicos del Cliente
    private double porcentajeDescuento;
    private LocalDate fechaRegistro;
    private String codigoAfiliacion;

    // Relación bidireccional con las ventas realizadas por el cliente
    private List<Venta> compras;

    /**
     * Constructor de la clase Cliente.
     *
     * @param documento           Documento de identidad del cliente
     * @param nombreCompleto      Nombre completo del cliente
     * @param correo              Correo electrónico de contacto
     * @param telefono            Número telefónico de contacto
     * @param codigoAfiliacion    Código único de afiliado otorgado por CinePlus
     * @param porcentajeDescuento Porcentaje de descuento para sus compras (ej. 10.0 para 10%)
     * @param fechaRegistro       Fecha de inscripción del cliente
     */
    public Cliente(String documento, String nombreCompleto, String correo, String telefono,
                   String codigoAfiliacion, double porcentajeDescuento, LocalDate fechaRegistro) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaRegistro = fechaRegistro != null ? fechaRegistro : LocalDate.now();
        this.compras = new ArrayList<>();
    }

    /**
     * Retorna el factor decimal del porcentaje de descuento.
     * Ejemplo: para 10% retorna 0.10.
     *
     * @return Factor decimal del descuento
     */
    public double calcularDescuento() {
        return porcentajeDescuento / 100.0;
    }

    /**
     * Retorna el listado de ventas asociadas a este cliente.
     *
     * @return Lista de compras realizadas
     */
    public List<Venta> consultarCompras() {
        return compras;
    }

    /**
     * Registra una nueva compra en el historial del cliente.
     *
     * @param venta Venta realizada
     */
    public void agregarCompra(Venta venta) {
        if (venta != null) {
            this.compras.add(venta);
        }
    }

    // Getters y Setters
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public List<Venta> getCompras() {
        return compras;
    }

    public void setCompras(List<Venta> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() +
               ", afiliacion='" + codigoAfiliacion + '\'' +
               ", descuento=" + porcentajeDescuento + "%" +
               ", fechaRegistro=" + fechaRegistro + '}';
    }
}
