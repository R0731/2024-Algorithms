package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모의_2112_보호필름 {
    static int D, W, K; //가로 세로 필요연속
    static int[][] nemo;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            D = Integer.parseInt(line.nextToken());
            W = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());

            nemo = new int[D][W];
            min = Integer.MAX_VALUE;

            //0이면 A, 1이면 B
            for (int r = 0; r < D; r++) {
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    nemo[r][c] = Integer.parseInt(line2.nextToken());
                }
            }

//            System.out.println(test());

            if (test(nemo)) {
                System.out.println("#" + tc + " " + 0);
                continue;
            }else {
                dfs(0, 0);
            }

            System.out.println("#" + tc + " " + min);
        }
    }//main

    //테스트 약품 통과 확인 메서드
    private static boolean test(int[][] nemo) {
        for (int c = 0; c < W; c++) {
            boolean next = false;
            for (int r = 0; r <= D - K; r++) {
                boolean pass = true;
                for (int l = 0; l < K; l++) {
                    if (nemo[r + l][c] != nemo[r][c]) {
                        pass = false;
                        break;
                    }
                }
                if (pass) {
                    next = true;
                    break;
                }
            }
            if (!next) {
                return false;
            }
        }

        return true;
    }//test

    //가능한 열 확인
    private static void dfs(int idx, int currentSum) {
        if (idx == D) {
            if (test(nemo)) {
                min = Math.min(min, currentSum);
            }
            return;
        }

        if (min <= currentSum) return;

        int[] temp = new int[W];
        for (int i = 0; i < W; i++) {
            temp[i] = nemo[idx][i];
        }

        dfs(idx + 1, currentSum);
        Arrays.fill(nemo[idx], 0);
        dfs(idx + 1, currentSum + 1);
        Arrays.fill(nemo[idx], 1);
        dfs(idx + 1, currentSum + 1);

        for (int i = 0; i < W; i++) {
            nemo[idx][i] = temp[i];
        }

    }//dfs

}
