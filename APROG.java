//L = quantidade de veículos
//C= dias do planeamento


import java.util.Scanner;

public class APROG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("entrega de medicamentos");
        int linhas = sc.nextInt(); int colunas = sc.nextInt();

        System.out.println("Digite a quantidade de dias de planeamento: ");
        int colunas = sc.nextInt();

        int[][] matriz = criarMatriz(linhas, colunas);

        preencherMatriz(matriz, sc);

        System.out.println("a) planeamento (km/dia/veículo)");
        mostrarMatriz(matriz);

        int[] totalKm = somaKm(matriz);
        System.out.println("Nº de Km percorridos por cada veículo: ");
        for (int i = 0; i < totalKm.length; i++) {
            System.out.println("Veículo" + i + ": " + totalKm[i] + "km");
        }

        int matrizrecargas=carregamentonecessaria(matriz)


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


    public static int[] carregamentonecessaria(int[][] matrizcarregamento) {
        int[] carregamento = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int[][] matrizcarregamento = new int[linhas][colunas];
                int kmpercorrido = matriz[i][j];
                int bateria = 0;
                int regargas = 0;
                while (kmpercorrido > 100) {
                    regargas++;
                    kmpercorrido = kmpercorrido - 100;
                }
                if (kmpercorrido > 0) {
                    regargas++;
                }
                matrizcarregamento[i][j] = kmpercorrido;
            }
        }
        return matrizcarregamento;
    }
    public static int[] matrizrecarga (int[][] matrizcarregamento) {
        for (int i = 0; i < matrizcarregamento.length; i++) {
            for (int j = 0; j < matrizcarregamento[i].length; j++) {
                System.out.println(matrizcarregamento[i][j] + " ");
            }
            System.out.println();
        }
    }



}