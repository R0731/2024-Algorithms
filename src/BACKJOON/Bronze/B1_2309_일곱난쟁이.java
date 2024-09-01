package BACKJOON.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1_2309_일곱난쟁이 {
    static int[] nums;
    static int N;
    static int[] ans;
    static int[] ans2;
    static boolean[] visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = new int[9];
        N = 7;
        ans = new int[N];
        ans2 = new int[N];
        visited = new boolean[9];
        sum = 0;

        for(int i = 0; i < 9; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        comb(0, 0, 0);

        Arrays.sort(ans2);

        for(int n : ans2)
            System.out.println(n);
    }

    private static void comb(int idx, int sidx, int currentSum){
        if(currentSum > 100) return;
        if(idx == N){
            if(currentSum == 100){
                for(int i = 0; i < N; i++){
                    ans2[i] = ans[i];
                }
            }
            return;
        }

        for(int i = idx; i < 9; i++){
            if(!visited[i]){
                visited[i] = true;
                ans[sidx] = nums[i];
                comb(idx + 1, sidx + 1, currentSum + nums[i]);
                visited[i] = false;
            }
        }

    }
}
