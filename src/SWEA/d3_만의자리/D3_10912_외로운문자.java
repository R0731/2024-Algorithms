package SWEA.d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_10912_외로운문자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String str = br.readLine();

            char[] c = str.toCharArray();

            for(int i = 0; i < c.length; i++){
                for(int j = i+1; j <c.length; j++)
                    if(c[i] == c[j]){
                    c[i] = '0';
                    c[j] = '0';
                }
            }

            Arrays.sort(c);
            String ans = "";

            if(c[c.length-1] == '0'){
                ans = "Good";
            }else{
                for(int i = 0; i < c.length; i++){
                    if(c[i] != '0'){
                        ans += c[i];
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
