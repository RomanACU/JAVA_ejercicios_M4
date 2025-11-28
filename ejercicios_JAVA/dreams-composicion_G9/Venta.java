
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int idVenta;
    private Cliente cliente;
    private List<DetalleVenta> detalles;

    public Venta(int idVenta, Cliente cliente) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        DetalleVenta detalle = new DetalleVenta(producto, cantidad);
        this.detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (DetalleVenta detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }
}
