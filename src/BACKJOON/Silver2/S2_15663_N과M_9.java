package BACKJOON.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_15663_N과M_9 {
    static int N, M;
    static int[] nums;
    static int[] ans;
    static boolean[] visited;
    static int[] before;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());

        nums = new int[N];
        ans = new int[M];
        visited = new boolean[N];
        before = new int[M];

        StringTokenizer line2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(line2.nextToken());
        }

        Arrays.sort(nums);

        permute(0);

        System.out.println(sb.toString());
    }

    private static void permute(int sidx) {
        if (sidx == M) {
            for (int a : ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -999;
        for(int i = 0; i < N; i++) {
            if (!visited[i] && nums[i] != before) {
                visited[i] = true;
                ans[sidx] = nums[i];
                permute(sidx + 1);
                visited[i] = false;
                before = nums[i];
            }
        }
    }
}
