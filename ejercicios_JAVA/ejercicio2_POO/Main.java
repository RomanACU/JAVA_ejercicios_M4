
public class Main {

    /*

        Clase Persona
        Atributos:
        Nombre, Edad, Profesion, Curp, Direccion, Telefono, TipoSangre.
        Métodos:
        DescripcionInformacion
    
        Main.java
        Instancia almenos 2 personas
        
     */

    public static void main(String[] args) {
        // Crear instancias de Persona
        Persona persona1 = new Persona(
                "Ana López", "28", "Ingeniera", "LOAA280395MDFRPN01",
                "Av. Reforma 123, CDMX", "5551234567", "O+"
        );

        Persona persona2 = new Persona(
                "Carlos Méndez", "35", "Doctor", "MECA350788HDFRRL02",
                "Calle Juárez 456, CDMX", "5559876543", "A-"
        );

        Persona persona3 = new Persona(
                "Lucía Ramírez", "22", "Estudiante", "RALU220101MDFRMC03",
                "Calle Hidalgo 789, CDMX", "5557654321", "B+"
        );

        Persona persona4 = new Persona(
                "Miguel Torres", "40", "Arquitecto", "TOMI400512HDFRRG04",
                "Av. Insurgentes 321, CDMX", "5558765432", "AB-"
        );

        Persona persona5 = new Persona(
                "Sofía Hernández", "30", "Diseñadora", "HESO300720MDFRNS05",
                "Calle Morelos 654, CDMX", "5552345678", "O-"
        );

        // Mostrar información
        persona1.descripcionInformacion();
        persona2.descripcionInformacion();
        persona3.descripcionInformacion();
        persona4.descripcionInformacion();
        persona5.descripcionInformacion();
    }
}
