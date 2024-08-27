package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D2_1970_쉬운거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());

            //5만, 1만, 5천, 1천, 5백, 1백, 50, 10원 순
            int[] change = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};

            int[] ans = new int[8];

            int i = 0;

            while(N > 0){
                if(N >= change[i]){
                    N -= change[i];
                    ans[i]++;
                }else {
                    i++;
                    if(i == 8)
                    	break;
                }
            }

            System.out.println("#" + tc);
            for(int a = 0; a < ans.length; a++){
                System.out.print(ans[a] + " ");
            }
            System.out.println();

        }

    }

}
