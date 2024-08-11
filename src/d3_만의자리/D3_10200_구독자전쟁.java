package d3_만의자리;

import java.util.Scanner;

public class D3_10200_구독자전쟁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();

            int max = Math.min(A, B);

            int min = (A + B) - N;
            if(min < 0)
                min = 0;



            System.out.println("#" + tc + " " + max + " " + min);
        }
    }
}
