package SWEA.d2_Re;

import java.util.Scanner;

public class 가랏RC카 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int ans = 0;

            int speed = 0;

            for(int i = 0; i < N; i++){
                int command = sc.nextInt();

                if(command == 0){
                    ans += speed;
                }else if(command == 1){
                    speed += sc.nextInt();
                    ans += speed;
                }else if(command == 2){
                    speed -= sc.nextInt();
                    if(speed < 0)
                        speed = 0;
                    ans += speed;
                }

            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
