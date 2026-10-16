package uniquindio.edu.co.model;

/**
 * Record que representa de forma inmutable el reporte de ocupación de una función cinematográfica.
 * Agrupa los asientos vendidos y la capacidad máxima de la sala para calcular el porcentaje de ocupación.
 * Corresponde al concepto de «record» de POO visto en las diapositivas de clase (06/10/2026).
 *
 * @param asientosVendidos Cantidad de boletas vendidas para la función
 * @param capacidadSala    Capacidad máxima de espectadores de la sala
 */
public record RegistroOcupacion(int asientosVendidos, int capacidadSala) {

    /**
     * Calcula el porcentaje de ocupación de la función (0.0% a 100.0%).
     *
     * @return Porcentaje de ocupación calculado
     */
    public double calcularPorcentaje() {
        if (capacidadSala <= 0) {
            return 0.0;
        }
        return ((double) asientosVendidos / capacidadSala) * 100.0;
    }
}