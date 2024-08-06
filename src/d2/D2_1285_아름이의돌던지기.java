package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1285_아름이의돌던지기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());

            int[] minus = new int[N];

            StringTokenizer line = new StringTokenizer(br.readLine());

            int min = 100000;

            for(int i = 0; i < N; i++){
                int a = Integer.parseInt(line.nextToken());
                minus[i] = Math.abs(a);
                if(minus[i] < min)
                    min = minus[i];
            }

            int count = 0;

            for(int i = 0; i < N; i++) {
                if(minus[i] == min)
                    count++;
            }

            System.out.println("#" + tc + " " + min + " " + count);
        }
    }
}
