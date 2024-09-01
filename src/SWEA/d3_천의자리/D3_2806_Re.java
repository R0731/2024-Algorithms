package SWEA.d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_2806_Re {
    static int N;
    static int[] chess;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            chess = new int[N];
            visited = new boolean[N];
            count = 0;

            perm(0);

            System.out.println("#" + tc + " " + count);
        }
    }

    private static void perm(int sidx) {
        if (sidx == N) {
//            System.out.println(Arrays.toString(chess));
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && possible(sidx, i)) {
                visited[i] = true;
                chess[sidx] = i;
                perm(sidx + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean possible(int r, int c) {
        for(int i = 0; i < r; i++){
            if(Math.abs(i - r) == Math.abs(chess[i] - c)){
                return false;
            }
        }
        return true;
    }
}
