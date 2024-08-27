package SWEA.d2_Re;

import java.util.Scanner;

public class 쉬운거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

            int[] ans = new int[money.length];

            for(int i = 0; i < money.length; i++){
                if(N >= money[i]){
                    while(N >= money[i]){
                        N -= money[i];
                        ans[i]++;
                    }
                }
            }

            System.out.println("#" + tc + " ");
            for(int n : ans){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
