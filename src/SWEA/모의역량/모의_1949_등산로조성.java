package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 모의_1949_등산로조성 {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int start, ans;
    static boolean useK;
    //상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            start = 0;
            ans = 0;
            useK = true;

            for(int r = 0; r < N; r++){
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    map[r][c] = Integer.parseInt(line2.nextToken());
                    if(map[r][c] > start) start = map[r][c]; //가장 높은 봉우리에서 출발
                }
            }
            //초기화 작업 완료

            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    map[r][c] = start;
                    dfs(r, c, 0);
                }
            }
            //답안 출력
            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    private static void dfs(int r, int c, int currentSum){
//        System.out.println(useK + " " + r + " " + c);
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            //아직 깎을 수 있는 경우
            if(useK){
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]){
                    if(map[nr][nc] < map[r][c]){
                        visited[nr][nc] = true;
                        dfs(nr, nc, currentSum + 1);
                        visited[nr][nc] = false;
                    }else if(map[nr][nc] - K < map[r][c]){
                        useK = false;

                    }
                }
            }else{

            }

            if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] < map[r][c]){
                visited[nr][nc] = true;
                dfs(nr, nc, currentSum + 1);
                visited[nr][nc] = false;
            }else if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] >= map[r][c] && map[nr][nc] - K < map[r][c] && useK){
                map[nr][nc] -= K;
                useK = false;
                visited[nr][nc] = true;
                dfs(nr, nc, currentSum + 1);
                visited[nr][nc] = false;
                useK = true;
                map[nr][nc] += K;
            }else {
                ans = Math.max(currentSum, ans);
            }
        }

    }
}
