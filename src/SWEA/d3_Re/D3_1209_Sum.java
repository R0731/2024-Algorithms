package SWEA.d3_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1209_Sum {
    static int t;
    static int[][] nemo = new int[100][100];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            t = Integer.parseInt(br.readLine());
            ans = 0;

            for(int i = 0; i < 100; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    nemo[i][j] = Integer.parseInt(line.nextToken());
                }
            }

            for(int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += nemo[i][j];
                }
                if(sum > ans) ans = sum;
            }

            for(int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += nemo[j][i];
                }
                if(sum > ans) ans = sum;
            }

            int dig1 = 0;
            for(int i = 0; i < 100; i++) {
                dig1 += nemo[i][i];
                if(dig1 > ans) ans = dig1;
            }

            int dig2 = 0;
            for(int i = 0; i < 100; i++) {
                dig2 += nemo[i][99 - i];
                if(dig2 > ans) ans = dig2;
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}
