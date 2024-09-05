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
    //상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            start = 0;
            ans = 0;

            for (int r = 0; r < N; r++) {
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(line2.nextToken());
                    if (map[r][c] > start) start = map[r][c]; //가장 높은 봉우리에서 출발
                }
            }
            //초기화 작업 완료

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (start == map[r][c]) {
                        dfs(r, c, 1, true);
                    }
                }
            }
            //답안 출력
            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    private static void dfs(int r, int c, int currentSum, boolean useK) {
//        System.out.println("조회 : " + r + " " + c + " " + currentSum + " " + useK);
        if (currentSum > ans) ans = currentSum;

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                if (map[nr][nc] < map[r][c]) {
                    dfs(nr, nc, currentSum + 1, useK);
                } else if (useK && map[nr][nc] - K < map[r][c]) { //깎을 수 있고 깎으면 갈 수 있는 경우
                    int temp = map[nr][nc];
                    map[nr][nc] = map[r][c]- 1; //최대 k만큼 깎을 수 있으므로 현재 값보다 딱 1만큼만 작게 깎아야 더 많이 돌 수 있다
                    dfs(nr, nc, currentSum + 1, false);
                    map[nr][nc] = temp;
                }
            }
        }
        visited[r][c] = false;
    }//dfs
}
