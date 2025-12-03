
import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private List<Producto> productos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();

    public void registrarProducto(Producto p) {
        productos.add(p);
    }

    public void registrarCliente(Cliente c) {
        clientes.add(c);
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCorreo(String correo) {
        for (Cliente c : clientes) {
            if (c.getCorreo().equalsIgnoreCase(correo)) {
                return c;
            }
        }
        return null;
    }

    public Venta crearVenta(Cliente cliente) {
        Venta venta = new Venta(cliente);
        ventas.add(venta);
        return venta;
    }

    public List<Venta> getVentas() {
        return ventas;
    }
}
