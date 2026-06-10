import java.util.Scanner;

public class E5b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        int bomba;
        String secuencia;

        System.out.print("Ingrese el número: ");
        n = input.nextInt();
        
        System.out.print("Ingrese la bomba: ");
        bomba = input.nextInt();

        secuencia = explotar(n, bomba).trim().replaceAll(" ", ", ");
        System.out.println("Restos de la explosión: " + secuencia);
    }

    public static String explotar(int n, int b) {
        String resultado = "";

        if (n > b) {
            resultado += explotar(n/b, b);
            resultado += explotar(n - n/b, b);
        } else {
            resultado += n + " ";
        }

        return resultado;
    }
}