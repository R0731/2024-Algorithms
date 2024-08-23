package SWEA.Silver5;

import java.util.Arrays;
import java.util.Scanner;

public class S5_2167_2차원배열의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] nemo = new int[N][M];

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                nemo[r][c] = sc.nextInt();
            }
        }

        //구해야 하는 답의 갯수
        int K = sc.nextInt();

        //구해야 하는 조건
        for(int n = 0; n < K; n++){
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            int sum = 0;

            for(int r = i; r <= x; r++){
                for(int c = j; c <= y; c++){
                    sum += nemo[r][c];
                }
            }
            System.out.println(sum);
        }

    }
}
