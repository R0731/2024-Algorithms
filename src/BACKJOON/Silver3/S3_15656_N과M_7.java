package BACKJOON.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15656_N과M_7 {
    static int N, M;
    static int[] nums;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(br.readLine());

        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());

        nums = new int[N];
        ans = new int[M];

        StringTokenizer line2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(line2.nextToken());
        }

        Arrays.sort(nums);

        permute(0);

        System.out.println(sb.toString());

    }

    private static void permute(int sidx){
        if(sidx == M){
            for(int n : ans){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            ans[sidx] = nums[i];
            permute(sidx + 1);
        }
    }
}
