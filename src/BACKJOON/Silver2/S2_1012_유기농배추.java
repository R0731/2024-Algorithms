package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1012_유기농배추 {
    static int M, N, K;
    static boolean[][] farm;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static void dfs(int r, int c){
        visited[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && farm[nr][nc]){
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());

            farm = new boolean[N][M];
            visited = new boolean[N][M];

            boolean first = false;

            int x, y;
            for(int i = 0; i < K; i++){
                line = new StringTokenizer(br.readLine());
                x = Integer.parseInt(line.nextToken());
                y = Integer.parseInt(line.nextToken());
                farm[x][y] = true;
            }

            int count = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(farm[i][j] && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
