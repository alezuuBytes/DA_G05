import java.util.Scanner;

public class E15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] notas = new double[10];
        double nota;

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota número " + (i + 1) + ":");
            nota = input.nextDouble();

            if (nota >= 0 && nota <= 10) {
                notas[i] = nota;
            } else {
                System.out.print("Nota inválida!");
                i--;
            }
        }

        if (verificar(notas)) {
            System.out.println("El alumno está aprobado");
        } else {
            System.out.println("El alumno está desaprobado");
        }

        input.close(); // se evita la advertencia "Resource leak: 'input' is never closed"
    }

    public static boolean verificar(double[] arr) {
        boolean aprobado = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                aprobado = false;
            }
        }

        return aprobado;
    }
}