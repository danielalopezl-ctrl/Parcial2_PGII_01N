package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal controladora del dominio para la empresa CinePlus (Armenia, Quindío).
 * Administra el catálogo de películas, las salas de proyección, el registro de clientes y operarios,
 * la programación de funciones cinematográficas y la venta de boletas.
 * Implementa las 6 funcionalidades requeridas en el Parcial 2.
 */
public class CinePlus {

    // Atributos de la empresa
    private String nombreComercial;
    private String nit;
    private String direccion;

    // Relaciones (Colecciones administradas por CinePlus)
    private List<Sala> listSalas;
    private List<Pelicula> listPeliculas;
    private List<Cliente> clientes;
    private List<Operador> operadores;
    private List<Funcion> listFunciones;
    private List<Venta> listVentas;

    /**
     * Constructor de la clase CinePlus.
     *
     * @param nombreComercial Nombre comercial del complejo de cines
     * @param nit             Número de Identificación Tributaria (NIT)
     * @param direccion       Dirección física de ubicación
     */
    public CinePlus(String nombreComercial, String nit, String direccion) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.listSalas = new ArrayList<>();
        this.listPeliculas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.operadores = new ArrayList<>();
        this.listFunciones = new ArrayList<>();
        this.listVentas = new ArrayList<>();
    }

    // =========================================================================
    // FUNCIONALIDAD 1: Registrar películas
    // Permitir agregar películas al catálogo cinematográfico, verificando que
    // no exista otra película con el mismo código.
    // =========================================================================
    /**
     * Registra una nueva película en el catálogo de CinePlus validando la unicidad del código.
     *
     * @param codigo        Código único de la película
     * @param titulo        Título de la película
     * @param duracion      Duración en minutos
     * @param genero        Género cinematográfico
     * @param clasificacion Clasificación por edad
     * @return true si la película fue registrada exitosamente, false si ya existe el código
     */
    public boolean registrarPelicula(String codigo, String titulo, int duracion, Genero genero, String clasificacion) {
        if (buscarPelicula(codigo) != null) {
            return false; // Error: código duplicado
        }
        Pelicula nueva = new Pelicula(codigo, titulo, duracion, genero, clasificacion);
        listPeliculas.add(nueva);
        return true;
    }

    /**
     * Busca una película en el catálogo por su código único.
     *
     * @param codigo Código de la película a buscar
     * @return La película encontrada o null si no existe
     */
    public Pelicula buscarPelicula(String codigo) {
        for (Pelicula p : listPeliculas) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    // =========================================================================
    // FUNCIONALIDAD 2: Registrar clientes y operarios
    // Permitir agregar clientes al sistema, verificando que no existan
    // documentos de identidad duplicados.
    // =========================================================================
    /**
     * Registra un cliente en el sistema verificando que no exista otra persona con el mismo documento.
     *
     * @param documento           Documento de identidad único
     * @param nombre              Nombre completo del cliente
     * @param correo              Correo electrónico
     * @param telefono            Número de teléfono
     * @param codigoAfiliacion    Código de afiliación a CinePlus
     * @param porcentajeDescuento Porcentaje de descuento para compras (ej. 10.0)
     * @param fechaRegistro       Fecha de registro en el sistema
     * @return true si se registró exitosamente, false si el documento ya existe
     */
    public boolean registrarCliente(String documento, String nombre, String correo, String telefono,
                                    String codigoAfiliacion, double porcentajeDescuento, LocalDate fechaRegistro) {
        if (buscarCliente(documento) != null || buscarOperador(documento) != null) {
            return false; // Error: documento ya registrado
        }
        Cliente nuevo = new Cliente(documento, nombre, correo, telefono, codigoAfiliacion, porcentajeDescuento, fechaRegistro);
        clientes.add(nuevo);
        return true;
    }

    /**
     * Busca un cliente registrado por su documento de identidad.
     *
     * @param documento Documento a buscar
     * @return El Cliente encontrado o null si no existe
     */
    public Cliente buscarCliente(String documento) {
        for (Cliente c : clientes) {
            if (c.getDocumento().equalsIgnoreCase(documento)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Registra un operario de taquilla en el sistema verificando documento único.
     *
     * @param documento         Documento de identidad único
     * @param nombre            Nombre completo
     * @param correo            Correo electrónico
     * @param telefono          Número de teléfono
     * @param codigoEmpleado    Código único de empleado
     * @param fechaContratacion Fecha de contratación
     * @param salario           Salario básico asignado
     * @return true si se registró exitosamente, false si el documento ya existe
     */
    public boolean registrarOperador(String documento, String nombre, String correo, String telefono,
                                     String codigoEmpleado, LocalDate fechaContratacion, double salario) {
        if (buscarOperador(documento) != null || buscarCliente(documento) != null) {
            return false; // Error: documento ya registrado
        }
        Operador nuevo = new Operador(documento, nombre, correo, telefono, codigoEmpleado, fechaContratacion, salario);
        operadores.add(nuevo);
        return true;
    }

    /**
     * Busca un operario registrado por su documento de identidad.
     *
     * @param documento Documento a consultar
     * @return El Operador encontrado o null si no existe
     */
    public Operador buscarOperador(String documento) {
        for (Operador op : operadores) {
            if (op.getDocumento().equalsIgnoreCase(documento)) {
                return op;
            }
        }
        return null;
    }

    /**
     * Agrega una sala de proyección a la lista de salas disponibles de CinePlus.
     *
     * @param sala Sala a agregar
     */
    public void agregarSala(Sala sala) {
        if (sala != null && buscarSala(sala.getNumero()) == null) {
            listSalas.add(sala);
        }
    }

    /**
     * Busca una sala de proyección por su número identificador.
     *
     * @param numero Número de la sala
     * @return La Sala encontrada o null si no existe
     */
    public Sala buscarSala(int numero) {
        for (Sala s : listSalas) {
            if (s.getNumero() == numero) {
                return s;
            }
        }
        return null;
    }

    // =========================================================================
    // FUNCIONALIDAD 3: Programar funciones cinematográficas
    // Permitir registrar funciones asociadas a una película y una sala,
    // verificando que no existan conflictos de horarios en una misma sala.
    // =========================================================================
    /**
     * Programa una función cinematográfica validando que la sala y película existan,
     * que el código sea único y que sus horarios no se superpongan con otra función en la misma sala.
     *
     * @param codigo         Código único de la función
     * @param fecha          Fecha de la función
     * @param horaInicio     Hora de inicio de la proyección
     * @param precioBase     Precio base de la boleta
     * @param codigoPelicula Código de la película a proyectar
     * @param numeroSala     Número de la sala donde se proyectará
     * @return true si la función fue programada exitosamente, false si hubo conflicto de horario o error
     */
    public boolean programarFuncion(String codigo, LocalDate fecha, LocalTime horaInicio,
                                    double precioBase, String codigoPelicula, int numeroSala) {
        if (buscarFuncion(codigo) != null) {
            return false; // Error: código de función repetido
        }

        Pelicula peli = buscarPelicula(codigoPelicula);
        Sala sala = buscarSala(numeroSala);

        if (peli == null || sala == null) {
            return false; // Error: película o sala no existen
        }

        Funcion nueva = new Funcion(codigo, fecha, horaInicio, precioBase, peli, sala);

        // Validar que no exista superposición de horario en la misma sala y fecha
        for (Funcion f : listFunciones) {
            if (nueva.hayConflictoHorario(f)) {
                return false; // Conflicto detectado en la sala
            }
        }

        listFunciones.add(nueva);
        return true;
    }

    /**
     * Busca una función cinematográfica programada por su código único.
     *
     * @param codigo Código de la función a consultar
     * @return La Funcion encontrada o null si no existe
     */
    public Funcion buscarFuncion(String codigo) {
        for (Funcion f : listFunciones) {
            if (f.getCodigo().equalsIgnoreCase(codigo)) {
                return f;
            }
        }
        return null;
    }

    // =========================================================================
    // FUNCIONALIDAD 4: Realizar ventas de boletas
    // Permitir registrar una venta para un cliente, seleccionando una función
    // y una o varias boletas, verificando asientos no ocupados y calculando el
    // valor de cada boleta considerando el tipo de sala y el descuento del cliente.
    // =========================================================================
    /**
     * Registra una venta de una o varias boletas para una función cinematográfica específica.
     * Valida que los asientos seleccionados no estén ocupados para esa función,
     * calcula el valor de cada boleta con recargo de sala y descuento de cliente,
     * y genera la venta con sus boletas asociadas.
     *
     * @param codigoVenta          Código único de la venta
     * @param fecha                Fecha y hora de realización de la venta
     * @param docCliente           Documento de identidad del cliente comprador
     * @param docOperador          Documento de identidad del operario que atiende en taquilla
     * @param codFuncion           Código de la función cinematográfica
     * @param asientosSeleccionados Lista de pares [fila, numeroAsiento]
     * @return La Venta registrada o null si hubo algún error en la validación
     */
    public Venta registrarVenta(String codigoVenta, LocalDateTime fecha, String docCliente,
                                String docOperador, String codFuncion, List<String[]> asientosSeleccionados) {

        if (buscarVenta(codigoVenta) != null) {
            return null; // Error: código de venta duplicado
        }

        Cliente cli = buscarCliente(docCliente);
        Operador op = buscarOperador(docOperador);
        Funcion fun = buscarFuncion(codFuncion);

        if (cli == null || op == null || fun == null || asientosSeleccionados == null || asientosSeleccionados.isEmpty()) {
            return null; // Datos requeridos faltantes
        }

        // 1. Validar que ninguno de los asientos esté ocupado para ESTA función
        for (String[] asiento : asientosSeleccionados) {
            String fila = asiento[0];
            int num;
            try {
                num = Integer.parseInt(asiento[1]);
            } catch (NumberFormatException e) {
                return null;
            }

            if (isAsientoOcupado(codFuncion, fila, num)) {
                return null; // Error: asiento ya ocupado en esta función
            }
        }

        // 2. Calcular valor individual de cada boleta según recargo de sala y descuento del cliente
        // "El valor de cada boleta depende del precio base establecido para la función y del tipo de sala.
        // Adicionalmente, cuando un cliente cuenta con descuento, este se aplica después del recargo."
        double precioConRecargo = fun.calcularPrecioBoleta();
        double valorIndividual = precioConRecargo * (1.0 - cli.calcularDescuento());

        // 3. Crear la venta y asociar las boletas
        Venta venta = new Venta(codigoVenta, fecha, cli, op);
        int consecutivo = 1;
        for (String[] asiento : asientosSeleccionados) {
            String codBoleto = codigoVenta + "-B" + (consecutivo++);
            Boleto b = new Boleto(codBoleto, asiento[0], Integer.parseInt(asiento[1]), valorIndividual, fun);
            venta.agregarBoleto(b);
        }

        listVentas.add(venta);
        cli.agregarCompra(venta);
        return venta;
    }

    /**
     * Verifica si un asiento (fila y número) ya ha sido vendido para una función cinematográfica determinada.
     * Garantiza que un mismo asiento no sea vendido más de una vez para la misma función.
     *
     * @param codFuncion   Código de la función
     * @param fila         Fila del asiento
     * @param numeroAsiento Número de asiento dentro de la fila
     * @return true si el asiento ya se encuentra ocupado en esa función, false si está disponible
     */
    public boolean isAsientoOcupado(String codFuncion, String fila, int numeroAsiento) {
        for (Venta v : listVentas) {
            for (Boleto b : v.getBoletos()) {
                if (b.getFuncion() != null &&
                    b.getFuncion().getCodigo().equalsIgnoreCase(codFuncion) &&
                    b.getFila().equalsIgnoreCase(fila) &&
                    b.getNumeroAsiento() == numeroAsiento) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Busca una venta por su código único.
     *
     * @param codigo Código de la venta a consultar
     * @return La Venta encontrada o null si no existe
     */
    public Venta buscarVenta(String codigo) {
        for (Venta v : listVentas) {
            if (v.getCodigo().equalsIgnoreCase(codigo)) {
                return v;
            }
        }
        return null;
    }

    // =========================================================================
    // FUNCIONALIDAD 5: Calcular el valor total de una venta
    // Permitir consultar una venta mediante su código y calcular el valor total
    // sumando los valores individuales de las boletas adquiridas.
    // =========================================================================
    /**
     * Calcula el valor total de una venta sumando los valores individuales de sus boletas.
     *
     * @param venta Objeto Venta a calcular
     * @return El valor total sumado de la venta, o 0.0 si la venta es nula
     */
    public double calcularTotalVenta(Venta venta) {
        if (venta == null) return 0.0;
        return venta.calcularTotal();
    }

    /**
     * Consulta una venta por código y calcula su valor total sumado.
     *
     * @param codigoVenta Código de la venta
     * @return Valor total de la venta o -1.0 si la venta no fue encontrada
     */
    public double calcularTotalVentaPorCodigo(String codigoVenta) {
        Venta v = buscarVenta(codigoVenta);
        if (v != null) {
            return v.calcularTotal();
        }
        return -1.0;
    }

    // =========================================================================
    // FUNCIONALIDAD 6: Calcular el porcentaje de ocupación de una función
    // Permitir consultar una función y determinar su porcentaje de ocupación a
    // partir de la cantidad de boletas vendidas y la capacidad máxima de la sala.
    // Implementa el «record» RegistroOcupacion según las diapositivas de clase.
    // =========================================================================
    /**
     * Determina el porcentaje de ocupación de una función cinematográfica
     * a partir de la cantidad de boletas vendidas y la capacidad máxima de la sala.
     *
     * @param funcion Función cinematográfica a evaluar
     * @return Porcentaje de ocupación (0.0% a 100.0%)
     */
    public double calcularPorcentajeOcupacion(Funcion funcion) {
        if (funcion == null || funcion.getSala() == null) return 0.0;

        int boletosVendidos = 0;
        for (Venta v : listVentas) {
            for (Boleto b : v.getBoletos()) {
                if (b.getFuncion() != null && b.getFuncion().getCodigo().equalsIgnoreCase(funcion.getCodigo())) {
                    boletosVendidos++;
                }
            }
        }

        int capacidad = funcion.getSala().getCapacidadMaxima();
        // Uso del record RegistroOcupacion para estructurar el reporte de ocupación
        RegistroOcupacion registro = new RegistroOcupacion(boletosVendidos, capacidad);
        return registro.calcularPorcentaje();
    }

    /**
     * Consulta una función por código y retorna su porcentaje de ocupación.
     *
     * @param codigoFuncion Código de la función
     * @return Porcentaje de ocupación o -1.0 si la función no existe
     */
    public double calcularPorcentajeOcupacionPorCodigo(String codigoFuncion) {
        Funcion f = buscarFuncion(codigoFuncion);
        if (f != null) {
            return calcularPorcentajeOcupacion(f);
        }
        return -1.0;
    }

    // =========================================================================
    // Consultas generales del catálogo y la infraestructura
    // =========================================================================
    public List<Sala> consultarSalas() {
        return listSalas;
    }

    public List<Pelicula> consultarPeliculasDisponibles() {
        return listPeliculas;
    }

    public List<Funcion> consultarFunciones() {
        return listFunciones;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Operador> getOperadores() {
        return operadores;
    }

    public List<Venta> getListVentas() {
        return listVentas;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }
}
