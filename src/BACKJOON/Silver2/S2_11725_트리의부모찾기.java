package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_11725_트리의부모찾기 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] ans;

    private static void dfs(int sidx, int root){
        visited[sidx] = true;
        ans[sidx] = root;

        for(int i = 0; i < graph[sidx].size(); i++){
            int next = graph[sidx].get(i);
            if(!visited[next]){
                dfs(next, sidx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        int x, y;
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            x = Integer.parseInt(line.nextToken());
            y = Integer.parseInt(line.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new boolean[N + 1];
        ans = new int[N + 1];

        dfs(1, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++){
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
