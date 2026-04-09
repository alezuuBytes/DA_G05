import java.util.Random;
import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] playa = new char[5][6];
        int[] posL;
        int[] lugares;
        char opción;

        llenarMatriz(playa);

        do {
            System.out.print("\n\033[H\033[2J");
            System.out.println("        < < < MENÚ > > >");
            System.out.println("1. Mostrar estacionamientos totales");
            System.out.println("2. Contar lugares");
            System.out.println("3. Ocupar primer lugar libre");
            System.out.println("\n");
            System.out.println("(Ingrese una entrada inválida para salir)");
            System.out.print(">    Opción: ");
            opción = input.nextLine().charAt(0);

            System.out.print("\n\033[H\033[2J");
            switch (opción) {
                case '1':
                    System.out.println("        < < < PLAYA > > >");
                    escribirMatriz(playa);
                    System.out.println("");
                    System.out.println("L = Libre");
                    System.out.println("O = Ocupado");
                    System.out.println("R = Reservado");
                break;
                case '2':
                    System.out.println("        < < < CANTIDAD DE LUGARES > > >");
                    lugares = contarLugares(playa);
                    System.out.println("->  Libres: " + lugares[0]);
                    System.out.println("->  Ocupados: " + lugares[1]);
                    System.out.println("->  Reservados: " + lugares[2]);
                break;
                case '3':
                    System.out.println("        < < < OCUPAR ESTACIONAMIENTO > > >");
                    posL = buscarPrimerLibre(playa);

                    if (posL[0] != playa.length) {
                        playa[posL[0]][posL[1]] = 'O';
                        System.out.println("->  Tu estacionamiento está en la fila " + (posL[0] + 1) + ", columna " + (posL[1] + 1));
                        escribirMatriz(playa);
                    } else {
                        System.out.println("->  No se encuentra un lugar libre para ocupar");
                    }
                break;
                default:
                    opción = 0;
                    System.out.println("Fue un placer! :)");
                break;
            }
            input.nextLine();
        } while (opción != 0);

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
    
    public static void escribirMatriz(char[][] matriz) {
        String salida = "";

        for (int i = 0; i < matriz.length; i++) {
            salida += (i + 1) + ">   ";
            for (int j = 0; j < matriz[0].length; j++) {
                salida += "[" + matriz[i][j] + "]   ";
            }
            salida = salida.trim() + "\n";
        }
        System.out.println(salida);
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

        while (pos[0] < matriz.length && matriz[pos[0]][pos[1]] != 'L') {
            pos[1]++;

            if (pos[1] >= matriz[0].length) {
                pos[0]++;
                pos[1] = 0;
            }
        }

        return pos;
    }
}