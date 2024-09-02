package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D4_1767_프로세서연결하기 {
    static int N, M;
    static int[][] map;
    static List<int[]> core;
    static int[] coreArr;
    static int min, count;
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            //초기화 작업
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            min = 0;
            count = 0;

            core = new ArrayList<>();

            for(int r = 0; r < N; r++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    int n = Integer.parseInt(line.nextToken());
                    if(n == 1){
                        core.add(new int[]{r, c});
                    }
                }
            }

            M = core.size();
            coreArr = new int[M];

            for(int i = 0; i < M; i++){
                coreArr[i] = i;
            }

            perm(0);

            System.out.println("#" + tc + " ");
        }//tc
    }//main

    private static void perm(int sidx){
        if(sidx == M){
//            System.out.println(Arrays.toString(coreArr));
//            move(0, 0);
            return;
        }

        for(int i = sidx; i < M; i++){
            swap(sidx, i);
            perm(sidx + 1);
            swap(sidx, i);
        }
    }//perm

    private static void swap(int i, int j){
        int temp = coreArr[i];
        coreArr[i] = coreArr[j];
        coreArr[j] = temp;
    }//swap

//    private static void move(int idx, int currentSum){
//
//        for(int i = 0; i < M; i++){
//
//        }
//
//    }
}
