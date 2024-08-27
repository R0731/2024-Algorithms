package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_3142_영준이와신비한뿔의숲 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int m = N - M; //트윈혼
            int n = M - m; //유니콘

            System.out.println("#" + tc + " " + n + " " + m);
        }
    }
}
