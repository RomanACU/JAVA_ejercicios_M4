
public class Producto {

    private String nombre;
    private double precio;
    private String categoria;
    private int stock;

    public Producto(String nombre, double precio, String categoria, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    public void descontarStock(int cantidad) {
        if (hayStock(cantidad)) {
            stock -= cantidad;
        }
    }
}
