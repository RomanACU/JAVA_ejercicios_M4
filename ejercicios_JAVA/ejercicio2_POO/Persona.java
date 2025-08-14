public class Persona {
    // Atributos
    public String nombre;
    public String edad;
    public String profesion;
    public String curp;
    public String direccion;
    public String telefono;
    public String tipoSangre;

    // Constructor
    public Persona(String nombre, String edad, String profesion, String curp, String direccion, String telefono, String tipoSangre) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.curp = curp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
    }

    // Método para mostrar la información
    public void descripcionInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Profesión: " + profesion);
        System.out.println("CURP: " + curp);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Tipo de Sangre: " + tipoSangre);
        System.out.println("-----------------------------");
    }
}
