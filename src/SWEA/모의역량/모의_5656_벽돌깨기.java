package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_5656_벽돌깨기 {
    static int N, W, H; // 구슬을 쏘는 횟수, 넓이, 높이
    static int[][] map;
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans; //남아있는 벽돌의 수(가장 작은 경우)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            W = Integer.parseInt(line.nextToken());
            H = Integer.parseInt(line.nextToken());
            map = new int[H][W];
            ans = Integer.MAX_VALUE;
            for(int r = 0; r < H; r++){
                line = new StringTokenizer(br.readLine());
                for(int c = 0; c < W; c++){
                    map[r][c] = Integer.parseInt(line.nextToken());
                }
            }
//            -------------------------초기화 완료------------------------
            shoot(0);

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    private static void shoot(int sidx){
        if(sidx == N){
            int count = 0;
            for(int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (map[r][c] != 0) {
                        count++;
                    }
                }
            }
            ans = Math.min(ans, count);
            return;
        }
        //맵 복사본
        int[][] temp = new int[H][W];
        for(int r = 0; r < H; r++){
            for(int c = 0; c < W; c++){
                temp[r][c] = map[r][c];
            }
        }

        for(int i = 0; i < W; i++){
            int h = firstBrick(i);
            if(h == -1) continue;
            destroy(h, i);
            move();
            int count = 0;
            for(int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (map[r][c] != 0) {
                        count++;
                        break;
                    }
                }
                if(count > 0) break;
            }
            if(count == 0) {
                ans = 0;
                return;
            }
            shoot(sidx + 1);
            //맵 복구
            for(int r = 0; r < H; r++){
                for(int c = 0; c < W; c++){
                    map[r][c] = temp[r][c];
                }
            }
        }
    }//shoot

    private static int firstBrick(int c){
        for(int r = 0; r < H; r++){
            if(map[r][c] > 0){
                return r;
            }
        }
        return -1;
    }
    private static void destroy(int r, int c){
        int num = map[r][c] - 1;
        map[r][c] = 0;
        for (int d = 0; d < 4; d++) {
            for(int i = 1; i <= num; i++) {
                int nr = r + (dr[d] * i);
                int nc = c + (dc[d] * i);
                if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0){
                    destroy(nr, nc);
                }
            }
        }
    }

    private static void move(){
        for(int c = 0; c < W; c++) {
            for(int r = H - 1; r >= 0; r--){
                if(map[r][c] == 0){
                    for(int k = r - 1; k >= 0; k--){
                        if(map[k][c] != 0){
                            map[r][c] = map[k][c];
                            map[k][c] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
}
