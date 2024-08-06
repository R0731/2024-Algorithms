package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3431_준환이의운동관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(line.nextToken());
            int U = Integer.parseInt(line.nextToken());
            int X = Integer.parseInt(line.nextToken());

            int ans = 0;

            if(X > U){
                ans = -1;
            } else if(X >= L){
                ans = 0;
            } else if (L > X){
                ans = L - X;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
