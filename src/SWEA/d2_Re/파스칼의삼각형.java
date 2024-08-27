package SWEA.d2_Re;

import java.util.Scanner;

public class 파스칼의삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int[][] triangle = new int[N][N];

            triangle[0][0] = 1;

            for(int r = 1; r < N; r++){
                for(int c = 0; c < N; c++) {
                    if(c == 0){
                        triangle[r][c] = 1;
                    }else{
                        triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
                    }
                }
            }

            System.out.println("#" + tc + " ");
            for(int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(triangle[r][c] != 0){
                        System.out.print(triangle[r][c] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
