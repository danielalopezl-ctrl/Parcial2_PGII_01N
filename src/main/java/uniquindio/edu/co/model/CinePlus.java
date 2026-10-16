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

    public Cineplus (String nombreComercial, String nit, String direccion) {
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
     *
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

    public boolean registrarCliente(String documento, String nombre, String correo, String telefono, String codigoAlfanumerico, double porcentajeDescuento, LocalDate fechaRegistro) {
        if (buscarCliente(documento) != null) {
            return false;
        }
        Cliente nuevo = new Cliente(documento, nombre, correo, telefono, codigoAfiliacion, porcentajeDescuento, fechaRegistro);
        clientes.add(nuevo);
        return true;
    }

    public Cliente buscarCliente(String documento) {
        for (Cliente c : clientes) {
            if (c.getDocumento().equalsIgnoreCase(documento)) return c;
        }
        return null;
    }

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
}
