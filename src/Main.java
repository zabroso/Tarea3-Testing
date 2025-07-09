package src;

import java.sql.Timestamp;
import java.util.*;

import models.Cliente;
import models.Compra;
import models.Nivel;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
    }

    public static void run(Scanner scanner) {
        List<Cliente> clientes = new ArrayList<>();
        List<Compra> compras = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Compras");
            System.out.println("3. Mostrar Puntos y Nivel de un Cliente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarClientes(scanner, clientes, compras);
                    break;
                case 2:
                    gestionarCompras(scanner, clientes, compras);
                    break;
                case 3:
                    mostrarPuntosYNivel(scanner, clientes);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    private static void gestionarClientes(Scanner scanner, List<Cliente> clientes, List<Compra> compras) {
        int op;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Volver");
            System.out.print("Seleccione opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    crearCliente(scanner, clientes);
                    break;
                case 2:
                    listarClientes(clientes);
                    break;
                case 3:
                    actualizarCliente(scanner, clientes);
                    break;
                case 4:
                    eliminarCliente(scanner, clientes, compras);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 5);
    }

    private static void crearCliente(Scanner scanner, List<Cliente> clientes) {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (buscarCliente(clientes, id) != null) {
                System.out.println("Ya existe un cliente con ese ID.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Correo: ");
            String correo = scanner.nextLine();

            Cliente c = new Cliente(id, nombre, correo, 0, Nivel.BRONCE, 0);
            clientes.add(c);
            System.out.println("Cliente creado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre() + ", Correo: " + c.getCorreo() + ", Puntos: " + c.getPuntos() + ", Nivel: " + c.getNivel());
        }
    }

    private static void actualizarCliente(Scanner scanner, List<Cliente> clientes) {
        System.out.print("Ingrese ID del cliente a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente c = buscarCliente(clientes, id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (enter para no cambiar): ");
        String nombre = scanner.nextLine();
        if (!nombre.trim().isEmpty()) {
            c.setNombre(nombre);
        }

        System.out.print("Nuevo correo (enter para no cambiar): ");
        String correo = scanner.nextLine();
        if (!correo.trim().isEmpty()) {
            try {
                c.setCorreo(correo);
            } catch (IllegalArgumentException e) {
                System.out.println("Correo inválido, no se actualizó.");
            }
        }

        System.out.println("Cliente actualizado.");
    }

    private static void eliminarCliente(Scanner scanner, List<Cliente> clientes, List<Compra> compras) {
        System.out.print("Ingrese ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente c = buscarCliente(clientes, id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        compras.removeIf(compra -> compra.getIdCliente() == id);

        clientes.remove(c);
        System.out.println("Cliente y sus compras eliminados.");
    }

    private static void gestionarCompras(Scanner scanner, List<Cliente> clientes, List<Compra> compras) {
        int op;
        do {
            System.out.println("\n--- Gestión de Compras ---");
            System.out.println("1. Crear compra");
            System.out.println("2. Listar compras");
            System.out.println("3. Actualizar compra");
            System.out.println("4. Eliminar compra");
            System.out.println("5. Volver");
            System.out.print("Seleccione opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    crearCompra(scanner, clientes, compras);
                    break;
                case 2:
                    listarCompras(compras);
                    break;
                case 3:
                    actualizarCompra(scanner, clientes, compras);
                    break;
                case 4:
                    eliminarCompra(scanner, compras);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 5);
    }

    private static void crearCompra(Scanner scanner, List<Cliente> clientes, List<Compra> compras) {
        System.out.print("ID compra: ");
        int idCompra = scanner.nextInt();
        scanner.nextLine();

        if (buscarCompra(compras, idCompra) != null) {
            System.out.println("Ya existe compra con ese ID.");
            return;
        }

        System.out.print("ID cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = buscarCliente(clientes, idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Monto: ");
        int monto = scanner.nextInt();
        scanner.nextLine();

        Timestamp fecha = new Timestamp(System.currentTimeMillis());
        Compra compra = new Compra(idCompra, idCliente, monto, fecha);
        compras.add(compra);

        int puntosGanados = monto + (monto * cliente.getNivel().getPorcentajeBeneficio() / 100);
        cliente.setPuntos(cliente.getPuntos() + puntosGanados);
        cliente.setNivel(Nivel.obtenerPorPuntaje(cliente.getPuntos()));

        System.out.println("Compra creada y puntos actualizados.");
    }

    private static void listarCompras(List<Compra> compras) {
        if (compras.isEmpty()) {
            System.out.println("No hay compras registradas.");
            return;
        }
        for (Compra compra : compras) {
            System.out.println("ID compra: " + compra.getId() + ", Cliente ID: " + compra.getIdCliente() + ", Monto: " + compra.getMonto() + ", Fecha: " + compra.getFecha());
        }
    }

    private static void actualizarCompra(Scanner scanner, List<Cliente> clientes, List<Compra> compras) {
        System.out.print("ID compra a actualizar: ");
        int idCompra = scanner.nextInt();
        scanner.nextLine();

        Compra compra = buscarCompra(compras, idCompra);
        if (compra == null) {
            System.out.println("Compra no encontrada.");
            return;
        }

        System.out.print("Nuevo monto (enter para no cambiar): ");
        String input = scanner.nextLine();
        if (!input.trim().isEmpty()) {
            try {
                int nuevoMonto = Integer.parseInt(input);
                compra.setMonto(nuevoMonto);
                Cliente cliente = buscarCliente(clientes, compra.getIdCliente());
                if (cliente != null) {
                    cliente.setPuntos(cliente.getPuntos() + nuevoMonto);
                    cliente.setNivel(Nivel.obtenerPorPuntaje(cliente.getPuntos()));
                }
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido, no se actualizó.");
            }
        }

        System.out.println("Compra actualizada.");
    }

    private static void eliminarCompra(Scanner scanner, List<Compra> compras) {
        System.out.print("ID compra a eliminar: ");
        int idCompra = scanner.nextInt();
        scanner.nextLine();

        Compra compra = buscarCompra(compras, idCompra);
        if (compra == null) {
            System.out.println("Compra no encontrada.");
            return;
        }

        compras.remove(compra);
        System.out.println("Compra eliminada.");
    }

    private static void mostrarPuntosYNivel(Scanner scanner, List<Cliente> clientes) {
        System.out.print("\nIngrese ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = buscarCliente(clientes, idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Puntos: " + cliente.getPuntos());
        System.out.println("Nivel: " + cliente.getNivel());
    }

    private static Cliente buscarCliente(List<Cliente> clientes, int idCliente) {
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) return c;
        }
        return null;
    }

    private static Compra buscarCompra(List<Compra> compras, int idCompra) {
        for (Compra c : compras) {
            if (c.getId() == idCompra) return c;
        }
        return null;
    }
}
