package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S2_1260_DFS와BFS {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited_dfs;
    static StringBuilder sb1 = new StringBuilder();
    static LinkedList<Integer> queue;
    static boolean[] visited_bfs;
    static StringBuilder sb2 = new StringBuilder();

    private static void dfs(int sidx){
        visited_dfs[sidx] = true;
        sb1.append(sidx).append(" ");

        for(int i = 0; i < graph[sidx].size(); i++) {
            int next = graph[sidx].get(i);
            if(!visited_dfs[next]){
                dfs(next);
            }
        }
    }

    private static void bfs(int sidx){
        queue = new LinkedList<>();
        visited_bfs = new boolean[N + 1];

        queue.add(sidx);
        visited_bfs[sidx] = true;

        while(!queue.isEmpty()){
            int idx = queue.remove(0);
            sb2.append(idx).append(" ");

            for(int i = 0; i < graph[idx].size(); i++){
                int next = graph[idx].get(i);
                if(!visited_bfs[next]){
                    queue.add(next);
                    visited_bfs[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());
        V = Integer.parseInt(line.nextToken());

        graph = new ArrayList[N + 1];
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

        visited_dfs = new boolean[N + 1];

        dfs(V);

        bfs(V);

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

    }
}
