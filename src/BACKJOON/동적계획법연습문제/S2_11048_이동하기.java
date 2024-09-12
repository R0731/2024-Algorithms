package BACKJOON.동적계획법연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_11048_이동하기 {
    static int N, M;
    static int[][] candy;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());

        candy = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for(int r = 1; r <= N; r++){
            line = new StringTokenizer(br.readLine());
            for(int c = 1; c <= M; c++){
                candy[r][c] = Integer.parseInt(line.nextToken());
            }
        }

        for(int r = 1; r <= N; r++){
            for(int c = 1; c <= M; c++){
                int max = Math.max(dp[r - 1][c], Math.max(dp[r][c - 1], dp[r - 1][c - 1]));
                dp[r][c] = candy[r][c] + max;
            }
        }

        System.out.println(dp[N][M]);
    }
}
