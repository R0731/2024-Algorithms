package BACKJOON.동적계획법연습문제;

import java.util.Arrays;
import java.util.Scanner;

public class S3_1463_1로만들기 {
    static int N;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 1];

        for(int i = 2; i <= N; i++){
            int min = dp[i - 1] + 1;
            if(i % 3 == 0) min = Math.min(dp[i / 3] + 1, min);
            if(i % 2 == 0) min = Math.min(dp[i / 2] + 1, min);
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }//main
}
