package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_5356_의석이의세로로말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            char[][] nemo = new char[5][15];

            for(int r = 0; r < 5; r++) {
                Arrays.fill(nemo[r], '#');
            }

            for(int r = 0; r < 5; r++){
                String line = br.readLine();
                char[] temp = line.toCharArray();
                for(int c = 0; c < temp.length; c++){
                    nemo[r][c] = temp[c];
                }
            }

            StringBuilder ans = new StringBuilder();

            for (int c = 0; c < 15; c++) {
                for (int r = 0; r < 5; r++) {
                    if(nemo[r][c] != '#')
                        ans.append(nemo[r][c]);
                }
            }


            System.out.println("#" + tc + " " + ans);
        }

    }
}
