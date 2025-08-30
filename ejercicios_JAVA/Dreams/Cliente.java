public class Cliente {
    private String nombre;
    private String correo;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getDatosCliente() {
        return nombre + " (" + correo + ")";
    }

    public void actualizarCorreo(String nuevoCorreo) {
        this.correo = nuevoCorreo;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
