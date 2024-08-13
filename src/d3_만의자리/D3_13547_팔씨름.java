package d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_13547_팔씨름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String line = br.readLine();

            char[] play = line.toCharArray();

            int win = 0;

            for(int i = 0; i < play.length; i++){
                if(play[i] == 'o'){
                    win++;
                }
            }

            String ans = "NO";

            if(win >= 8 || (15 - play.length) >= (8 - win)){
                ans = "YES";
            }

            System.out.println("#" + tc + " " + ans);
        }

    }
}
