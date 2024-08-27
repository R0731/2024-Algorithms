package BACKJOON.Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class S3_15649_N과M_1 {
    static int N, M;
    static int[] nums;
    static int[] ans;
    static boolean[] use;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        ans = new int[M];
        use = new boolean[N];

        for(int i = 0; i < N; i++){
            nums[i] = i + 1;
        }

        permute(0);

    }

    private static void permute(int sidx){
        if(sidx == M){
            for(int i = 0; i < M; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++){
            if(!use[i]){
                use[i] = true;
                ans[sidx] = nums[i];
                permute(sidx + 1);
                use[i] = false;
            }
        }
    }
}
