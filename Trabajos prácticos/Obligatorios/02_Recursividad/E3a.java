import java.util.Scanner;

public class E3a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String texto;
        String textoJeringoso;

        System.out.print("Ingrese el texto que desea convertir: ");
        texto = input.nextLine().toLowerCase();
        textoJeringoso = jeringoso(texto, 0);

        System.out.println("Texto: " + texto + "\nJeringoso: " + textoJeringoso);
    }
    
    public static String jeringoso(String texto, int i){
        String resultado = "";

        if (i < texto.length()) {
            if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u') {
                resultado = texto.charAt(i) + "p" + texto.charAt(i) + jeringoso(texto, i + 1);
            } else {
                resultado = texto.charAt(i) + jeringoso(texto, i + 1);
            }
        }

        return resultado;
    }
}