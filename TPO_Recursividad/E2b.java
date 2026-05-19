import java.util.Random;

public class E2b {
    public static void main(String[] args) {
        Random random = new Random();
        int numAleatorio = random.nextInt(1, 10);
        int[][] matriz = new int[numAleatorio][numAleatorio];
        int suma;

        llenarMatriz(matriz);
        suma = sumaDiagonal(matriz, 0);

        mostrarMatriz(matriz);
        System.out.println("Suma diagonal: " + suma);
    }

    public static void llenarMatriz(int[][] matriz) {
        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = random.nextInt(0, 10);
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        String texto = "";

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                texto += matriz[i][j] + " ";
            }
            texto += "\n";
        }

        System.out.println(texto);
    }

    public static int sumaDiagonal(int[][] m, int i){
        int resultado = 0;

        if (i < m.length) {
            resultado = sumaDiagonal(m, i + 1) + m[i][i];
        } else {
            resultado = 0;
        }

        return resultado;
    }
}