package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_5549_홀수일까짝수일까 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            String N = sc.next();

            char[] num = N.toCharArray();

            String ans = "Odd";

            if(num[num.length - 1] % 2 == 0)
                ans = "Even";


            System.out.println("#" + tc + " " + ans);
        }
    }
}
