package BACKJOON.Silver3;

import java.util.Scanner;

public class S3_15650_N과M_2 {
    static int N, M;
    static int[] nums;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        ans = new int[M];

        for(int i = 0; i < N; i++){
            nums[i] = i + 1;
        }

        combination(0, 0);

    }

    private static void combination(int idx, int sidx){
        if(sidx == M){
            for(int n : ans) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = idx; i < N; i++){
            ans[sidx] = nums[i];
            combination(i + 1, sidx + 1);
        }

    }
}
