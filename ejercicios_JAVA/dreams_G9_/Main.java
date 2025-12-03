
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("=======================================");
        System.out.println("       SISTEMA DE VENTAS DREAMS");
        System.out.println("=======================================\n");

        do {
            System.out.println("\n------ MENÚ PRINCIPAL ------");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Crear venta");
            System.out.println("4. Mostrar todas las ventas");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarProducto(tienda, sc);
                    break;

                case 2:
                    registrarCliente(tienda, sc);
                    break;

                case 3:
                    crearVenta(tienda, sc);
                    break;

                case 4:
                    mostrarVentas(tienda);
                    break;

                case 5:
                    System.out.println("\nSaliendo del sistema DREAMS...");
                    break;

                default:
                    System.out.println("\nOpción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }

    private static void registrarProducto(Tienda tienda, Scanner sc) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.print("Categoría: ");
        String categoria = sc.nextLine();

        System.out.print("Stock inicial: ");
        int stock = sc.nextInt();

        tienda.registrarProducto(new Producto(nombre, precio, categoria, stock));
        System.out.println("Producto registrado correctamente.");
    }

    private static void registrarCliente(Tienda tienda, Scanner sc) {
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine().trim();

        String correo = nombre.toLowerCase()
                .replace(" ", ".")
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u")
                + "@dreams.com";

        tienda.registrarCliente(new Cliente(nombre, correo));

        System.out.println("Cliente registrado correctamente.");
        System.out.println("Correo asignado automáticamente: " + correo);
    }

    private static void crearVenta(Tienda tienda, Scanner sc) {
        System.out.print("Correo del cliente: ");
        String correo = sc.nextLine();

        Cliente cliente = tienda.buscarClientePorCorreo(correo);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Venta venta = tienda.crearVenta(cliente);
        int opcion;

        do {
            System.out.println("\n--- AGREGAR PRODUCTO A LA VENTA ---");
            System.out.print("Nombre del producto: ");
            String nombreProducto = sc.nextLine();

            Producto producto = tienda.buscarProductoPorNombre(nombreProducto);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
            } else {
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();
                sc.nextLine();

                venta.agregarItem(producto, cantidad);
            }

            System.out.println("\n¿Desea agregar otro producto?");
            System.out.println("1. Sí     2. No");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion == 1);

        System.out.println("\nVenta creada con éxito. Resumen:");
        venta.mostrarResumen();
    }

    private static void mostrarVentas(Tienda tienda) {
        if (tienda.getVentas().isEmpty()) {
            System.out.println("\nNo hay ventas registradas.");
            return;
        }

        System.out.println("\n===== LISTA DE TODAS LAS VENTAS =====\n");

        for (Venta venta : tienda.getVentas()) {
            venta.mostrarResumen();
        }
    }
}
