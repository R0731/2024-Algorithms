package BACKJOON.동적계획법연습문제;

import java.util.Scanner;

public class G5_9251_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.next();
        String line2 = sc.next();
        char[]a = line1.toCharArray();
        char[]b = line2.toCharArray();

        int N = a.length;
        int M = b.length;

        int[][]dp = new int[N + 1][M + 1];

        for(int r = 1; r <= N; r++){
            for(int c = 1; c <= M; c++){
                dp[r][c] =
            }
        }

    }//main
}
