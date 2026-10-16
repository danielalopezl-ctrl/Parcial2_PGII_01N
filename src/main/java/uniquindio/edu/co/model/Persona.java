package uniquindio.edu.co.model;

/**
 * Clase abstracta que modela los datos y comportamientos comunes de cualquier
 * persona vinculada con la operación de CinePlus (clientes y operarios).
 */
public abstract class Persona {

    // Atributos base de toda Persona
    private String documento;
    private String nombreCompleto;
    private String correo;
    private String telefono;

    /**
     * Constructor de la clase abstracta Persona.
     *
     * @param documento      Documento de identidad
     * @param nombreCompleto Nombre completo de la persona
     * @param correo         Correo electrónico de contacto
     * @param telefono       Número telefónico de contacto
     */
    public Persona(String documento, String nombreCompleto, String correo, String telefono) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
    }

    /**
     * Valida que el documento de identidad no sea nulo ni vacío.
     *
     * @return true si el documento es válido, false en caso contrario
     */
    public boolean validarDocumento() {
        return documento != null && !documento.trim().isEmpty();
    }

    /**
     * Permite actualizar la información básica de contacto de la persona.
     *
     * @param nombreCompleto Nuevo nombre completo
     * @param correo         Nuevo correo electrónico
     * @param telefono       Nuevo número telefónico
     */
    public void actualizarDatos(String nombreCompleto, String correo, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "documento='" + documento + "', nombre='" + nombreCompleto +
               "', correo='" + correo + "', telefono='" + telefono + "'";
    }
}
