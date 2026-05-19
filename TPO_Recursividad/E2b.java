public class E2b {
    public static void main(String[] args) {
        int[][] matriz = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int i = 0;

        System.out.println(sumaDiagonal(matriz, i));
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