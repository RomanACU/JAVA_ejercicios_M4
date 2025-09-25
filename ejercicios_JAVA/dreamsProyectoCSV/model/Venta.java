package model;

public class Venta {
    private Producto producto;
    private int cantidad;
    private Cliente cliente;

    public Venta(Producto producto, int cantidad, Cliente cliente) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cliente = cliente;
    }

    public double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }

    public boolean procesarVenta() {
        if (producto.verificarStock(cantidad)) {
            producto.reducirStock(cantidad);
            return true;
        }
        return false;
    }

    public Producto getProducto() { return producto; }
    public Cliente getCliente() { return cliente; }
}

