
import java.util.Scanner;

/*
    Actividad:
    El usuario proporciona un número
    Le solicitaremos esa misma cantidad "numero"
    y determinaremos si es par ó impar

 */
public class ParImpar {

    public static void main(String[] args) {

        float numero;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        numero = sc.nextFloat();
        if (numero % 2 == 0) {
            System.out.println("Has introducido el número: " + numero + " y es PAR");
        } else {
            System.out.println("Has introducido el número: " + numero + " y es IMPAR");
        }
    }
}
