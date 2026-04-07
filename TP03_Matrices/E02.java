import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        input.close();
    }
    
    public static void MostrarMatriz(char[][] playa) {
        System.out.println("Estado del estacionamiento:");
        
        for (int i = 0; i < playa.length; i++) {
            for (int j = 0; j < playa[i].length; j++) {
                System.out.print("[" + playa[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static void ContarLugares(char[][] playa) {
        int libres = 0, ocupados = 0, reservados = 0;

        for (int i = 0; i < playa.length; i++) {
            for (int j = 0; j < playa[i].length; j++) {
                if (playa[i][j] == 'L') libres++;
                else if (playa[i][j] == 'O') ocupados++;
                else if (playa[i][j] == 'R') reservados++;
            }
        }

        System.out.println("Libres: " + libres);
        System.out.println("Ocupados: " + ocupados);
        System.out.println("Reservados: " + reservados);
    }

    public static int[] BuscarPrimerLibre(char[][] playa) {
        boolean encontrado = false;
        int fila = -1, columna = -1;

        for (int i = 0; i < playa.length && !encontrado; i++) {
            for (int j = 0; j < playa[i].length && !encontrado; j++) {
                if (playa[i][j] == 'L') {
                    fila = i;
                    columna = j;
                    encontrado = true; // detiene ambos for
                }
            }
        }

        if (encontrado) {
            System.out.println("Primer lugar libre en: [" + fila + "][" + columna + "]");
        } else {
            System.out.println("No hay lugares libres.");
        }

        return new int[]{fila, columna};
    }
}