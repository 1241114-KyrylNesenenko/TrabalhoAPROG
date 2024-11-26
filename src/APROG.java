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
                matriz[i][j] = sc.nextInt();
            }
        }
    }


    public static void mostrarMatriz(int[][] matriz, String alinea) {
        //Cabeçalho
        System.out.println(alinea);

        System.out.print("dia :");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.printf("%7d",j);
            System.out.print(" ");
        }
        System.out.println();

        //Divisões
        System.out.print("----|");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print("-------|");
        }
        System.out.println();

        //Mostrar valores
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("V%1d  :",i);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%8d",matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] somaKm(int[][] matriz) {
        int[]Km = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            int soma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }
            Km[i] = soma;
        }
        return Km;
    }

    public static void mostrarKm(int[] Km, String alinea) {
        System.out.println(alinea);
        for (int i = 0; i < Km.length; i++) {
            System.out.println("V" + i + " :"+Km[i]+"km");
            }
        System.out.println();
    }





    public static int[][] carregamentoNecessaria( int [][] matriz) {
        int[][] recargasDiarias = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int kmPercorrido = matriz[i][j];
                int recargas = 0;

                while (kmPercorrido > 100) {
                    recargas++;
                    kmPercorrido = kmPercorrido - 100;
                }
                if (kmPercorrido > 0) {
                    recargas++;
                }
                recargasDiarias[i][j] = recargas;
            }
        }
        return recargasDiarias;
    }



    public static void mostrarRecarga(int [][]recargasDiarias, String alinea) {
        System.out.println(alinea);

        System.out.print("dia :");
        for (int j = 0; j < recargasDiarias[0].length; j++) {
            System.out.printf("%8d",j);
        }
        System.out.println();

        System.out.print("----|");
        for (int j = 0; j < recargasDiarias[0].length; j++) {
            System.out.print("-------|");
        }
        System.out.println();

        for (int i = 0; i < recargasDiarias.length; i++) {
            System.out.printf("V%1d  :", i);
            for (int j = 0; j < recargasDiarias[i].length; j++) {
                System.out.printf("%8d", recargasDiarias[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] nivelBateria (int [][] matriz) {
        double[][] bateriaRestante = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int kmPercorrido = matriz[i][j];
                double bateria = (100 - (kmPercorrido));
                if (bateria < 0) {
                    bateria += 100;
                    bateriaRestante[i][j] = bateria;
                }
                if (bateria > 0) {
                    bateriaRestante[i][j] = bateria;
                }
                bateriaRestante[i][j] = bateria;
            }
        }
        return bateriaRestante;
    }

    public static void mostrarBateriaRestante (double[][] bateriaRestante, String alinea) {
        System.out.println(alinea);

        System.out.print("dia :");
        for (int j = 0; j < bateriaRestante[0].length; j++) {
            System.out.printf("%8d",j);
        }
        System.out.println();

        System.out.print("----|");
        for (int j = 0; j < bateriaRestante[0].length; j++) {
            System.out.print("-------|");
        }
        System.out.println();

        for (int i = 0; i < bateriaRestante.length; i++) {
            System.out.printf("V%d  :", i);
            for (int j = 0; j < bateriaRestante[i].length; j++) {
                System.out.printf("%7.1f%%", bateriaRestante[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static double[] mediaDiaria (int [][] matriz) {
        double[] media = new double[matriz[0].length];
        for (int j = 0; j < matriz[0].length; j++) {
            int soma = 0;
            for (int i = 0; i < matriz.length; i++) {
                soma += matriz[i][j];
            }
            media[j] = soma /(double) matriz.length;
        }
        return media;
    }

    public static void mostrarMediaKmDiaria (double[] media, String alinea) {
        System.out.println(alinea);

        System.out.print("dia :");
        for (int j = 0; j < media.length; j++) {
            System.out.printf("%8d",j);
        }
        System.out.println();

        System.out.print("----|");
        for (int i = 0; i < media.length; i++) {
            System.out.print("-------|");
        }
        System.out.println();

            System.out.printf("km :");
            for (int j = 0; j < media.length; j++) {
                System.out.printf("%8.1f", media[j]);
            }
            System.out.println();
    }









    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String funcao=sc.nextLine();
        int linhas = sc.nextInt(); int colunas = sc.nextInt();
        int[][] matriz = criarMatriz(linhas, colunas);


        //a)
        preencherMatriz(matriz, sc);
        mostrarMatriz(matriz, "a) planeamento (km/dia/veículo)");

        //b)
        mostrarKm(somaKm(matriz),"b) total de km a percorrer");

        //c)
        mostrarRecarga(carregamentoNecessaria(matriz), "c) recargas das baterias");

        //d)
        mostrarBateriaRestante(nivelBateria(matriz),"d) carga das baterias");

        //e)
        mostrarMediaKmDiaria(mediaDiaria(matriz),"e) média de km diários da frota" );









        sc.close();
    }

}
