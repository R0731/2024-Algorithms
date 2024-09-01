package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_4963_섬의개수 {
    static int w, h;
    static boolean[][] map;
    static boolean[][] visited;
    //상 하 좌 우 대각선방향으로 위좌 위우 아래좌 아래우
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    private static void dfs(int r, int c){
        visited[r][c] = true;

        int nr, nc;
        for(int d = 0; d < 8; d++){
            nr = r + dr[d];
            nc = c + dc[d];
            if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc]){
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            w = Integer.parseInt(line.nextToken());
            h = Integer.parseInt(line.nextToken());

            map = new boolean[h][w];
            visited = new boolean[h][w];


            if(h == 0 && w == 0){
                break;
            }

            for(int i = 0; i < h; i++){
                line = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    int temp = Integer.parseInt(line.nextToken());
                    if (temp == 1) {
                        map[i][j] = true;
                    }
                }
            }

            int island = 0;

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++) {
                    if(map[i][j] && !visited[i][j]){
                        dfs(i, j);
                        island++;
                    }
                }
            }
            System.out.println(island);
        }
    }
}
