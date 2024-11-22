import java.util.Scanner;

public class Trabalho {

    //Cria a matriz
    public static int[][] criarMatriz(int numLinhas,int numColunas){
        return new int[numLinhas][numColunas];
    }

    //Preenche a matriz
    public static int[][] preencherMatriz(int[][] planeamento, int numLinhas, int numColunas, Scanner sc){

        for (int linha = 0; linha < numLinhas; linha++) {
            for (int coluna = 0; coluna < numColunas; coluna++) {
                planeamento[linha][coluna] = sc.nextInt();
            }
        }
        return planeamento;
    }

    //Imprime a matriz e a informação relativa à mesma
    public static void mostrarMatriz(int[][] planeamento, int numLinhas, int numColunas, String descritivo){
        System.out.println("a) " + descritivo + " (km/dia/veículo)");

        //Cabeçalho
        System.out.print("dia :");
        for (int coluna = 0; coluna < numColunas; coluna++) {
            System.out.printf("%7d",coluna);
            System.out.print(" ");
        }
        System.out.println();

        //Linha de Separação
        System.out.print("----|");
        for ( int coluna = 0; coluna < numColunas; coluna++) {
            System.out.print("-------|");
        }
        System.out.println();

        //Valores da variável "preenchimento"
        for (int linha = 0; linha < numLinhas; linha++) {
            System.out.printf("V%d  :",linha);
            for (int coluna = 0; coluna < numColunas; coluna++) {
                for (int i = 0; i < 7- numLength(planeamento, linha, coluna); i++) {
                    System.out.print(" ");
                }
                System.out.print(planeamento[linha][coluna]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //Calcula o comprimento dos números do array, convertendo-o em string
    public static int numLength(int[][] planeamento, int linha, int coluna){
        int num = planeamento[linha][coluna];
        return String.valueOf(Math.abs(num)).length();
    }

    //Secção de comandos
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String descritivo = sc.nextLine();
        final int numLinhas = sc.nextInt();
        final int numColunas = sc.nextInt();

        int[][] planeamento = criarMatriz(numLinhas,numColunas);
        preencherMatriz(planeamento,numLinhas,numColunas, sc);
        mostrarMatriz(planeamento,numLinhas,numColunas,descritivo);

        //Encerra o Scanner que foi imported no início
        sc.close();
    }
}
