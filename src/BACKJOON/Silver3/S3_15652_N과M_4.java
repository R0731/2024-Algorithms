package BACKJOON.Silver3;

import java.util.Scanner;

public class S3_15652_N과M_4 {
    static int N, M;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        ans = new int[M];

        combination(1, 0);

        System.out.println(sb.toString());
    }

    private static void combination(int idx, int sidx){
        if(sidx == M){
            for(int n : ans){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i <= N; i++){
            ans[sidx] = i;
            combination(i, sidx + 1);
        }
    }
}
