public class Cajero {
    private String nombre;
    private String apellido;
    private double monto;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    // Operaciones simples
    public void ingresarMonto(double cantidad) {
        monto += cantidad;
        System.out.println("Ingresaste: " + cantidad + " | Saldo actual: " + monto);
    }

    public void retirarMonto(double cantidad) {
        monto -= cantidad;
        System.out.println("Retiraste: " + cantidad + " | Saldo actual: " + monto);
    }

    public void consultarMonto() {
        System.out.println("Saldo actual: " + monto);
    }
}