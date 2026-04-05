import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);      
        int filas = 0, columnas = 0;
        double[][] temperaturas;
        
        System.out.print("ingrese la cantidad de filas: ");
        filas = input.nextInt();
        System.out.print("ingrese la cantida de columnas: ");
        columnas = input.nextInt();
        temperaturas = llenarMatriz(filas, columnas);

        mostrarMatriz(temperaturas);
        maximaTemperatura(temperaturas);
        minimaTemperatura(temperaturas);
        promedio(temperaturas);
        zonasX(temperaturas);
    }

    public static double[][] llenarMatriz(int filas, int columnas) {
        Scanner input = new Scanner(System.in);
        double[][] matriz = new double[filas][columnas];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("\nIngrese la temperatura (" + i + "," + j + "): ");
                matriz[i][j] = input.nextDouble();
            }
        }

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
        double tempMax = 0;
        int fila = 0, columna = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > tempMax) {
                    tempMax = matriz[i][j];
                    fila = i;
                    columna = j;
                }
            }
        }

        System.out.println("La máxima temperatura es: " + tempMax + " en la posición (" + fila + "," + columna + ")");
    }
    
    public static void minimaTemperatura(double[][] matriz) {
        // consultar si se puede devolver 
        double tempMin = 0;
        int fila = 0, columna = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] < tempMin) {
                    tempMin = matriz[i][j];
                    fila = i;
                    columna = j;
                }
            }
        }

        System.out.println("la minima temperatura es: " + tempMin + "en la posicion:(" + fila + "," + columna + ") ");
    }
    
    public static double promedio(double[][] matriz){
        double total=0;
        int cantidad=0;
        double resultado=0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                total=total+matriz[i][j];
            }
        }

        cantidad = matriz.length * matriz[0].length;
        resultado = total / cantidad;

        return resultado;
    }
    
    public static void zonasX(double[][] matriz) {
        Scanner input = new Scanner(System.in);
        double tempX = 0;
        int fila, columna;

        System.out.println("ingrese la temperatura que desea");
        tempX = input.nextDouble();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (tempX < matriz[i][j]){
                    fila = i;
                    columna = j;
                    System.out.println("el valor en la posicion:(" + fila + "," + columna + ") supera la temperatura" + tempX);
                }
            }
        }
    }

    public static double[][] findHotPoints() {};
}