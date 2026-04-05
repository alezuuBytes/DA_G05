import java.util.Scanner;

public class E16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cant;
        double mayorSueldo = 0, valorPedido;
        String mayorNombre = "", nombre, in;
        String[] nombres;
        double[] sueldos;

        System.out.print("Ingrese la cantidad de empleados: ");
        cant = input.nextInt();

        nombres = new String[cant];
        sueldos = new double[cant];

        for (int i = 0; i < cant; i++) {
            input.nextLine(); // limpiar buffer (bug del Scanner)

            System.out.print("Nombre del empleado " + (i+1) + ": ");
            nombre = input.nextLine();
            nombres[i] = nombre;
            
            System.out.print("Sueldo de " + nombre + ": ");
            sueldos[i] = input.nextDouble();

            if (sueldos[i] > mayorSueldo) {
                mayorSueldo = sueldos[i];
                mayorNombre = nombre;
            }
        }

        do {
            input.nextLine(); // limpiar buffer (bug del Scanner)
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n< MENU >");
            System.out.println("1. Consultar empleado con mayor sueldo");
            System.out.println("2. Listar empleados con el sueldo consultado");
            System.out.println("3. Aumentar 10% a los empleados con sueldo menor a $10.000 (10 mil)");
            System.out.println("4. Consultar sueldo");
            System.out.println("5. Salir");
            System.out.print("\nIngrese una opción: ");
            in = input.nextLine();

            switch (in) {
                case "1":
                    System.out.println("El empleado con mayor sueldo es " + mayorNombre + " con un total de $" + mayorSueldo + ":");

                    input.nextLine();
                    break;

                case "2":
                    System.out.print("Ingrese el sueldo buscado (sin el signo $ y usar \".\" para decimales): ");
                    valorPedido = input.nextDouble();
                    System.out.println("Empleados con sueldo de $" + valorPedido);

                    for (int i = 0; i < sueldos.length; i++) {
                        if (sueldos[i] == valorPedido) {
                            System.out.println("> " + nombres[i]);
                        }
                    }

                    input.nextLine();
                    break;

                case "3":
                    aumentarSueldo(sueldos, 10000, 0.1);
                    System.out.println("Se aumentó un 10% a los empleados correspondientes!");

                    input.nextLine();
                    break;

                case "4":
                    String empleado;    
                    int posEmpleado;

                    System.out.print("Ingrese el empleado buscado: ");
                    empleado = input.nextLine();
                    posEmpleado = encontrarValor(nombres, empleado);
                    System.out.println("El sueldo de " + empleado + " es de $" + sueldos[posEmpleado]);
                
                    input.nextLine();
                    break;
            }
        } while (in != "5");

        input.close(); // se evita la advertencia "Resource leak: 'input' is never closed"
    }

    public static void aumentarSueldo(double[] sueldos, double valor, double aumento) {
        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i] < valor) {
                sueldos[i] *= aumento;
            }
        }
    }

    public static int encontrarValor(String[] arr, String valor) {
        int i = 0;
        
        while (i < arr.length && arr[i] != valor) { // asumimos que el nombre del empleado no se repite ni se debería repetir
            i++;
        }

        return i;
    }
}
