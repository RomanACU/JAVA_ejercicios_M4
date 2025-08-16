public class Main {
    public static void main(String[] args) {
        Cajero kgro = new Cajero();
        kgro.setNombre("Astrid");
        kgro.setApellido("Bergstrom");
        kgro.setMonto(5654.50);

        kgro.consultarMonto();
        kgro.ingresarMonto(2500);
        kgro.retirarMonto(1700);
    }
}
