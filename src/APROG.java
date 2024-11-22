//L = quantidade de veículos
//C= dias do planeamento

import java.util.Scanner;

public class APROG {


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



    public static int[] carregamentoNecessaria( int [][] matriz) {

        int[] carregamento = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {

            int recargas =0;

            for (int j = 0; j < matriz[i].length; j++) {


                int[][] matrizCarregamento = new int[i][j];
                int kmPercorrido = matriz[i][j];


                while (kmPercorrido > 100) {
                    recargas++;
                    kmPercorrido = kmPercorrido - 100;
                }
                if (kmPercorrido > 0) {
                    recargas++;
                }
            }
            carregamento[i] = recargas;
        }
        return carregamento;
    }
    public static void matrizRecarga (int[][] matrizCarregamento) {
        for (int i = 0; i < matrizCarregamento.length; i++) {
            for (int j = 0; j < matrizCarregamento[i].length; j++) {
                System.out.println(matrizCarregamento[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("entrega de medicamentos");
        int linhas = sc.nextInt(); int colunas = sc.nextInt();


        int[][] matriz = criarMatriz(linhas, colunas);

        preencherMatriz(matriz, sc);

        System.out.println("a) planeamento (km/dia/veículo)");
        mostrarMatriz(matriz);

        int[] totalKm = somaKm(matriz);
        System.out.println("Nº de Km percorridos por cada veículo: ");
        for (int i = 0; i < totalKm.length; i++) {
            System.out.println("Veículo" + i + ": " + totalKm[i] + "km");
        }




        sc.close();
    }

}
