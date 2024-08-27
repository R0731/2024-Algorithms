package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_2817_부분수열의합 {
    static int N, K;
    static int count;
    static int[] nums;
    static boolean[] sel;
    static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            K = sc.nextInt();
            nums = new int[N];
            sel = new boolean[N];
            count = 0;

            for(int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
            }

            powerSet(0);

            System.out.println("#" + tc + " " + count);
        }
    }

    private static void powerSet(int idx){
        //기저조건
        if(sum == K){
            count++;
            return;
        }
        if(idx >= N || sum > K){
            return;
        }

        //재귀부분
        sum += nums[idx];
        powerSet(idx + 1);

        sum -= nums[idx];
        powerSet(idx + 1);
    }
}
