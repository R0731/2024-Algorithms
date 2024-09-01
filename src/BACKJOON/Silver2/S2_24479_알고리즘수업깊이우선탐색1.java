package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_24479_알고리즘수업깊이우선탐색1 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt;
    static int[] count;

    private static void dfs(int sidx){
        visited[sidx] = true;
        count[sidx] = cnt;
        cnt++;

        for(int i = 0; i < graph[sidx].size(); i++){
            int next = graph[sidx].get(i);
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());
        R = Integer.parseInt(line.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        cnt = 1;
        count = new int[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        int x, y;
        for(int i = 0; i < M; i++){
            line = new StringTokenizer(br.readLine());
            x = Integer.parseInt(line.nextToken());
            y = Integer.parseInt(line.nextToken());
            graph[x].add(y);
            graph[y].add(x);

        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            sb.append(count[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
