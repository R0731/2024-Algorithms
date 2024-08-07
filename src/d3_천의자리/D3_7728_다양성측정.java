package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D3_7728_다양성측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();

            char[] voca = line.toCharArray();

            Set<Integer> set = new HashSet<>();

            for (char c : voca) {
                set.add(c - '0');
            }

            System.out.println("#" + tc + " " + set.size());
        }
    }
}
