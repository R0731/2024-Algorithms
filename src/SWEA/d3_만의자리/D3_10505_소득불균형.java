package SWEA.d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_10505_소득불균형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());

            int[] people = new int[N];

            StringTokenizer line = new StringTokenizer(br.readLine());

            int sum = 0;

            for(int i = 0; i < N; i++){
                people[i] = Integer.parseInt(line.nextToken());
                sum += people[i];
            }

            double avg = sum / N;

            int ans = 0;

            for(int i = 0; i < N; i++){
                if (people[i] <= avg)
                    ans++;
            }



            System.out.println("#" + tc + " " + ans);
        }
    }
}
