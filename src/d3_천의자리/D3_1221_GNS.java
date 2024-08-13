package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D3_1221_GNS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Map<String, Integer> planetMap = new HashMap<>();
        String[] planet = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        for(int i = 0; i < planet.length; i++){
            planetMap.put(planet[i], i);
        }

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line2 = new StringTokenizer(br.readLine());
            StringTokenizer line = new StringTokenizer(br.readLine());

            int[] cnt = new int[10];


            while (line.hasMoreTokens()) {
                String str = line.nextToken();
                if (planetMap.containsKey(str)) {
                    cnt[planetMap.get(str)]++;
                }
            }

            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < cnt.length; i++) {
                while (cnt[i] > 0) {
                    ans.append(planet[i]).append(" ");
                    cnt[i]--;
                }
            }

            System.out.println(line2.nextToken() + " " + ans);
        }

    }

}


