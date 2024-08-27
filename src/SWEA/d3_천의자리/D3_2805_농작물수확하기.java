package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_2805_농작물수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] farm = new int[N][N];

            for(int i = 0; i < N; i++){
                String line = br.readLine();
                char[]temp =line.toCharArray();
                for(int j = 0; j < N; j++){
                    farm[i][j] = temp[j]-48;
                }
            }


            int sum = 0;
            int center = N / 2;

            for(int r = 0; r < N; r++){
                if(r <= center) {
                    sum += farm[r][center];
                    for(int c = r; c > 0; c--){
                        sum += farm[r][center-c];
                        sum += farm[r][center+c];
                    }
                }else {
                    sum += farm[r][center];
                    for(int c = N - r - 1; c > 0; c--){
                        sum += farm[r][center-c];
                        sum += farm[r][center+c];
                    }
                }

            }

            System.out.println("#" + tc + " " + sum);

        }
    }
}
