package d2_Re;

import java.util.Scanner;

public class 백만장자프로젝트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[] num = new int[N];

            for(int i = 0; i < N; i++){
                num[i] = sc.nextInt();
            }

            int sell = 0;
            long money = 0;

            for(int i = N - 1; i >= 0; i--){
                if(num[i] > sell){
                    sell = num[i];
                }else{
                    money += sell - num[i];
                }
            }

            System.out.println("#" + tc + " " + money);
        }
    }
}
