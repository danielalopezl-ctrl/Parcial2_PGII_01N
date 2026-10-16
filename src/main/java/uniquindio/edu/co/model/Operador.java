package uniquindio.edu.co.model;

import java.time.LocalDate;

public class Operador extends Persona {

    private LocalDate fechaContratacion;
    private double salario;
    private String codigoEmpleado;

    /**
     * Metodo constructor
     * @param documento del operador
     * @param nombreCompleto del operador
     * @param correo del operador
     * @param telefono del operador
     * @param codigoEmpleado del operador
     * @param fechaContratacion del operador
     * @param salario del operador
     */
    public Operador(String documento, String nombreCompleto, String correo, String telefono,
                    String codigoEmpleado, LocalDate fechaContratacion, double salario) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return "Operador{" +
                "fechaContratacion=" + fechaContratacion +
                ", salario=" + salario +
                ", codigoEmpleado='" + codigoEmpleado + '\'' +
                '}';
    }
}