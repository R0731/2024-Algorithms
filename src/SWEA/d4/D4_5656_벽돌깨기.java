package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_5656_벽돌깨기 {
    static int N, W, H;
    static int[][] map;
    static int[][] mapAns;
    static int[] ball;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count, max;
    static int brick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            W = Integer.parseInt(line.nextToken());
            H = Integer.parseInt(line.nextToken());

            map = new int[H][W];
            mapAns = new int[H][W];
            ball = new int[N];
            max = 0;
            brick = 0;

            for (int r = 0; r < H; r++) {
                line = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    int a = Integer.parseInt(line.nextToken());
                    map[r][c] = a;
                    if(a > 0) brick++;
                }
            }

            perm(0);

            System.out.println("#" + tc + " " + (brick - max));
        }
    }

    private static void perm(int sidx) {
        if (sidx == N) {
            count = 0;
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    mapAns[r][c] = map[r][c];
                }
            }
//            System.out.println(Arrays.toString(ball));
            for (int i = 0; i < N; i++) {
                int nextC = ball[i];
                int nextR = -1;
                for (int j = 0; j < H; j++) {
                    if (mapAns[j][nextC] > 0) {
                        nextR = j;
                        break;
                    }
                }

                if(nextR == -1){
                    continue;
                }

                shoot(nextR, nextC, mapAns[nextR][nextC]);
                move();
            }

            if(count > max){
                max = count;
            }
            return;
        }

        for (int i = 0; i < W; i++) {
            ball[sidx] = i;
            perm(sidx + 1);
        }
    }

    private static void shoot(int r, int c, int range) {
//        System.out.println("#제거벽돌 : " + r + " " + c);
        if (mapAns[r][c] > 0) {
            int temp = mapAns[r][c];
            mapAns[r][c] = 0;
            count++;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;

            for (int i = 1; i < range; i++) {
                nr += dr[d];
                nc += dc[d];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W && mapAns[nr][nc] != 0) {
                    shoot(nr, nc, mapAns[nr][nc]);
                }
            }

        }
    }

    private static void move(){
        for(int j = 0; j < W; j++){
            int emptyRow = H - 1;

            for(int i = H - 1; i >= 0; i--){
                if(mapAns[i][j] > 0){
                    if(i != emptyRow) {
                        mapAns[emptyRow][j] = mapAns[i][j];
                        mapAns[i][j] = 0;
                    }
                    emptyRow--;
                }
            }
        }
    }
}