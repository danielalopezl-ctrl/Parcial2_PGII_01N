package uniquindio.edu.co.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CinePlus cine = new CinePlus("CinePlus Armenia", "901.456.789-1", "Centro Comercial Portal del Quindío");

        // Datos de prueba iniciales para agilizar la prueba en el video
        cine.agregarSala(new Sala(1, "Sala 1 General", TipoSala.TRADICIONAL, 50, 5, 10));
        cine.agregarSala(new Sala(2, "Sala 2 VIP", TipoSala.VIP, 30, 5, 6));
        cine.agregarSala(new Sala(3, "Sala 3 3D", TipoSala.SALA_3D, 40, 5, 8));

        cine.registrarOperador("1094001", "Andrés Gomez", "andres@cineplus.com", "3100000001", "OP01", LocalDate.of(2024, 1, 15), 1400000);
        cine.registrarCliente("1094999", "Daniela Lopez", "daniela@uq.edu.co", "3111111111", "AF-100", 10.0, LocalDate.now());

        cine.registrarPelicula("PEL01", "Avatar", 180, Genero.ACCION, "+12");
        cine.registrarPelicula("PEL02", "Intensamente", 95, Genero.ANIMACION, "Todo Publico");

        int opcion = -1;
        do {
            System.out.println("\n=======================================================");
            System.out.println("             SISTEMA CINEPLUS - MENU PRINCIPAL");
            System.out.println("=======================================================");
            System.out.println("1. Registrar Pelicula");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Programar Funcion");
            System.out.println("4. Realizar Venta de Boletas");
            System.out.println("5. Consultar y Calcular Total de Venta");
            System.out.println("6. Consultar Porcentaje de Ocupacion de Funcion");
            System.out.println("7. Ver Listados Generales");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR PELICULA ---");
                    System.out.print("Codigo: ");
                    String codP = sc.nextLine();
                    System.out.print("Titulo: ");
                    String titP = sc.nextLine();
                    System.out.print("Duracion (minutos): ");
                    int durP = Integer.parseInt(sc.nextLine());
                    System.out.println("Generos: 1. ACCION | 2. COMEDIA | 3. DRAMA | 4. TERROR | 5. ANIMACION");
                    System.out.print("Opcion de genero: ");
                    int g = Integer.parseInt(sc.nextLine());
                    Genero gen = (g == 2) ? Genero.COMEDIA : (g == 3) ? Genero.DRAMA : (g == 4) ? Genero.TERROR : (g == 5) ? Genero.ANIMACION : Genero.ACCION;
                    System.out.print("Clasificacion edad: ");
                    String clasP = sc.nextLine();

                    if (cine.registrarPelicula(codP, titP, durP, gen, clasP)) {
                        System.out.println(">> Pelicula registrada correctamente.");
                    } else {
                        System.out.println(">> Error: Ya existe una pelicula con el codigo " + codP);
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR CLIENTE ---");
                    System.out.print("Documento: ");
                    String docC = sc.nextLine();
                    System.out.print("Nombre completo: ");
                    String nomC = sc.nextLine();
                    System.out.print("Correo: ");
                    String corC = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telC = sc.nextLine();
                    System.out.print("Codigo Afiliacion: ");
                    String afilC = sc.nextLine();
                    System.out.print("Porcentaje de Descuento (%): ");
                    double descC = Double.parseDouble(sc.nextLine());

                    if (cine.registrarCliente(docC, nomC, corC, telC, afilC, descC, LocalDate.now())) {
                        System.out.println(">> Cliente registrado correctamente.");
                    } else {
                        System.out.println(">> Error: Ya existe una persona con el documento " + docC);
                    }
                    break;

                case 3:
                    System.out.println("\n--- PROGRAMAR FUNCION ---");
                    System.out.print("Codigo funcion: ");
                    String codF = sc.nextLine();
                    System.out.print("Fecha (AAAA-MM-DD, ej 2026-10-20): ");
                    LocalDate fecF = LocalDate.parse(sc.nextLine());
                    System.out.print("Hora inicio (HH:MM, ej 16:30): ");
                    LocalTime horF = LocalTime.parse(sc.nextLine());
                    System.out.print("Precio base: ");
                    double preF = Double.parseDouble(sc.nextLine());
                    System.out.print("Codigo de pelicula: ");
                    String codPel = sc.nextLine();
                    System.out.print("Numero de sala (1, 2 o 3): ");
                    int numS = Integer.parseInt(sc.nextLine());

                    if (cine.programarFuncion(codF, fecF, horF, preF, codPel, numS)) {
                        System.out.println(">> Funcion programada exitosamente (Horarios validados sin conflicto).");
                    } else {
                        System.out.println(">> Error: No se pudo programar. Posible choque de horarios en la misma sala o datos inexistentes.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- REALIZAR VENTA DE BOLETAS ---");
                    System.out.print("Codigo de venta: ");
                    String codV = sc.nextLine();
                    System.out.print("Documento cliente: ");
                    String docCli = sc.nextLine();
                    System.out.print("Documento operador: ");
                    String docOp = sc.nextLine();
                    System.out.print("Codigo de funcion: ");
                    String cFun = sc.nextLine();

                    System.out.print("Cantidad de boletos a comprar: ");
                    int cant = Integer.parseInt(sc.nextLine());
                    List<String[]> asientos = new ArrayList<>();
                    for (int i = 1; i <= cant; i++) {
                        System.out.print("Boleto #" + i + " -> Fila (ej. A): ");
                        String f = sc.nextLine();
                        System.out.print("Boleto #" + i + " -> Numero de asiento: ");
                        String n = sc.nextLine();
                        asientos.add(new String[]{f, n});
                    }

                    Venta v = cine.registrarVenta(codV, LocalDateTime.now(), docCli, docOp, cFun, asientos);
                    if (v != null) {
                        System.out.println(">> VENTA REGISTRADA EXITOSAMENTE!");
                        System.out.println("Subtotal sin descuento: $" + v.calcularSubtotal());
                        System.out.println("Descuento aplicado: -$" + v.calcularDescuento());
                        System.out.println("Total a pagar: $" + v.calcularTotal());
                    } else {
                        System.out.println(">> Error: No se pudo realizar la venta. Verifique asientos ocupados o datos incorrectos.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- CALCULAR TOTAL DE UNA VENTA ---");
                    System.out.print("Codigo de venta: ");
                    String bV = sc.nextLine();
                    Venta vent = cine.buscarVenta(bV);
                    if (vent != null) {
                        System.out.println(">> El valor total de la venta es: $" + cine.calcularTotalVenta(vent));
                    } else {
                        System.out.println(">> Venta no encontrada.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- CALCULAR OCUPACION DE FUNCION ---");
                    System.out.print("Codigo de funcion: ");
                    String bF = sc.nextLine();
                    Funcion func = cine.buscarFuncion(bF);
                    if (func != null) {
                        double porc = cine.calcularPorcentajeOcupacion(func);
                        System.out.printf(">> Porcentaje de ocupacion: %.2f%%\n", porc);
                    } else {
                        System.out.println(">> Funcion no encontrada.");
                    }
                    break;

                case 7:
                    System.out.println("\n--- PELICULAS DISPONIBLES ---");
                    for (Pelicula p : cine.consultarPeliculasDisponibles()) System.out.println(p);
                    System.out.println("\n--- FUNCIONES PROGRAMADAS ---");
                    for (Funcion fc : cine.consultarFunciones()) System.out.println(fc);
                    System.out.println("\n--- SALAS ---");
                    for (Sala sl : cine.consultarSalas()) System.out.println(sl);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}