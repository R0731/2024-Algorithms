package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_2112_보호필름 {
    static int D, W, K; //가로 세로 필요연속
    static int[][] nemo;
    static int N , idx;
    static boolean[] visited;
    static int[] per;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            D = Integer.parseInt(line.nextToken());
            W = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());

            nemo = new int[D][W];
            N = 0;
            visited = new boolean[D];
            per = new int[D];
            idx = 0;

            //0이면 A, 1이면 B
            for(int r = 0; r < D; r++){
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for(int c = 0; c < W; c++){
                    nemo[r][c] = Integer.parseInt(line2.nextToken());
                }
            }

//            System.out.println(test());

            if(test(nemo)){
                System.out.println("#" + tc + "0");
                continue;
            }


        }
    }//main

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
                if(pass) {
                    next = true;
                    break;
                }
            }
            if(!next){
                return false;
            }
        }

        return true;
    }

    private static void perm(int sidx){
        if(sidx == N){

        }

        for(int i = 0; i < D; i++){
            per[sidx] = i;
        }
    }

    private static void medicine(){
        int[][] temp = new int[D][W];
        for(int r = 0; r < D; r++){
            for(int c = 0; c < W; c++){
                temp[r][c] = nemo[r][c];
            }
        }

        for(int i = 0; i < idx; i++){
            int a = per[i];
            for(int j = 0; j < W; j++){
                temp[a][j] = 1;
            }
            if(!test(temp)){
                for(int r = 0; r < D; r++){
                    for(int c = 0; c < W; c++){
                        temp[r][c] = nemo[r][c];
                    }
                }
            }
        }
    }
}
