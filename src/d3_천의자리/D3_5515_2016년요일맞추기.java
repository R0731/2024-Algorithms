package d3_천의자리;

import java.util.Scanner;

public class D3_5515_2016년요일맞추기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int m = sc.nextInt();
            int d = sc.nextInt();

            int[] month = {};
            int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            for(int i = 0; i < m - 1; i++){
                d += day[i];
            }

            int num = (d % 7);

            int[]aaa = {3, 4, 5, 6, 0, 1, 2};

            System.out.println("#" + tc + " " + aaa[num]);
        }
    }
}
