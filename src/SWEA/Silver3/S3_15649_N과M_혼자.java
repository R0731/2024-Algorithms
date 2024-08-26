package SWEA.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S3_15649_N과M_혼자 {
    private static int N;
    private static int M;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = i + 1;
        }

        permute(nums, 0);
    }

    private static void permute(int[]nums, int start){
        if(start == M){
            printArray(nums);
        }else{
            for(int i = start; i < M; i++){
                swap(nums, start, i);
                permute(nums, start + 1);
                swap(nums, start, i);
            }
        }

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void printArray(int[]nums){
        for(int n : nums){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
