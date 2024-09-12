package BACKJOON.동적계획법연습문제;

import java.util.Arrays;
import java.util.Scanner;

public class S3_11726_2xn타일링 {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n + 1];
        dp[1] = 1;
        if(n > 1) dp[2] = 2;

        for(int i = 3; i <= n; i++){
           dp[i] = dp[i - 1] + dp[i - 2];
           dp[i] %= 10007;
        }

        System.out.println(dp[n]);
    }//main
}
