package SWEA.d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_12221_구구단2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(line.nextToken());
            int B = Integer.parseInt(line.nextToken());

            int ans = 0;
            if (A <= 9 && B <= 9){
                ans = A * B;
            }else{
                ans = -1;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
