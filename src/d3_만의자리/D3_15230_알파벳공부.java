package d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_15230_알파벳공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            char[] alpha = line.toCharArray();

            int ans = 0;

            if (alpha[0] == 'a') {
                ans++;
                for (int i = 1; i < alpha.length; i++) {
                    if (alpha[i] - alpha[i - 1] == 1) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
