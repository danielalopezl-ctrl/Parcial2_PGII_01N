package uniquindio.edu.co.model;

public record RegistroOcupacion(int asientosVendidos, int capacidadSala) {

    // Método para calcular el porcentaje de ocupación
    public double calcularPorcentaje() {
        if (capacidadSala <= 0) {
            return 0.0;
        }
        return ((double) asientosVendidos / capacidadSala) * 100.0;
    }
}