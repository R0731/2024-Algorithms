package BACKJOON.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2606_바이러스 {
    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer;

    private static void dfs(int sidx){
        answer++;
        visited[sidx] = true;

        for(int i = 1; i <= N; i++){
            if(!visited[i] && graph[sidx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = 0;

        int a, b;
        for(int i = 0; i < M; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            a = Integer.parseInt(line.nextToken());
            b = Integer.parseInt(line.nextToken());

            graph[a][b] = graph[b][a] = true;
        }

        dfs(1);

        System.out.println(answer - 1);
    }
}
