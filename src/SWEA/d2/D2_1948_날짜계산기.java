package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1948_날짜계산기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());

            int m1 = Integer.parseInt(line.nextToken());
            int d1 = Integer.parseInt(line.nextToken());
            int m2 = Integer.parseInt(line.nextToken());
            int d2 = Integer.parseInt(line.nextToken());

            int[] day = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int ans = 0;

            if(m2 == m1){
                ans = d2 - d1 + 1;
            }else {
                for(int i = m1; i < m2; i++){
                    ans += day[i-1];
                }
                ans = ans + d2 - d1 + 1;
            }


            System.out.println("#" + tc + " " + ans);
        }

    }
}
