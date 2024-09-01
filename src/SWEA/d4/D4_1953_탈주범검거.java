package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1953_탈주범검거 {
    static int N, M, R, C, L;
    static int[][] tunnelMap;
    static boolean[][] visited;
    //상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] dir = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};

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
            visited = new boolean[N][M];

            for (int r = 0; r < N; r++) {
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    tunnelMap[r][c] = Integer.parseInt(line2.nextToken());
                }
            }

            int count = move(R, C);

            System.out.println("#" + tc + " " + count);
        }
    }

    private static int move(int startR, int startC){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 1});
        visited[startR][startC] = true;

        int count = 1;

        while(!queue.isEmpty()){
            int[] idx = queue.poll();
            int r = idx[0];
            int c = idx[1];
            int currentTime = idx[2];

            if(currentTime >= L){
                continue;
            }

            int n = tunnelMap[r][c];

            for(int i = 0; i < dir[n].length; i++){
                int d = dir[n][i];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && tunnelMap[nr][nc] != 0){
                    int n2 = tunnelMap[nr][nc];
                    if(possible(d, n2)){
                        queue.add(new int[]{nr, nc, currentTime + 1});
                        visited[nr][nc] = true;
                        count++;
                    }
                }
            }
        }

        return count;

    }

    private static  boolean possible(int direction, int n){
        switch (direction){
            case 0 : return n == 1 || n == 2 || n == 5 || n == 6; //상
            case 1 : return n == 1 || n == 2 || n == 4 || n == 7; //하
            case 2 : return n == 1 || n == 3 || n == 4 || n == 5; //좌
            case 3 : return n == 1 || n == 3 || n == 6 || n == 7; //우
            default: return false;
        }
    }
}
