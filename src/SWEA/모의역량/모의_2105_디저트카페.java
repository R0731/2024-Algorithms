package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 모의_2105_디저트카페 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] dessert; //이미 먹은 디저트 종류
    //하좌, 하우, 상우, 상좌
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {-1, 1, 1, -1};
    static int startR, startC; //시작지점
    static int ans; //가장 많이 먹은 디저트수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            map = new int[N][N];
            ans = 0;

            int dessertNum = 1;
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    map[r][c] = sc.nextInt();
                    if(map[r][c] > dessertNum) dessertNum = map[r][c];
                }
            }

            visited = new boolean[N][N];
            dessert = new boolean[dessertNum + 1];
//            ------------------초기화 완료----------------------

            for(int r = 0; r < N - 1; r++){ //시작해도 마름모를 만들 수 없는 부분 제외
                for(int c = 1; c < N - 1; c++){
                    startR = r;
                    startC = c;
                    dfs(r, c, 0, 1);
                }
            }

            if(ans == 0) ans = -1;

            System.out.println("#" + tc+ " " + ans);
        }//tc
    }//main

    private static void dfs(int r, int c, int d, int count){
        if(d >= 4){
            return;
        }

        visited[r][c] = true;
        dessert[map[r][c]] = true;

        int nr = r + dr[d];
        int nc = c + dc[d];

        if(d == 3 && nr == startR && nc == startC) {
            if(count > ans) ans = count;
            //return하기 전에 백트래킹
            visited[r][c] = false;
            dessert[map[r][c]] = false;
            return;
        }

        if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && !dessert[map[nr][nc]]) {
            dfs(nr, nc, d, count + 1);
            dfs(nr, nc, d + 1, count + 1);
        }

        //return하기 전에 백트래킹
        visited[r][c] = false;
        dessert[map[r][c]] = false;
    }//dfs
}
