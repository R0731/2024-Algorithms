package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_1217_거듭제곱2 {
    static int N, M;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++){
            int T = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();

            int ans = pow(N, M);

            System.out.println("#" + T + " " + ans);
        }
    }

    private static int pow(int n, int m){
        if(m == 1) return n;

        //짝수이면
        if(m % 2 == 0){
            int tmp = pow(n, m / 2);
            return tmp * tmp;
        }else{
            int tmp = pow(n, (m - 1) / 2);
            return  tmp * tmp * n;
        }
    }
}
