package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_5431_민석이의과제체크하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(line.nextToken());
            int K = Integer.parseInt(line.nextToken());

            StringTokenizer line2 = new StringTokenizer(br.readLine());

            int[] arr = new int[N + 1];

            for(int i = 0; i < K; i++) {
                int a = Integer.parseInt(line2.nextToken());
                arr[a]++;
            }
            
            String nocheck = "";

            for(int i = 1; i <= N; i++) {
                if(1 > arr[i]){
                    nocheck += i + " ";
                }
            }

            System.out.println("#" + tc + " " + nocheck);
        }

    }
}
