package uniquindio.edu.co.model;

import java.time.LocalDate;

/**
 * Representa a un operario de taquilla del complejo cinematográfico CinePlus.
 * Extiende de Persona incorporando su código de empleado, fecha de contratación y salario básico.
 * Es el responsable directo de registrar las ventas en el sistema.
 */
public class Operador extends Persona {

    // Atributos específicos del Operador
    private LocalDate fechaContratacion;
    private double salario;
    private String codigoEmpleado;

    /**
     * Constructor de la clase Operador.
     *
     * @param documento         Documento de identidad del operario
     * @param nombreCompleto    Nombre completo del operario
     * @param correo            Correo electrónico corporativo o personal
     * @param telefono          Número telefónico de contacto
     * @param codigoEmpleado    Código único identificador del empleado
     * @param fechaContratacion Fecha de inicio de labores en CinePlus
     * @param salario           Salario básico asignado
     */
    public Operador(String documento, String nombreCompleto, String correo, String telefono,
                    String codigoEmpleado, LocalDate fechaContratacion, double salario) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    // Getters y Setters
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
        return "Operador{" + super.toString() +
               ", codEmpleado='" + codigoEmpleado + '\'' +
               ", fechaContratacion=" + fechaContratacion +
               ", salario=$" + salario + '}';
    }
}