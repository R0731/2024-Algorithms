package BACKJOON.Silver3;

import java.util.Scanner;

public class S3_15651_N과M_3 {
    static int N, M;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        ans = new int[M];

        permute(0);

        System.out.print(sb.toString());
    }

    private static void permute(int sidx){
        if(sidx == M){
            for(int n : ans){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            ans[sidx] = i;
            permute(sidx + 1);
        }

    }

}
