package BACKJOON.동적계획법연습문제;

import java.util.Scanner;

public class S3_9095_123더하기 {
    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            dp = new int[N + 1];

            dp[1] = 1;
            if (N >= 2) dp[2] = 2;
            if (N >= 3) dp[3] = 4;
            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }

            System.out.println(dp[N]);
        }
    }
}
