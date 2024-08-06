package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_4406_모음이보이지않는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String str = br.readLine();
            char[] voca = str.toCharArray();

            String ans = "";

            for(int i = 0; i < voca.length; i++){
                if(voca[i] == 'a' || voca[i] == 'e' || voca[i] == 'i' || voca[i] == 'o' || voca[i] == 'u'){
                    ans += "";
                }else{
                    ans += voca[i];
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
