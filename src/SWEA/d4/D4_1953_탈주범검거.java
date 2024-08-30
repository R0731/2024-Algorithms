package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1953_탈주범검거 {
    static int N, M, R, C, L;
    static int[][] tunnelMap;
    static boolean[][] check;
    //상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            R = Integer.parseInt(line.nextToken());
            C = Integer.parseInt(line.nextToken());
            L = Integer.parseInt(line.nextToken());

            tunnelMap = new int[N][M];
            check = new boolean[N][M];

            for (int r = 0; r < N; r++) {
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    tunnelMap[r][c] = Integer.parseInt(line2.nextToken());
                }
            }

            move(R, C, 0);

            System.out.println("#" + tc + " ");
        }
    }

    private static void move(int r, int c, int currentTime){
        if(currentTime == L){
            return;
        }

        if(tunnelMap[r][c] != 0){
            check[r][c] = true;
            move()
        }
    }
}
