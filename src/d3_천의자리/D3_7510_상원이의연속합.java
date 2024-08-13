package d3_천의자리;

import java.util.Scanner;

public class D3_7510_상원이의연속합{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int sum = 0;
            int cnt = 0;

            for(int i = 1; i <= N; i++){
                sum = 0;
                for(int j = i; j <= N; j++){
                    sum += j;
                    if(sum == N){
                        cnt++;
                        break;
                    }else if(sum > N)
                        break;
                }
            }


            System.out.println("#" + tc + " " + cnt);
        }
    }
}
