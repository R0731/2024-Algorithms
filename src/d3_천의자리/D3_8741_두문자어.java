package d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_8741_두문자어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            String ans = "";

            for(int i = 0; i < 3; i++){
                String str = sc.next();
                char[] temp = str.toCharArray();
                char a = (char) (temp[0] - 32);
                ans += a;
            }


            System.out.println("#" + tc + " " + ans);
        }
    }
}
