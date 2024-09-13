package BACKJOON.동적계획법연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_11722_가장긴감소하는부분수열 {
    static int N; //수열의 크기
    static int[] nums;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        arr = new int[N + 1];
        ans = 0;
        StringTokenizer line = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(line.nextToken());
        }

        for(int i = 1; i <= N; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] < nums[j]){
                    max = Math.max(max, arr[j]);
                }
            }
            arr[i] = max + 1;
        }

        for(int i = 1; i <= N; i++){
            if(arr[i] > ans) ans = arr[i];
        }

        System.out.println(ans);
    }//main
}
