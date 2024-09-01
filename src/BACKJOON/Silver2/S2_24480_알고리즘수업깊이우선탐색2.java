package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_24480_알고리즘수업깊이우선탐색2 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] ans;
    static int cnt;

    private static void dfs(int sidx){
        visited[sidx] = true;
        ans[sidx] = cnt;
        cnt++;

        for(int i = 0; i < graph[sidx].size(); i++) {
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
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        ans = new int[N + 1];
        cnt = 1;

        int u, v;
        for(int i = 0; i < M; i++){
            line = new StringTokenizer(br.readLine());
            u = Integer.parseInt(line.nextToken());
            v = Integer.parseInt(line.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}