package SWEA.d3_만의자리;

import java.util.Scanner;

public class D3_14555_공과잡초 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            String str = sc.next();

            char[] grass = str.toCharArray();

            int ball = 0;

            for(int i = 0; i < grass.length; i++){
                if(grass[i] == '(' || (grass[i] == ')' && grass[i-1] == '|')){
                    ball++;
                }
            }

            System.out.println("#" + tc + " " + ball);
        }
    }
}
