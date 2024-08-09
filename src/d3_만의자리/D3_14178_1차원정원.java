package d3_만의자리;

import java.util.Scanner;

public class D3_14178_1차원정원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int D = sc.nextInt();

            int count = 0;

            int ans = N / (D * 2 + 1);

            if(N % (D * 2 + 1) != 0)
                ans++;

            System.out.println("#" + tc + " " + ans);

        }
    }
}