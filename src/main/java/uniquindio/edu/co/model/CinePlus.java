package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CinePlus {
    private String nombreComercial;
    private String nit;
    private String direccion;

    private List<Sala> listSalas;
    private List<Pelicula> listPeliculas;
    private List<Cliente> clientes;
    private List<Funcion> listFunciones;
    private List<Venta> listVentas;

    public Cineplus(String nombreComercial, String nit, String direccion) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.listSalas = new ArrayList<>();
        this.listPeliculas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.listFunciones = new ArrayList<>();
        this.listVentas = new ArrayList<>();
    }

    /**
     * Registrar Peliculas
     * @param codigo
     * @param titulo
     * @param duracion
     * @param genero
     * @param clasificacion
     * @return
     */
    public boolean registrarPelicula(String codigo, String titulo, int duracion, Genero genero, String clasificacion) {
        if (buscarPelicula(codigo) != null) {
            return false;
        }
        Pelicula nueva = new Pelicula(codigo, titulo, duracion, genero, clasificacion);
        listPeliculas.add(nueva);
        return true;
    }

    /**
     * Metodo Constructor para Registrar Clientes
     * @param documento de Clientes
     * @param nombre de Clientes
     * @param correo de Clientes
     * @param telefono de Clientes
     * @param codigoAlfanumerico de Clientes
     * @param porcentajeDescuento de Clientes
     * @param fechaRegistro de Clientes
     * @return
     */

    public boolean registrarCliente(String documento, String nombre, String  correo, String telefono,
                                    String codigoAlfanumerico, double porcentajeDescuento, LocalDate fechaRegistro) {
        if (buscarCliente(documento) != null){
            return false;
        }
        Cliente nuevo = new Cliente(documento, nombre, correo, telefono, codigoAfiliacion, porcentajeDescuento, fechaRegistro);
        clientes.add(nuevo);
        return true;
    }

    /**
     * Buscar Cliente
     * @param documento de Cliente
     * @return
     */
    public Cliente buscarCliente(String documento) {
        for (Cliente c : clientes) {
            if (c.getDocumento().equalsIgnoreCase(documento)) return c;
        }
        return null;
    }

    /**
     * Metod para Registar Operador
     * @param documento de Operador
     * @param nombre de Operador
     * @param correo de Operador
     * @param telefono de Operador
     * @param codigoEmpleado de Operador
     * @param fechaContratacion de Operador
     * @param salario de Operador
     * @return
     */
    public boolean registrarOperador(String documento, String nombre, String correo, String telefono,
                                     String codigoEmpleado, LocalDate fechaContratacion, double salario) {
        if (buscarOperador(documento) != null) {
            return false;
        }
        Operador nuevo = new Operador(documento, nombre, correo, telefono, codigoEmpleado, fechaContratacion, salario);
        operadores.add(nuevo);
        return true;
    }
    public Operador buscarOperador(String documento) {
        for (Operador op : operadores) {
            if (op.getDocumento().equalsIgnoreCase(documento)) return op;
        }
        return null;
    }
    public void agregarSala(Sala sala) {
        listSalas.add(sala);
    }
    public Sala buscarSala(int numero) {
        for (Sala s : listSalas) {
            if (s.getNumero() == numero) return s;
        }
        return null;
    }

    /**
     * Metodo para programar funcion
     * @param codigo de funcion
     * @param fecha de funcion
     * @param horaInicio de funcion
     * @param precioBase de funcion
     * @param codigoPelicula de funcion
     * @param numeroSala de funcion
     * @return
     */
    public boolean programarFuncion(String codigo, LocalDate fecha, LocalTime horaInicio,
                                    double precioBase, String codigoPelicula, int numeroSala) {
        if (buscarFuncion(codigo) != null) {
            return false;
        }
        Pelicula peli = buscarPelicula(codigoPelicula);
        Sala sala = buscarSala(numeroSala);
        if (peli == null || sala == null) {
            return false;
        }
        Funcion nueva = new Funcion(codigo, fecha, horaInicio, precioBase, peli, sala);
        // Verificar que no choque con funciones existentes en esa sala
        for (Funcion f : listFunciones) {
            if (nueva.hayConflictoHorario(f)) {
                return false;
            }
        }
        listFunciones.add(nueva);
        return true;
    }
    public Funcion buscarFuncion(String codigo) {
        for (Funcion f : listFunciones) {
            if (f.getCodigo().equalsIgnoreCase(codigo)) return f;
        }
        return null;
    }

    /**
     * Metodo para Realizar venta de Boletas
     * @param codigoVenta de Boletas
     * @param fecha de Boletas
     * @param docCliente para Boletas
     * @param docOperador que vendio la Boletas
     * @param codFuncion de Boletas
     * @param asientosSeleccionados según compra Boletas
     * @return
     */
    public Venta registrarVenta(String codigoVenta, LocalDateTime fecha, String docCliente,
                                String docOperador, String codFuncion, List<String[]> asientosSeleccionados) {
        if (buscarVenta(codigoVenta) != null) return null;
        Cliente cli = buscarCliente(docCliente);
        Operador op = buscarOperador(docOperador);
        Funcion fun = buscarFuncion(codFuncion);
        if (cli == null || op == null || fun == null || asientosSeleccionados == null || asientosSeleccionados.isEmpty()) {
            return null;
        }
        // 1. Validar que ningún asiento seleccionado ya esté vendido para ESTA función
        for (String[] asiento : asientosSeleccionados) {
            String fila = asiento[0];
            int num = Integer.parseInt(asiento[1]);
            if (isAsientoOcupado(codFuncion, fila, num)) {
                return null; // Asiento ocupado
            }
        }
        // 2. Calcular precio unitario con recargo y con descuento de cliente
        double precioConRecargo = fun.calcularPrecioBoleta();
        double valorIndividual = precioConRecargo * (1.0 - cli.calcularDescuento());
        // 3. Crear venta y agregar boletos
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
    public boolean isAsientoOcupado(String codFuncion, String fila, int numeroAsiento) {
        for (Venta v : listVentas) {
            for (Boleto b : v.getBoletos()) {
                if (b.getFuncion().getCodigo().equalsIgnoreCase(codFuncion) &&
                        b.getFila().equalsIgnoreCase(fila) &&
                        b.getNumeroAsiento() == numeroAsiento) {
                    return true;
                }
            }
        }
        return false;
    }
    public Venta buscarVenta(String codigo) {
        for (Venta v : listVentas) {
            if (v.getCodigo().equalsIgnoreCase(codigo)) return v;
        }
        return null;
    }

    /**
     * Metodo para calcular Total de Venta
     * @param venta
     * @return
     */
    public double calcularTotalVenta(Venta venta) {
        if (venta == null) return 0.0;
        return venta.calcularTotal();
    }

    /**
     * Metodo para calcular porcentaje de ocupacion con el record
     * @param funcion
     * @return
     */
    public double calcularPorcentajeOcupacion(Funcion funcion) {
        if (funcion == null) return 0.0;
        int boletosVendidos = 0;
        for (Venta v : listVentas) {
            for (Boleto b : v.getBoletos()) {
                if (b.getFuncion().getCodigo().equalsIgnoreCase(funcion.getCodigo())) {
                    boletosVendidos++;
                }
            }
        }
        int capacidad = funcion.getSala().getCapacidadMaxima();
        // Uso del record RegistroOcupacion
        RegistroOcupacion registro = new RegistroOcupacion(boletosVendidos, capacidad);
        return registro.calcularPorcentaje();
    }
    // Getters de colecciones
    public List<Sala> consultarSalas() { return listSalas; }
    public List<Pelicula> consultarPeliculasDisponibles() { return listPeliculas; }
    public List<Funcion> consultarFunciones() { return listFunciones; }
    public List<Cliente> getClientes() { return clientes; }
    public List<Operador> getOperadores() { return operadores; }
    public List<Venta> getListVentas() { return listVentas; }

}
