package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {

    private String codigo;
    private LocalDate fechaPresentacion;
    private LocalTime horaInicio;
    private double precioBase;

    // Relaciones
    private Pelicula pelicula;
    private Sala sala;

    /**
     * Metodo constructor
     * @param codigo de la funcion
     * @param fechaPresentacion de la funcion
     * @param horaInicio de la funcion
     * @param precioBase de la funcion
     * @param pelicula de la funcion
     * @param sala de la funcion
     */

    public Funcion(String codigo, LocalDate fechaPresentacion, LocalTime horaInicio,
                   double precioBase, Pelicula pelicula, Sala sala) {
        this.codigo = codigo;
        this.fechaPresentacion = fechaPresentacion;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.pelicula = pelicula;
        this.sala = sala;
    }

    // Minuto de inicio dentro del día (0 a 1439)
    public int getHoraInicioEnMinutos() {
        return (horaInicio.getHour() * 60) + horaInicio.getMinute();
    }

    /**
     * metodo para conocer la hora de finalizacion del a funcion
     * @return
     */
    public int getHoraFinEnMinutos() {
        return getHoraInicioEnMinutos() + pelicula.getDuracionMinutos();
    }

    /**
     * metodo para saber si hay conflicto de horarios
     * @param otra .
     * @return
     */


    public boolean hayConflictoHorario(Funcion otra) {
        // Deben ser el mismo día y en la misma sala
        if (!this.fechaPresentacion.equals(otra.fechaPresentacion)) {
            return false;
        }
        if (this.sala.getNumero() != otra.sala.getNumero()) {
            return false;
        }

        int ini1 = this.getHoraInicioEnMinutos();
        int fin1 = this.getHoraFinEnMinutos();
        int ini2 = otra.getHoraInicioEnMinutos();
        int fin2 = otra.getHoraFinEnMinutos();

        return Math.max(ini1, ini2) < Math.min(fin1, fin2);
    }

    /**
     * metodo para calcular el precio de la boleta + el recargo de la sala
     * @return
     */

    // Calcula el precio de la boleta con el recargo de la sala (antes del descuento de cliente)
    public double calcularPrecioBoleta() {
        double recargo = sala.calcularRecargo();
        return precioBase * (1.0 + recargo);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public LocalDate getFechaPresentacion() { return fechaPresentacion; }
    public void setFechaPresentacion(LocalDate fechaPresentacion) { this.fechaPresentacion = fechaPresentacion; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }


    @Override
    public String toString() {
        return "Funcion{" +
                "codigo='" + codigo + '\'' +
                ", fechaPresentacion=" + fechaPresentacion +
                ", horaInicio=" + horaInicio +
                ", precioBase=" + precioBase +
                ", pelicula=" + pelicula +
                ", sala=" + sala +
                '}';
    }
}
