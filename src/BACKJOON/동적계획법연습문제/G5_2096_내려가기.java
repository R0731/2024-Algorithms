package BACKJOON.동적계획법연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2096_내려가기 {
    static int N;
    static int [][] nums;
    static int[][] dpMax;
    static int[][] dpMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1][3];
        dpMax = new int[N + 1][3];
        dpMin = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                nums[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        dpMax[1][0] = dpMin[1][0] = nums[1][0];
        dpMax[1][1] = dpMin[1][1] = nums[1][1];
        dpMax[1][2] = dpMin[1][2] = nums[1][2];

        for(int i = 2; i <= N; i++){
            dpMax[i][0] = nums[i][0] + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] = nums[i][1] + Math.max(dpMax[i - 1][0], Math.max(dpMax[i - 1][1], dpMax[i - 1][2]));
            dpMax[i][2] = nums[i][2] + Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);
        }

        for(int i = 2; i <= N; i++){
            dpMin[i][0] = nums[i][0] + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] = nums[i][1] + Math.min(dpMin[i - 1][0], Math.min(dpMin[i - 1][1], dpMin[i - 1][2]));
            dpMin[i][2] = nums[i][2] + Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);
        }

        int ans1 = Math.max(dpMax[N][0], Math.max(dpMax[N][1], dpMax[N][2]));
        int ans2 = Math.min(dpMin[N][0], Math.min(dpMin[N][1], dpMin[N][2]));

        System.out.println(ans1 + " " + ans2);
    }//main
}
