package BACKJOON.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//왜 visited를 쓰는 게 더 시간이 줄어드는 효과가 나올까? 어차피 오른쪽과 아래로만 움직일 수 있잖아 다시 그 곳을 방문할 이유가 없는데 왜지??


public class S4_16173_점프왕쩰리 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean ans;

    private static void dfs(int r, int c){
        if(map[r][c] == -1){
            ans = true;
            return;
        }

        visited[r][c] = true;

        int next = map[r][c];
        int nr = r + next;
        int nc = c + next;

        if(nr < N && !visited[nr][c]){
            dfs(nr, c);
        }
        if(nc < N && !visited[r][nc]){
            dfs(r, nc);
        }

    }

    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        ans = false;

        for(int i = 0; i < N; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(line.nextToken());
                map[i][j] = temp;
            }
        }

        dfs(0, 0);

        System.out.println(ans? "HaruHaru" : "Hing");
    }
}
