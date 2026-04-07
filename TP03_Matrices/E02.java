import java.util.Random;
import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] playa = new char[5][6];
        int[] posL;
        int[] lugares;
        char caso;
        llenarMatriz(playa);

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("< MENÚ >");
            System.out.println("1. Mostrar estacionamientos totales");
            System.out.println("2. Contar lugares");
            System.out.println("3. Ocupar primer lugar libre");
            System.out.println("\n");
            System.out.print("Opción (0 para salir): ");
            caso = input.nextLine().charAt(0);

            switch (caso) {
                case '1':
                    mostrarMatriz(playa);

                    input.nextLine();
                break;
                case '2':
                    lugares = contarLugares(playa);
                    System.out.println("Lugares libres: " + lugares[0]);
                    System.out.println("Lugares ocupados: " + lugares[1]);
                    System.out.println("Lugares reservados: " + lugares[2]);

                    input.nextLine();
                break;
                case '3':
                    posL = buscarPrimerLibre(playa);

                    if (posL[0] != playa.length) {
                        playa[posL[0]][posL[1]] = 'O';
                        System.out.println("Tu estacionamiento está en la fila " + (posL[0] + 1) + ", columna " + (posL[1] + 1));
                    } else {
                        System.out.println("No se encuentra un lugar libre para ocupar");
                    }
                    mostrarMatriz(playa);

                    input.nextLine();
                break;
            }
        } while (caso != '0');
        System.out.println("Saliendo...");

        input.close();
    }

    public static void llenarMatriz(char[][] matriz) {
        Random rand = new Random();
        char[] lugares = {'L', 'O', 'R'};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = lugares[rand.nextInt(0, 3)];
            }
        }
    }
    
    public static void mostrarMatriz(char[][] matriz) {        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
    }   

    public static int[] contarLugares(char[][] matriz) {
        int[] lugares = {0, 0, 0};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == 'L') {
                    lugares[0]++;
                } else if (matriz[i][j] == 'O') {
                    lugares[1]++;
                } else if (matriz[i][j] == 'R') {
                    lugares[2]++;
                }
            }
        }

        return lugares;
    }

    public static int[] buscarPrimerLibre(char[][] matriz) {
        int[] pos = {0, 0};
        int i = pos[0];
        int j = pos[1];

        while (i < matriz.length && matriz[i][j] != 'L') {
            j++;

            if (j >= matriz[0].length) {
                i++;
                j = 0;
            }
        }

        return pos;
    }
}