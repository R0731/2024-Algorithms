package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_11724_연결요소의개수 {
    static int N, M, ans;
    static boolean[][] graph;
    static boolean[] visited;

    private static void dfs(int sidx){

        for(int i = 1; i <= N; i++){
            if(!visited[i] && graph[sidx][i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(br.readLine());

        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());
        ans = 0;

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        int x, y;
        for(int i = 0; i < M; i++){
            line = new StringTokenizer(br.readLine());
            x = Integer.parseInt(line.nextToken());
            y = Integer.parseInt(line.nextToken());
            graph[x][y] = graph[y][x] = true;
        }

        int idx = 1;
        while(idx <= N){
            if(!visited[idx]){
                dfs(idx);
                ans++;
            }
            idx++;
        }

        System.out.println(ans);
    }
}
