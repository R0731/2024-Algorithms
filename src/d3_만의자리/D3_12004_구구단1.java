package d3_만의자리;

import java.util.Scanner;

public class D3_12004_구구단1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            String ans = "No";

            for(int i = 1; i <= 9; i++){
                if(N % i == 0 && N / i <= 9){
                    ans = "Yes";
                    break;
                }
            }


            System.out.println("#" + tc + " " + ans);
        }
    }
}
