package SWEA.d2_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자배열회전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] nemo = new int[N][N];

            for (int r = 0; r < N; r++) {
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    nemo[r][c] = Integer.parseInt(line2.nextToken());
                }
            }

            //90도
            int[][] nemo1 = new int[N][N];

            for(int r = 0; r < N; r++){
                int n = N - 1;
                for(int c = 0; c < N; c++){
                    nemo1[r][c] = nemo[n][r];
                    n--;
                }
            }

            //180도
            int[][] nemo2 = new int[N][N];

            int m = N - 1;

            for(int r = 0; r < N; r++){
                int n = N - 1;
                for(int c = 0; c < N; c++){
                    nemo2[r][c] = nemo[m][n];
                    n--;
                }
                m--;
            }

            //270도
            int[][] nemo3 = new int[N][N];

            int a = N - 1;

            for(int r = 0; r < N; r++){
                int n = 0;
                for(int c = 0; c < N; c++){
                    nemo3[r][c] = nemo[n][a];
                    n++;
                }
                a--;
            }

            System.out.println("#" + tc);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(nemo1[i][j]);
                }
                    System.out.print(" ");
                for(int j = 0; j < N; j++){
                    System.out.print(nemo2[i][j]);
                }
                    System.out.print(" ");
                for(int j = 0; j < N; j++){
                    System.out.print(nemo3[i][j]);
                }
                System.out.println();
            }
        }
    }
}
