package SWEA.d3_만의자리;

import java.util.Scanner;

public class D3_10726_이진수표현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for(int t = 1; t <= TC; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int result = (1 << N) - 1; //모두 1로 이루어진 숫자

            String ans = "OFF";

            if((M & result) == result){
                ans = "ON";
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}
