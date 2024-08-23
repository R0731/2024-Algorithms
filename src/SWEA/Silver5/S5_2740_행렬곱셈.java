package SWEA.Silver5;

import java.util.Scanner;

public class S5_2740_행렬곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] A = new int[N][M];

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                A[r][c] = sc.nextInt();
            }
        }

        int M2 = sc.nextInt();
        int K = sc.nextInt();

        int[][] B = new int[M2][K];

        for(int r = 0; r < M2; r++){
            for(int c = 0; c < K; c++){
                B[r][c] = sc.nextInt();
            }
        }

        int[][] ans = new int[N][K];

        for(int r = 0; r < N; r++){
            for(int c = 0; c < K; c++){
                ans[r][c] = A[r][c] * B[c][r];
            }
        }


    }
}
