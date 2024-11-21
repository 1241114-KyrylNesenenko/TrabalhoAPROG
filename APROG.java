//L = quantidade de veículos
//C= dias do planeamento


import java.util.Scanner;

public class trabalho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de veículos: ");
        int linhas = sc.nextInt();

        System.out.println("Digite a quantidade de dias de planeamento: ");
        int colunas = sc.nextInt();

        int[][] matriz = criarMatriz(linhas, colunas);

        preencherMatriz(matriz, sc);

        System.out.println("Matriz é essa");
        mostrarMatriz(matriz);

        int[] totalKm = somaKm(matriz);
        System.out.println("Nº de Km percorridos por cada veículo: ");
        for (int i = 0; i < totalKm.length; i++) {
            System.out.println("Veículo" + i + ": " + totalKm[i] + "km");
        }


        sc.close();


    }

    public static int[][] criarMatriz(int linhas, int colunas) {
        return new int[linhas][colunas];

    }

    public static void preencherMatriz(int[][] matriz, Scanner sc) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Insira [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] somaKm(int[][] matriz) {
        int[] Km = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            int soma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }
            Km[i] = soma;
        }
        return Km;
    }

    public static int[] carganecessaria(int[][] matriz) {
        int[] carregamento = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {



        }
    }


}