package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_13656_침투 {
    static int M, N;
    static boolean[][] graph;
    static boolean[][] visited;
    static boolean ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static void dfs(int r, int c){
        visited[r][c] = true;

        if(r == M - 1){
            ans = true;
            return;
        }

        int nr, nc;
        for(int d = 0; d < 4; d++){
            nr = r + dr[d];
            nc = c + dc[d];
            if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && graph[nr][nc]){
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());
        M = Integer.parseInt(line.nextToken());
        N = Integer.parseInt(line.nextToken());

        graph = new boolean[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            String line2 = br.readLine();
            char[] temp = line2.toCharArray();
            for(int j = 0; j < N; j++){
                if(temp[j] == '0'){
                    graph[i][j] = true;
                }else{
                    graph[i][j] = false;
                }
            }
        }

        for(int j = 0; j < N; j++) {
            if (!ans && graph[0][j] && !visited[0][j]) {
                dfs(0, j);
            }
        }

        System.out.println(ans? "YES": "NO");

    }

}
