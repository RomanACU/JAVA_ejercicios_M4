
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SistemaInventario sistema = new SistemaInventario();

        System.out.println("--- 1. Registro de Productos y Clientes ---");

        sistema.registrarProducto("Laptop X", 1200.50, "Electrónica", 10);
        sistema.registrarProducto("Mouse Pad", 15.00, "Accesorios", 50);
        sistema.registrarProducto("Monitor Z", 350.00, "Electrónica", 5);

        Cliente cliente1 = sistema.registrarCliente("Ana Gómez", "ana.gomez@mail.com");
        Cliente cliente2 = sistema.registrarCliente("Luis Pérez", "luis.perez@mail.com");

        System.out.println("\n--- 2. Intento de Venta con Stock Suficiente ---");

        List<SistemaInventario.DetalleVentaDTO> venta1Items = Arrays.asList(
                new SistemaInventario.DetalleVentaDTO("Laptop X", 1),
                new SistemaInventario.DetalleVentaDTO("Mouse Pad", 2)
        );
        sistema.registrarVenta(cliente1.getId(), venta1Items);

        System.out.println("\n--- 3. Intento de Venta con Stock Insuficiente ---");

        List<SistemaInventario.DetalleVentaDTO> venta2Items = Arrays.asList(
                new SistemaInventario.DetalleVentaDTO("Monitor Z", 8)
        );
        sistema.registrarVenta(cliente2.getId(), venta2Items);

        Producto laptop = sistema.buscarProducto("Laptop X");
        System.out.println("\nStock actual de Laptop X: " + (laptop != null ? laptop.getStock() : "N/A"));

        Producto monitor = sistema.buscarProducto("Monitor Z");
        System.out.println("Stock actual de Monitor Z: " + (monitor != null ? monitor.getStock() : "N/A"));

    }
}
