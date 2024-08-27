package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_9700_USB꽂기의미스터리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            double p = sc.nextDouble();
            double q = sc.nextDouble();

            //S1구하기
            double S1 = (1 - p) * q;
            double S2 = p * (1 - q) * q;

            boolean ans = false;

            if(Math.max(S1, S2) == S2){
                ans = true;
            }


            System.out.println("#" + tc + " " + (ans? "YES" : "NO"));
        }

    }
}
