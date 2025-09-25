import model.*;
import util.ImportadorCSV;

import java.util.*;

public class Main {
    static List<Producto> productos = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static List<Venta> ventas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Importar productos desde CSV a la base de datos
        ImportadorCSV.importarProductos("data/productos.csv");

        // Cargar productos desde la base de datos a la lista
        productos = ImportadorCSV.cargarProductosDesdeBD();

        int opcion;
        do {
            System.out.println("\n--- MENÚ DREAMS ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar stock");
            System.out.println("5. Salir \n");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarProducto();
                case 2 -> registrarCliente();
                case 3 -> realizarVenta();
                case 4 -> mostrarStock();
                case 5 -> System.out.println("¡Gracias por usar el sistema DREAMS!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    static void registrarProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto nuevoProducto = new Producto(nombre, precio, categoria, stock);
        productos.add(nuevoProducto);
        System.out.println("Producto registrado. \n");

    }

    static void registrarCliente() {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();

        clientes.add(new Cliente(nombre, correo));
        System.out.println("Cliente registrado.\n");
    }

    static void realizarVenta() {
        if (productos.isEmpty() || clientes.isEmpty()) {
            System.out.println("Debe registrar al menos un producto y un cliente.\n");
            return;
        }

        System.out.println("Seleccione cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + ". " + clientes.get(i).getDatosCliente());
        }
        int clienteIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Seleccione producto:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(i + ". " + productos.get(i).getNombre() + " - Stock: " + productos.get(i).getStock());
        }
        int productoIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        Producto producto = productos.get(productoIndex);
        Cliente cliente = clientes.get(clienteIndex);
        Venta venta = new Venta(producto, cantidad, cliente);

        if (venta.procesarVenta()) {
            ventas.add(venta);
            System.out.println("Venta realizada. Total: $" + venta.calcularTotal() + "\n");
        } else {
            System.out.println("Stock insuficiente.\n");
        }
    }

    static void mostrarStock() {
        System.out.println("\n--- STOCK ACTUAL ---");

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - Stock: " + p.getStock());
        }
    }
}

