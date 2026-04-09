import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char opción;
        double[][] temperaturas;
        double valor;
        
        System.out.print("\n\033[H\033[2J"); // limpiar terminal
        temperaturas = llenarMatriz();

        do {
            System.out.print("\n\033[H\033[2J");
            System.out.println("        < < < MENÚ > > >");
            System.out.println("1. Imprimir matriz");
            System.out.println("2. Mostrar temperatura máxima");
            System.out.println("3. Mostrar temperatura mínima");
            System.out.println("4. Mostrar promedio");
            System.out.println("5. Contar temperaturas mayores que una temperatura específica");
            System.out.println("6. Mostrar zonas calientes");
            System.out.println("\n");
            System.out.println("(Ingrese una entrada inválida para salir)");
            System.out.print(">    Opción: ");
            opción = input.nextLine().charAt(0);
            
            System.out.print("\n\033[H\033[2J");
            switch (opción) {
                case '1':
                    System.out.println("        < < < MATRIZ REGISTRADA > > >");
                    escribirMatriz(temperaturas);
                break;
                case '2':
                    int[] maxTempPos = maximaTemperatura(temperaturas);

                    System.out.println("        < < < TEMPERATURA MÁXIMA > > >");
                    if (maxTempPos[0] != -1) {
                        System.out.println("->  " + temperaturas[maxTempPos[0]][maxTempPos[1]] + " (fila " + (maxTempPos[0] + 1) + ", columna " + (maxTempPos[1] + 1) + ")");
                    } else {
                        System.out.println("->  No existe una temperatura máxima");
                    }
                break;
                case '3':
                    int[] minTempPos = minimaTemperatura(temperaturas);

                    System.out.println("        < < < TEMPERATURA MÍNIMA > > >");
                    if (minTempPos[0] != -1) {
                        System.out.println("->  " + temperaturas[minTempPos[0]][minTempPos[1]] + " (fila " + (minTempPos[0] + 1) + ", columna " + (minTempPos[1] + 1) + ")");
                    } else {
                        System.out.println("->  No existe una temperatura mínima");
                    }
                break;
                case '4':
                    System.out.println("        < < < PROMEDIO > > >");
                    System.out.println("->  " + calcularPromedio(temperaturas));
                break;
                case '5':                
                    System.out.println("        < < < TEMPERATURAS MAYORES > > >");    
                    System.out.print("\nIngrese el valor mínimo: ");
                    valor = input.nextDouble();
                    input.nextLine(); // limpiar buffer (bug)
                    System.out.println("->  " + temperaturasMayores(temperaturas, valor));
                break;
                case '6':
                    int[][] zonasCalientes = zonasCalientes(temperaturas);
                    int longitud = 0;
                    while (zonasCalientes[longitud][0] != 0) {
                        longitud++;
                    }
                    
                    System.out.println("        < < < ZONAS CALIENTES > > >");
                    if (longitud != 0) {
                        for (int i = 0; i < longitud; i++) {
                            System.out.println("->  " + temperaturas[zonasCalientes[i][0]][zonasCalientes[i][1]]);
                        }
                    } else {
                        System.out.println("->  No se encuentran zonas calientes");
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

    public static double[][] llenarMatriz() {
        Scanner input = new Scanner(System.in);
        double[][] matriz;
        int filas, columnas;
        String texto = "";

        System.out.println("         < < < DETERMINAR MATRIZ > > >");
        System.out.print("Ingrese la cantidad de filas: ");
        filas = input.nextInt();

        System.out.print("Ingrese la cantidad de columnas: ");
        columnas = input.nextInt();
        matriz = new double[filas][columnas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("\n\033[H\033[2J");
                System.out.println("            < < < DETERMINAR VALORES > > >");
                System.out.println("Ingrese la temperatura (" + (i + 1) + "," + (j + 1) + ")");
                System.out.print(texto);
                matriz[i][j] = input.nextDouble();
                texto += matriz[i][j] + "     ";
            }
            texto += "\n";
        }

        return matriz;
    }
    
    // devuelve matriz en formato String
    public static void escribirMatriz(double[][] matriz) {
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

    // devuelve posición de la temperatura máxima o -1 en la posición 0 si no existe
    public static int[] maximaTemperatura(double[][] matriz) {
        int[] tempMaxPos = {0, 0};

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                if (matriz[i][j] > matriz[tempMaxPos[0]][tempMaxPos[1]]) {
                    tempMaxPos[0] = i;
                    tempMaxPos[1] = j;
                }
            }
        }

        return tempMaxPos;
    }
    
    // devuelve posición de la temperatura mínima o -1 en la posición 0 si no existe
    public static int[] minimaTemperatura(double[][] matriz) {
        int[] tempMinPos = {0, 0};
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                if (matriz[i][j] < matriz[tempMinPos[0]][tempMinPos[1]]) {
                    tempMinPos[0] = i;
                    tempMinPos[1] = j;
                } 
            }
        }

        return tempMinPos;
    }
    
    // suma todos los elementos y los divide por la cantidad
    public static double calcularPromedio(double[][] matriz) {
        double total = 0;
        int cantidad = 0;
        double resultado = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                total = total + matriz[i][j];
            }
        }
        cantidad = matriz.length * matriz[0].length;
        resultado = total / cantidad;

        return resultado;
    }
    
    // devuelve matriz con la posición de los elementos mayores a un valor
    public static int temperaturasMayores(double[][] matriz, double valor) {
        int contador = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > valor) {
                    contador++;
                }
            }
        }

        return contador;
    }

    // devuelve matriz con la posición de los puntos más grandes que sus vecinos inmediatos
    public static int[][] zonasCalientes(double[][] matriz) {
        int[][] zonasCalientes = new int[matriz.length][2];
        int contador = 0;
        int[][] vecinos = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        for (int i = 1; i < matriz.length - 1; i++) {
            for (int j = 1; j < matriz[0].length - 1; j++) {
                boolean zonaCaliente = true;
                int ni, nj;
                int k = 0;

                do {
                    ni = i + vecinos[k][0];
                    nj = j + vecinos[k][1];

                    if (matriz[i][j] <= matriz[ni][nj]) {
                        zonaCaliente = false;
                    }

                    k++;
                } while (zonaCaliente && k < vecinos.length);
            
                if (zonaCaliente) {
                    zonasCalientes[contador][0] = i;
                    zonasCalientes[contador][1] = j;
                    contador++;
                }
            }
        }

        return zonasCalientes;
    }
}