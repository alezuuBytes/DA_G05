public class E3a {
    public static void main(String[] args) {
        String texto = "locura";
        int i = 0;
        System.out.println(jeringoso(texto, i));
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