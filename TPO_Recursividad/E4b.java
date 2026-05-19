import java.util.Scanner;

public class E4b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int longitud;

        System.out.print("Ingrese la longitud de la pirámide: ");
        longitud = input.nextInt();

        System.out.println("Media pirámide (escalera) del 1 al " + longitud + ":");
        mediaPirámide(longitud, longitud);
    }

    public static int mediaPirámide(int n, int i) {
        int resultado = 0;

        if (i > 0) {
            resultado = i * (int) Math.pow(10, i - 1) + mediaPirámide(n, i - 1);
            System.out.println(resultado);
        }

        return resultado;
    }
}