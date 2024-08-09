package d3_천의자리;

import java.util.Scanner;

public class D3_5162_두가지빵의딜레마 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            int price = Math.min(A, B);

            int bread = C / price;

            System.out.println("#" + tc + " " + bread);
        }
    }
}
