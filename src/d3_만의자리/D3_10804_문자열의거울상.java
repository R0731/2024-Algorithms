package d3_만의자리;

import java.util.Scanner;

public class D3_10804_문자열의거울상 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            String str = sc.next();

            char[] cha = str.toCharArray();

            String ans = "";

            for(int i = cha.length - 1; i >= 0; i--) {
                if (cha[i] == 'b') {
                    ans += "d";
                } else if (cha[i] == 'd') {
                    ans += "b";
                } else if (cha[i] == 'p') {
                    ans += "q";
                } else {
                    ans += "p";
                }
            }

            System.out.println("#" + tc + " " + ans);


        }
    }
}
