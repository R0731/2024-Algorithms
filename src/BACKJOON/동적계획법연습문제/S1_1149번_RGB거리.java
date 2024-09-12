package BACKJOON.동적계획법연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1149번_RGB거리 {
    static int N;
    static int[][] color;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        color = new int[N + 1][3];
        dp = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                color[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        dp[1][0] = color[1][0]; //빨간색
        dp[1][1] = color[1][1]; //초록색
        dp[1][2] = color[1][2]; //파란색

        for(int i = 2; i <= N; i++){
            dp[i][0] = color[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = color[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = color[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }//main
}
