import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        int filas = 0, columnas = 0, caso = 0;
        double[][] temperaturas;
        
        System.out.println("< DETERMINAR MATRIZ >");
        System.out.print("Ingrese la cantidad de filas: ");
        filas = input.nextInt();

        System.out.print("Ingrese la cantida de columnas: ");
        columnas = input.nextInt();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        temperaturas = llenarMatriz(filas, columnas);

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("< MENÚ >");
            System.out.println("1. Imprimir matriz");
            System.out.println("2. Mostrar temperatura máxima");
            System.out.println("3. Mostrar temperatura mínima");
            System.out.println("4. Mostrar promedio");
            System.out.println("5. Mostrar puntos calientes");
            System.out.println("6. Mostrar zonas mayores a una temperatura");
            System.out.println("\n");
            System.out.print("Opción (0 para salir): ");
            caso = input.nextInt();

            switch (caso) {
                case 1:
                    mostrarMatriz(temperaturas);
                    input.nextLine();
                    break;
                case 2:
                    maximaTemperatura(temperaturas);
                    input.nextLine();
                    break;
                case 3:
                    minimaTemperatura(temperaturas);
                    input.nextLine();
                    break;
                case 4:
                    double promedio = promedio(temperaturas);
                    System.out.println("El promedio de la matriz es de " + promedio);
                    System.out.println();
                    input.nextLine();
                    break;
                case 5:
                    zonasCalientes(temperaturas);
                    input.nextLine();
                    break;
                case 6:
                    zonasX(temperaturas);
                    input.nextLine();
                    break;
                default:
                    if (caso != 0) {
                        System.out.println("Número no valido. Intente nuevamente");
                        input.nextLine();
                    } else {
                        System.out.println("Saliendo...");
                    }
                    break;
            }
        } while (caso != 0);

        input.close();
    }

    public static double[][] llenarMatriz(int filas, int columnas) {
        Scanner input = new Scanner(System.in);
        double[][] matriz = new double[filas][columnas];

        System.out.println("< DETERMINAR VALORES >");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Ingrese la temperatura (" + (i + 1) + "," + (j + 1) + "): ");
                matriz[i][j] = input.nextDouble();
            }
        }

        input.close();
        return matriz;
    }
    
    public static void mostrarMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void maximaTemperatura(double[][] matriz) {
        double tempMax = -1000;
        boolean seRepite = false;
        int fila = 0, columna = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > tempMax) {
                    seRepite = false;
                    tempMax = matriz[i][j];
                    fila = i;
                    columna = j;
                } else if (matriz[i][j] == tempMax) {
                    seRepite = true;
                }
            }
        }

        if (seRepite) {
            System.out.println("No existe temperatura máxima");
        } else {
           System.out.println("Temperatura máxima: " + tempMax + "\nPosicion: (" + (fila + 1) + "," + (columna + 1) + ")");
        }
    }
    
    public static void minimaTemperatura(double[][] matriz) {
        double tempMin = 1000;
        boolean seRepite = false;
        int fila = 0, columna = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] < tempMin) {
                    seRepite = false;
                    tempMin = matriz[i][j];
                    fila = i;
                    columna = j;
                } else if (matriz[i][j] == tempMin) {
                    seRepite = true;
                }
            }
        }

        if (seRepite) {
            System.out.println("No existe temperatura mínima");
        } else {
           System.out.println("Temperatura mínima: " + tempMin + "\nPosicion: (" + (fila + 1) + "," + (columna + 1) + ")");
        }
    }
    
    public static double promedio(double[][] matriz) {
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
    
    public static void zonasX(double[][] matriz) {
        Scanner input = new Scanner(System.in);
        double tempX = 0;
        boolean noMax = true;

        System.out.print("Ingrese la temperatura que desea:");
        tempX = input.nextDouble();
        System.out.println("\nTemperaturas que superan el valor " + tempX + ":");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (tempX < matriz[i][j]) {
                    System.out.println((i + j + 1) + ". " + matriz[i][j] + " (" + i + "," + j + ")");
                    noMax = false;
                }
            }
        }
        if (noMax) {
            System.out.println("(Ninguno)");
        }

        input.close();
    }

    public static void zonasCalientes(double[][] matriz) {
        int[][] direcciones = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                boolean puntCaliente = true;
                int k = 0;

                do {
                    int ni = i + direcciones[k][0];
                    int nj = j + direcciones[k][1];

                    if (ni >= 0 && ni < matriz.length && nj >= 0 && nj < matriz[0].length) {
                        if (matriz[ni][nj] >= matriz[i][j]) {
                            puntCaliente = false;
                        }
                    }

                    k++;
                } while (puntCaliente && k < direcciones.length);
            
                if (puntCaliente) {
                    System.out.println("En la posicion (" + i + ", " + j + ") hay un punto caliente");
                }
            }
        }
    }
}

