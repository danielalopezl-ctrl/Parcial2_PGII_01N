package uniquindio.edu.co.model;

    public abstract class Persona {

        private String documento;
        private String nombreCompleto;
        private String correo;
        private String telefono;

        /**
         * Metodo constructor
         * @param documento de la persona
         * @param nombreCompleto de la persona
         * @param correo de la persona
         * @param telefono de la persona
         */
        public Persona(String documento, String nombreCompleto, String correo, String telefono) {
            this.documento = documento;
            this.nombreCompleto = nombreCompleto;
            this.correo = correo;
            this.telefono = telefono;
        }

        public boolean validarDocumento() {
            return documento != null && !documento.trim().isEmpty();
        }

        public void actualizarDatos(String nombreCompleto, String correo, String telefono) {
            this.nombreCompleto = nombreCompleto;
            this.correo = correo;
            this.telefono = telefono;
        }

        // Getters y Setters
        public String getDocumento() { return documento; }
        public void setDocumento(String documento) { this.documento = documento; }

        public String getNombreCompleto() { return nombreCompleto; }
        public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        @Override
        public String toString() {
            return "documento='" + documento + "', nombre='" + nombreCompleto + "'";
        }
    }
