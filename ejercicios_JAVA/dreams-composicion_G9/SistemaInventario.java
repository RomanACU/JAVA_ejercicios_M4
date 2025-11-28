
import java.util.ArrayList;
import java.util.List;

public class SistemaInventario {

    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Venta> ventas;
    private int proximoClienteId = 1;
    private int proximaVentaId = 1;

    public SistemaInventario() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public void registrarProducto(String nombre, double precio, String categoria, int stock) {
        Producto nuevoProducto = new Producto(nombre, precio, categoria, stock);
        productos.add(nuevoProducto);
        System.out.println("Producto registrado: " + nombre);
    }

    public Cliente registrarCliente(String nombre, String email) {
        Cliente nuevoCliente = new Cliente(proximoClienteId++, nombre, email);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado con ID " + nuevoCliente.getId() + ": " + nombre);
        return nuevoCliente;
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null; 
    }
    public Venta registrarVenta(int clienteId, List<DetalleVentaDTO> items) {
        Cliente cliente = buscarCliente(clienteId);
        if (cliente == null) {
            System.err.println("Error: Cliente con ID " + clienteId + " no encontrado.");
            return null;
        }

        Venta nuevaVenta = new Venta(proximaVentaId++, cliente);

        for (DetalleVentaDTO item : items) {
            Producto producto = buscarProducto(item.nombreProducto);
            int cantidad = item.cantidad;

            if (producto == null) {
                System.err.println("Error: Producto " + item.nombreProducto + " no encontrado. Venta cancelada.");
                return null;
            }

            if (producto.getStock() < cantidad) {
                System.err.println("Stock insuficiente para " + producto.getNombre() + ". Disponible: " + producto.getStock());
                return null;
            }

            nuevaVenta.agregarDetalle(producto, cantidad);

            producto.setStock(producto.getStock() - cantidad);
        }

        double total = nuevaVenta.calcularTotal();
        ventas.add(nuevaVenta);

        System.out.println("\nVenta " + nuevaVenta.getIdVenta() + " registrada exitosamente.");
        System.out.println("   Cliente: " + cliente.getNombre());
        System.out.println("   TOTAL A PAGAR: $" + String.format("%.2f", total));
        return nuevaVenta;
    }

    public static class DetalleVentaDTO {

        String nombreProducto;
        int cantidad;

        public DetalleVentaDTO(String nombreProducto, int cantidad) {
            this.nombreProducto = nombreProducto;
            this.cantidad = cantidad;
        }
    }
}
