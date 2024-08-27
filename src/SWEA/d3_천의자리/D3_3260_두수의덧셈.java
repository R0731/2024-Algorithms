package SWEA.d3_천의자리;

import java.math.BigInteger;
import java.util.Scanner;

public class D3_3260_두수의덧셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            BigInteger n1 = new BigInteger(sc.next());
            BigInteger n2 = new BigInteger(sc.next());

            BigInteger ans = n1.add(n2);

            System.out.println("#" + tc + " " + ans);

        }
    }
}
