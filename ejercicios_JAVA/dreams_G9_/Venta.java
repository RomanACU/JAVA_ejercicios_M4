
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private Cliente cliente;
    private List<ItemVenta> items = new ArrayList<>();

    public Venta(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarItem(Producto producto, int cantidad) {
        if (producto == null) {
            System.out.println("Error: el producto es nulo.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Error: la cantidad debe ser mayor a 0.");
            return;
        }

        if (!producto.hayStock(cantidad)) {
            System.out.println("No hay stock suficiente de: " + producto.getNombre()
                    + " | Stock disponible: " + producto.getStock()
                    + " | Cantidad solicitada: " + cantidad);
            return;
        }

        producto.descontarStock(cantidad);
        items.add(new ItemVenta(producto, cantidad));
        System.out.println("✔ Producto agregado a la venta.");
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenta item : items) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenta> getItems() {
        return items;
    }

    public void mostrarResumen() {
        System.out.println("===== RESUMEN DE LA VENTA =====\n");
        System.out.println("Cliente: " + cliente.getNombre() + " (" + cliente.getCorreo() + ")");
        System.out.println("--------------------------------");

        double total = 0;

        for (ItemVenta item : items) {
            Producto p = item.getProducto();
            double subtotal = item.calcularSubtotal();

            System.out.println("Producto: " + p.getNombre());
            System.out.println("Categoría: " + p.getCategoria());
            System.out.println("Precio unitario: $" + p.getPrecio());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("--------------------------------");

            total += subtotal;
        }

        System.out.println("TOTAL A PAGAR: $" + total);
        System.out.println("\n===== FIN DE LA VENTA =====\n");
    }

}
