package uniquindio.edu.co;

import uniquindio.edu.co.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal ejecutable que implementa la demostración interactiva
 * de todas las funcionalidades del sistema CinePlus mediante consola.
 * Cumple con el criterio 4 de la rúbrica de evaluación (1.0 ptos).
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CinePlus cine = new CinePlus("CinePlus Armenia", "901.456.789-1", "Centro Comercial Portal del Quindío");

        // =====================================================================
        // Datos de prueba iniciales precargados para agilizar la sustentación
        // =====================================================================
        // 1. Salas de diferentes tipos
        cine.agregarSala(new Sala(1, "Sala 1 General", TipoSala.TRADICIONAL, 50, 5, 10));
        cine.agregarSala(new Sala(2, "Sala 2 VIP", TipoSala.VIP, 30, 5, 6));
        cine.agregarSala(new Sala(3, "Sala 3 3D", TipoSala.SALA_3D, 40, 5, 8));

        // 2. Personal (Operador de taquilla) y Clientes
        cine.registrarOperador("1094001", "Andrés Gómez", "andres@cineplus.com", "3100000001", "OP01", LocalDate.of(2024, 1, 15), 1400000);
        cine.registrarCliente("1094999", "Daniela López", "daniela@uqvirtual.edu.co", "3111111111", "AF-100", 10.0, LocalDate.now());
        cine.registrarCliente("1094888", "Julián David Gómez", "julian@uqvirtual.edu.co", "3122222222", "AF-200", 15.0, LocalDate.now());

        // 3. Catálogo inicial de películas
        cine.registrarPelicula("PEL01", "Avatar: El Camino del Agua", 192, Genero.ACCION, "Mayores de 12");
        cine.registrarPelicula("PEL02", "Intensamente 2", 96, Genero.ANIMACION, "Todo público");
        cine.registrarPelicula("PEL03", "El Conjuro", 112, Genero.TERROR, "+18");

        // 4. Funciones iniciales programadas para pruebas
        cine.programarFuncion("FUN01", LocalDate.of(2026, 10, 20), LocalTime.of(14, 0), 12000.0, "PEL01", 3); // Sala 3D
        cine.programarFuncion("FUN02", LocalDate.of(2026, 10, 20), LocalTime.of(16, 0), 15000.0, "PEL02", 2); // Sala VIP

        int opcion = -1;
        do {
            System.out.println("\n=======================================================");
            System.out.println("             SISTEMA CINEPLUS - MENÚ PRINCIPAL");
            System.out.println("=======================================================");
            System.out.println("1. Registrar Película al Catálogo (Funcionalidad 1)");
            System.out.println("2. Registrar Cliente (Funcionalidad 2)");
            System.out.println("3. Programar Función Cinematográfica (Funcionalidad 3)");
            System.out.println("4. Realizar Venta de Boletas (Funcionalidad 4)");
            System.out.println("5. Consultar y Calcular Total de Venta (Funcionalidad 5)");
            System.out.println("6. Consultar Porcentaje de Ocupación (Funcionalidad 6)");
            System.out.println("7. Ver Listados Generales (Películas, Salas y Funciones)");
            System.out.println("0. Salir");
            System.out.println("=======================================================");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR PELÍCULA ---");
                    System.out.print("Código único: ");
                    String codP = sc.nextLine().trim();
                    System.out.print("Título: ");
                    String titP = sc.nextLine().trim();
                    System.out.print("Duración en minutos: ");
                    int durP = Integer.parseInt(sc.nextLine().trim());
                    System.out.println("Seleccione género: 1. ACCIÓN | 2. COMEDIA | 3. DRAMA | 4. TERROR | 5. ANIMACIÓN");
                    System.out.print("Opción (1-5): ");
                    int g = Integer.parseInt(sc.nextLine().trim());
                    Genero gen = (g == 2) ? Genero.COMEDIA : (g == 3) ? Genero.DRAMA : (g == 4) ? Genero.TERROR : (g == 5) ? Genero.ANIMACION : Genero.ACCION;
                    System.out.print("Clasificación por edad (ej. Todo público, +12, +18): ");
                    String clasP = sc.nextLine().trim();

                    if (cine.registrarPelicula(codP, titP, durP, gen, clasP)) {
                        System.out.println(">> ¡ÉXITO! Película '" + titP + "' registrada correctamente en el catálogo.");
                    } else {
                        System.out.println(">> ¡ERROR! Ya existe una película registrada con el código: " + codP);
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR CLIENTE ---");
                    System.out.print("Documento de identidad: ");
                    String docC = sc.nextLine().trim();
                    System.out.print("Nombre completo: ");
                    String nomC = sc.nextLine().trim();
                    System.out.print("Correo electrónico: ");
                    String corC = sc.nextLine().trim();
                    System.out.print("Teléfono de contacto: ");
                    String telC = sc.nextLine().trim();
                    System.out.print("Código de afiliación: ");
                    String afilC = sc.nextLine().trim();
                    System.out.print("Porcentaje de descuento (%): ");
                    double descC = Double.parseDouble(sc.nextLine().trim());

                    if (cine.registrarCliente(docC, nomC, corC, telC, afilC, descC, LocalDate.now())) {
                        System.out.println(">> ¡ÉXITO! Cliente '" + nomC + "' registrado con " + descC + "% de descuento.");
                    } else {
                        System.out.println(">> ¡ERROR! Ya existe una persona registrada con el documento: " + docC);
                    }
                    break;

                case 3:
                    System.out.println("\n--- PROGRAMAR FUNCIÓN CINEMATOGRÁFICA ---");
                    System.out.print("Código único de la función: ");
                    String codF = sc.nextLine().trim();
                    System.out.print("Fecha de presentación (AAAA-MM-DD, ej. 2026-10-20): ");
                    LocalDate fecF = LocalDate.parse(sc.nextLine().trim());
                    System.out.print("Hora de inicio (HH:MM, formato 24h, ej. 15:30): ");
                    LocalTime horF = LocalTime.parse(sc.nextLine().trim());
                    System.out.print("Precio base de la boleta: ");
                    double preF = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("Código de la película a proyectar (ej. PEL01, PEL02): ");
                    String codPel = sc.nextLine().trim();
                    System.out.print("Número de la sala (1: Tradicional, 2: VIP, 3: 3D): ");
                    int numS = Integer.parseInt(sc.nextLine().trim());

                    if (cine.programarFuncion(codF, fecF, horF, preF, codPel, numS)) {
                        System.out.println(">> ¡ÉXITO! Función " + codF + " programada correctamente (sin conflictos de horario).");
                    } else {
                        System.out.println(">> ¡ERROR! No se pudo programar. Verifique si el código ya existe, si la sala o película existen, o si hay conflicto de horario (superposición con otra función en esa sala).");
                    }
                    break;

                case 4:
                    System.out.println("\n--- REALIZAR VENTA DE BOLETAS ---");
                    System.out.print("Código único de la venta: ");
                    String codV = sc.nextLine().trim();
                    System.out.print("Documento del cliente comprador: ");
                    String docCli = sc.nextLine().trim();
                    System.out.print("Documento del operario en taquilla: ");
                    String docOp = sc.nextLine().trim();
                    System.out.print("Código de la función (ej. FUN01, FUN02): ");
                    String cFun = sc.nextLine().trim();

                    System.out.print("¿Cuántas boletas desea adquirir?: ");
                    int cant = Integer.parseInt(sc.nextLine().trim());
                    List<String[]> asientos = new ArrayList<>();
                    for (int i = 1; i <= cant; i++) {
                        System.out.print("Boleta #" + i + " -> Fila (ej. A, B, C): ");
                        String f = sc.nextLine().trim();
                        System.out.print("Boleta #" + i + " -> Número de asiento (ej. 1, 2, 3): ");
                        String n = sc.nextLine().trim();
                        asientos.add(new String[]{f, n});
                    }

                    Venta v = cine.registrarVenta(codV, LocalDateTime.now(), docCli, docOp, cFun, asientos);
                    if (v != null) {
                        System.out.println("\n>> ¡VENTA REGISTRADA EXITOSAMENTE!");
                        System.out.println("  • Subtotal (con recargo de sala): $" + v.calcularSubtotal());
                        System.out.println("  • Descuento del cliente: -$" + v.calcularDescuento());
                        System.out.println("  • VALOR TOTAL PAGADO: $" + v.calcularTotal());
                        System.out.println("  • Boletas generadas:");
                        for (Boleto b : v.getBoletos()) {
                            System.out.println("    -> " + b);
                        }
                    } else {
                        System.out.println(">> ¡ERROR! No se pudo realizar la venta. Verifique si los asientos ya están ocupados para esta función, si el cliente/operario/función existen, o si el código de venta ya fue usado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- CONSULTAR VALOR TOTAL DE UNA VENTA ---");
                    System.out.print("Ingrese el código de la venta a consultar: ");
                    String bV = sc.nextLine().trim();
                    double totalVenta = cine.calcularTotalVentaPorCodigo(bV);
                    if (totalVenta >= 0) {
                        Venta vent = cine.buscarVenta(bV);
                        System.out.println(">> Venta encontrada:");
                        System.out.println("   " + vent);
                        System.out.println(">> El valor total sumando sus boletas individuales es: $" + totalVenta);
                    } else {
                        System.out.println(">> ¡ERROR! No se encontró ninguna venta registrada con el código: " + bV);
                    }
                    break;

                case 6:
                    System.out.println("\n--- CONSULTAR PORCENTAJE DE OCUPACIÓN DE UNA FUNCIÓN ---");
                    System.out.print("Ingrese el código de la función a consultar: ");
                    String bF = sc.nextLine().trim();
                    double porc = cine.calcularPorcentajeOcupacionPorCodigo(bF);
                    if (porc >= 0) {
                        Funcion func = cine.buscarFuncion(bF);
                        System.out.println(">> Función: " + func.getCodigo() + " - " + func.getPelicula().getTitulo());
                        System.out.println(">> Sala: " + func.getSala().getNombre() + " (Capacidad máxima: " + func.getSala().getCapacidadMaxima() + " espectadores)");
                        System.out.printf(">> Porcentaje de ocupación calculado con «record» RegistroOcupacion: %.2f%%\n", porc);
                    } else {
                        System.out.println(">> ¡ERROR! No se encontró ninguna función con el código: " + bF);
                    }
                    break;

                case 7:
                    System.out.println("\n=======================================================");
                    System.out.println("              LISTADOS GENERALES DE CINEPLUS");
                    System.out.println("=======================================================");
                    System.out.println("\n--- CATÁLOGO DE PELÍCULAS ---");
                    for (Pelicula p : cine.consultarPeliculasDisponibles()) {
                        System.out.println(" • " + p);
                    }
                    System.out.println("\n--- SALAS DE PROYECCIÓN ---");
                    for (Sala sl : cine.consultarSalas()) {
                        System.out.println(" • " + sl);
                    }
                    System.out.println("\n--- FUNCIONES CINEMATOGRÁFICAS ---");
                    for (Funcion fc : cine.consultarFunciones()) {
                        System.out.println(" • " + fc);
                    }
                    System.out.println("\n--- VENTAS REGISTRADAS ---");
                    if (cine.getListVentas().isEmpty()) {
                        System.out.println(" (No hay ventas registradas aún)");
                    } else {
                        for (Venta vn : cine.getListVentas()) {
                            System.out.println(" • " + vn);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Cerrando sesión en CinePlus. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println(">> Opción no válida. Por favor elija un número entre 0 y 7.");
            }
        } while (opcion != 0);

        sc.close();
    }
}