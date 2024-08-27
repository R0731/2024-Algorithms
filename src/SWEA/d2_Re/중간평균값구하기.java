package SWEA.d2_Re;

import java.util.Scanner;

public class 중간평균값구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            int max = 0;
            int min = 10000;
            int sum = 0;

            for(int i = 0; i < 10; i++){
                int a = sc.nextInt();
                sum += a;
                if(a > max){
                    max = a;
                }else if(a < min){
                    min = a;
                }
            }

            double avg = (double) (sum - max - min) / 8;

            int ans = (int)Math.round(avg);

            System.out.println("#" + tc + " " + ans);
        }
    }
}
