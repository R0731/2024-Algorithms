package d3_천의자리;

import java.util.Scanner;

public class D3_4299_태혁이의사랑은타이밍 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int[] nowTime = new int[3];

            nowTime[0] = sc.nextInt();
            nowTime[1] = sc.nextInt();
            nowTime[2] = sc.nextInt();

            int[] time = new int[3];
            for(int i = 2; i >= 0; i--){
                if(nowTime[2] < 11){
                    nowTime[1]--;
                    nowTime[2] += 60;
                }
                if(nowTime[1] < 11){
                    nowTime[0]--;
                    nowTime[1] += 24;
                }

                time[i] = nowTime[i] - 11;
            }

            int ans = 0;

            if(time[0] < 0){
                ans = -1;
            }else{
                ans = (time[0] * 1440) + (time[1] * 60) + time[2];
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
