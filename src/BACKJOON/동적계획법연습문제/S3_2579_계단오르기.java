package BACKJOON.동적계획법연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S3_2579_계단오르기 {
    static int N;
    static int[] step;
    static int[] ans;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        step = new int[N + 1];
        ans = new int[N + 1];
        max = 0;

        for(int i = 1; i <= N; i++){
            step[i] = Integer.parseInt(br.readLine());
        }

        ans[1] = step[1];
        if(N >= 2) ans[2] = step[1] + step[2];
        for(int i = 3; i <= N; i++){
            int max = Math.max(ans[i - 3] + step[i - 1] + step[i], ans[i - 2] + step[i]);
            ans[i] = max;
        }

        System.out.println(ans[N]);
    }
}
