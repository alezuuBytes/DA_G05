import java.util.Random;
import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr;
        int filas, columnas;

        System.out.println("Ingrese las filas de la matriz");
        filas = input.nextInt();

        System.out.println("Ingrese la cantidad de columnas de la matriz");
        columnas = input.nextInt();

        arr = new int[filas][columnas];
        llenarMatriz(arr);
        mostrarMatriz(arr);

        input.close();
    }

    public static void llenarMatriz(int[][] matriz) {
        Random rand = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(0, 9);
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}