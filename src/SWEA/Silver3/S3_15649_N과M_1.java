package SWEA.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15649_N과M_1 {
    static int N, M;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(br.readLine());

        N = Integer.parseInt(line.nextToken());
        M = Integer.parseInt(line.nextToken());

        nums = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++){

        }

        permute(nums, M);

    }

    static void permute(int [] nums, int M){

    }
}
