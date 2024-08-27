package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_9997_미니멀리즘시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            int N = sc.nextInt();

            double clock  = N / (0.5);

            int h = 0;

            while(clock >= 60){
                clock -= 60;
                h++;
            }

            int m = (int)clock;

            System.out.println("#" + tc + " " + h + " " + m);
        }
    }

}
