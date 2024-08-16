package d2_Re;

import java.util.Scanner;

public class 수도요금경쟁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int R = sc.nextInt();
            int S = sc.nextInt();
            int W = sc.nextInt();

            int sum1 = P * W;
            int sum2 = Q;

            if(R < W){
                sum2 = Q + (W - R) * S;
            }

            int ans = Math.min(sum1, sum2);

            System.out.println("#" + tc + " " + ans);
        }
    }
}
