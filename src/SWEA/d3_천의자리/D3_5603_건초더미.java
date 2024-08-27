package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_5603_건초더미 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int[] grass = new int[N];

            int sum = 0;

            for(int i = 0; i < N; i++){
                grass[i] = sc.nextInt();
                sum += grass[i];
            }

            int avg = sum / N;

            int cnt = 0;

            for(int i = 0; i < N; i++){
                if(grass[i] > avg){
                    cnt += grass[i] - avg;
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
}
