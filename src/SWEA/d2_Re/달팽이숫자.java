package SWEA.d2_Re;

import java.util.Scanner;

public class 달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int[][] snail = new int[N][N];

            int n = 1;
            int r = 0;
            int c = 0;

            int[]dr = {0, 1, 0, -1};
            int[]dc = {1, 0, -1, 0};

            int dn = 0;

            while(n <= N * N){
                snail[r][c] = n;

                if(r + dr[dn] < 0 || r + dr[dn] >= N || c + dc[dn] < 0 || c + dc[dn] >= N || snail[r+dr[dn]][c+dc[dn]] != 0){
                    dn = (dn + 1) % 4;
                    r += dr[dn];
                    c += dc[dn];
                    n++;
                }else{
                    r += dr[dn];
                    c += dc[dn];
                    n++;
                }
            }

            System.out.println("#" + tc + " ");
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
