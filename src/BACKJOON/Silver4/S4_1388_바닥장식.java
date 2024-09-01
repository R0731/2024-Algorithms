package BACKJOON.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1388_바닥장식 {
    static int N, M;
    static char[][] floor;
    static boolean[][] visited;

    private static void dfs(int r, int c){
        visited[r][c] = true;

        int nr, nc;

//        어차피 r, c 가 앞에 있는 부분부터 고려하니까
        if(floor[r][c] == '-') {
            nc = c + 1;
            if (nc < M && !visited[r][nc] && floor[r][nc] == '-'){
                dfs(r, nc);
            }
        }
        else{
            nr = r + 1;
            if (nr < N && !visited[nr][c] && floor[nr][c] == '|'){
                dfs(nr, c);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        //정보 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());
        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());

        floor = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String line2 = br.readLine();
            floor[i] = line2.toCharArray();
        }

        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
