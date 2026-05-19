import java.util.Scanner;

public class E4b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int renglones;

        System.out.print("Ingrese cuántos pisos desea en la pirámide: ");
        renglones = sc.nextInt();

        piramide(renglones, renglones);
    }

    public static int piramide(int n, int i) {
        int resultado = 0;

        if (i > 0) {
            resultado = i * (int) Math.pow(10, i - 1) + piramide(n, i - 1);
            System.out.println(resultado);
        }

        return resultado;
    }
}