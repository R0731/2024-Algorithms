package BACKJOON.동적계획법연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_15486_퇴사2 {
    static int N;
    static int[][] table;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        table = new int[N + 1][2];
        dp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(line.nextToken());
            table[i][1] = Integer.parseInt(line.nextToken());
        }

        for(int i = 1; i <= N; i++){
            dp[i] = table[i][1];
            int j = i;
            while(j <= N){
                j += table[i];
            }
        }

    }
}
