import java.util.Scanner;

public class E1e {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        int resultado;
        
        System.out.print("Ingrese el número que desea convertir: ");
        num = input.nextInt();
        resultado = convertidorBinario(num);

        System.out.println("Decimal (base 10): " + num + "\nBinario (base 2): " + resultado);
    }

    public static int convertidorBinario(int n) {
        int rest;

        if (n >= 1) {
            rest = convertidorBinario(n/2) * 10 + n % 2;
        } else {
            rest = n;
        }

        return rest;
    }
}