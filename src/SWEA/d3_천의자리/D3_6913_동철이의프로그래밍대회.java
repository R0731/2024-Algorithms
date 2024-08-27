package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6913_동철이의프로그래밍대회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(line.nextToken()); //사람 수
            int M = Integer.parseInt(line.nextToken()); //문제 수

            int[][] nemo = new int[N][M];

            for(int r = 0; r < N; r++) {
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    nemo[r][c] = Integer.parseInt(line2.nextToken());
                }
            }

            //각 사람의 점수 측정(같은 열 비교)
            int[] score = new int[N];
            int max = 0;

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    score[r] += nemo[r][c];
                }
                if(score[r] > max)
                    max = score[r];
            }

            int count = 0;
            for(int i = 0; i < N; i++){
                if(score[i] == max){
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count + " " + max);
        }

    }
}
