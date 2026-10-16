package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa una función cinematográfica programada en CinePlus.
 * Asocia una película específica con una sala determinada en una fecha y hora de inicio,
 * definiendo el precio base de la boleta.
 */
public class Funcion {

    // Atributos de la clase Funcion
    private String codigo;
    private LocalDate fechaPresentacion;
    private LocalTime horaInicio;
    private double precioBase;

    // Relaciones
    private Pelicula pelicula;
    private Sala sala;

    /**
     * Constructor de la clase Funcion.
     *
     * @param codigo            Código único identificador de la función
     * @param fechaPresentacion Fecha en la que se llevará a cabo la proyección
     * @param horaInicio        Hora exacta de inicio de la función
     * @param precioBase        Precio base de la boleta para esta función
     * @param pelicula          Película que se proyectará
     * @param sala              Sala asignada para la proyección
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

    /**
     * Convierte la hora de inicio a minutos transcurridos desde el inicio del día (0 a 1439).
     *
     * @return Hora de inicio expresada en minutos
     */
    public int getHoraInicioEnMinutos() {
        return (horaInicio.getHour() * 60) + horaInicio.getMinute();
    }

    /**
     * Calcula el minuto del día en que finaliza la función, considerando la duración de la película.
     *
     * @return Hora estimada de finalización en minutos
     */
    public int getHoraFinEnMinutos() {
        return getHoraInicioEnMinutos() + (pelicula != null ? pelicula.getDuracionMinutos() : 0);
    }

    /**
     * Verifica si esta función presenta un conflicto de horario (superposición o traslape)
     * con otra función en la misma sala y en la misma fecha.
     * Regla matemática: hay traslape si max(inicio1, inicio2) < min(fin1, fin2).
     *
     * @param otra Función a comparar
     * @return true si existe conflicto de horario, false si los horarios no se cruzan
     */
    public boolean hayConflictoHorario(Funcion otra) {
        if (otra == null) return false;
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
     * Calcula el valor individual de una boleta para esta función aplicando
     * el recargo correspondiente al tipo de sala (Tradicional 0%, 3D 20%, VIP 30%).
     *
     * @return Precio de la boleta con recargo de sala incluido (antes de descuentos de cliente)
     */
    public double calcularPrecioBoleta() {
        double recargo = (sala != null) ? sala.calcularRecargo() : 0.0;
        return precioBase * (1.0 + recargo);
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Funcion #" + codigo + " | Fecha: " + fechaPresentacion +
               " | Inicio: " + horaInicio +
               " | Pelicula: " + (pelicula != null ? pelicula.getTitulo() : "N/A") +
               " | Sala: " + (sala != null ? sala.getNombre() : "N/A") +
               " | Precio Base: $" + precioBase;
    }
}
