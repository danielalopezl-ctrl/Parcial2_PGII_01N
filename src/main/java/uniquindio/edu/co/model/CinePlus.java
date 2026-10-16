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



}
