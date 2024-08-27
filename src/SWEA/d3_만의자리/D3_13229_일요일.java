package SWEA.d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_13229_일요일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();

            String[] arr = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

            int ans = 0;

            for(int i = 0; i < arr.length; i++){
                if(arr[i].equals(s)){
                    if(i == 6){
                        ans = 7;
                    }else{
                        ans = 6 - i;
                    }
                }

            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
