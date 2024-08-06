package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_9317_석찬이의받아쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            String str1 = br.readLine();
            char[] right = str1.toCharArray();

            String str2 = br.readLine();
            char[] write = str2.toCharArray();

            int ans = 0;

            for (int i = 0; i < N; i++) {
                if(right[i] == write[i]) {
                    ans++;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

}

