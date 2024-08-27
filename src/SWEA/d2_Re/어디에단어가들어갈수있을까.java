package SWEA.d2_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어디에단어가들어갈수있을까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line1 = new StringTokenizer(br.readLine());

            int N  = Integer.parseInt(line1.nextToken());
            int K  = Integer.parseInt(line1.nextToken());

            int[][] nemo = new int[N][N];

            for(int r = 0; r < N; r++){
                StringTokenizer line2 = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    nemo[r][c] = Integer.parseInt(line2.nextToken());
                }
            }

            int count = 0;

            //가로 탐색
            for(int r = 0; r < N; r++) {
                for (int c = 0; c <= N - K; c++) {
                    boolean right = true;
                    for(int a = 0; a < K; a++){
                        if(nemo[r][c + a] != 1){
                            right = false;
                            break;
                        }
                    }

                    if (right){
                        if((c + K >= N || nemo[r][c + K] != 1) && (c - 1 < 0 || nemo[r][c - 1] != 1)){
                            count ++;
                        }
                    }

                }
            }

            //세로 탐색
            for(int c = 0; c < N; c++) {
                for (int r = 0; r <= N - K; r++) {
                    boolean right = true;
                    for(int a = 0; a < K; a++){
                        if(nemo[r + a][c] != 1){
                            right = false;
                            break;
                        }
                    }

                    if (right){
                        if((r + K >= N || nemo[r + K][c] != 1) && (r - 1 < 0 || nemo[r - 1][c] != 1)){
                            count ++;
                        }

                    }
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
