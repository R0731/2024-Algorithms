package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_6692_다솔이의월급상자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            double sum = 0;

            for(int i = 0; i < N; i++){
                double p = sc.nextDouble();
                double x = sc.nextDouble();
                sum += p * x;
            }

            String ans = String.format("%6f",sum);

            System.out.println("#" + tc + " " + ans);
        }
    }
}
