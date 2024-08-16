package d2_Re;

import java.util.Scanner;

public class 날짜계산기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();

            int ans = 1;

            int[]day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if(m1 == m2){
                ans += d2 - d1;
            }else{
                for(int i = m1 + 1; i < m2; i++){
                    ans += day[i];
                }

                ans += day[m1] - d1 + d2;

            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
