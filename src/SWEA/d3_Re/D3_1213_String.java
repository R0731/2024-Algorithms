package SWEA.d3_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1213_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            int T = Integer.parseInt(br.readLine());
            String find = br.readLine();
            char[] a = find.toCharArray();

            String line = br.readLine();
            char[] b = line.toCharArray();

            int ans = 0;

            for(int i = 0; i <= b.length - a.length; i++){
                boolean right = true;
                for(int j = 0; j < a.length; j++){
                    if(b[i + j] != a[j]){
                        right = false;
                        break;
                    }
                }
                if(right) ans++;
            }

            System.out.println("#" + T + " " + ans);
        }
    }
}
