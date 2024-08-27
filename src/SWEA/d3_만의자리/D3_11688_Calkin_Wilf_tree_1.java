package SWEA.d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_11688_Calkin_Wilf_tree_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            char[] tree = str.toCharArray();

            int a = 1;
            int b = 1;

            for (int i = 0; i < tree.length; i++) {
                if(tree[i] == 'L') {
                    b = a + b;
                }else if(tree[i] == 'R'){
                    a = a + b;
                }
            }

            System.out.println("#" + tc + " " + a + " " + b);
        }
    }

}
