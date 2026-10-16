package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private double porcentajeDescuento;
    private LocalDate fechaRegistro;
    private String codigoAfiliacion;

    // Relación bidireccional opcional con sus compras
    private List<Venta> compras;

    /**
     * Metodo constructor
     * @param documento del cliente
     * @param nombreCompleto del cliente
     * @param correo del cliente
     * @param telefono del cliente
     * @param codigoAfiliacion del cliente
     * @param porcentajeDescuento del cliente
     * @param fechaRegistro del cliente
     */
    public Cliente(String documento, String nombreCompleto, String correo, String telefono,
                   String codigoAfiliacion, double porcentajeDescuento, LocalDate fechaRegistro) {
        super(documento, nombreCompleto, correo, telefono); // Llama al constructor de Persona
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaRegistro = fechaRegistro != null ? fechaRegistro : LocalDate.now();
        this.compras = new ArrayList<>();
    }

    /**
     * metodo para calcular porcentaje de descuento
     * @return
     */
    public double calcularDescuento() {
        return porcentajeDescuento / 100.0;
    }

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
}
