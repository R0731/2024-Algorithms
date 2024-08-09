package d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_8500_극장좌석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int[] num = new int[N];

            for(int i = 0; i < N; i++){
                num[i] = sc.nextInt();
            }

            Arrays.sort(num);

            int blank = num[N-1] + N;

            for(int i = 0; i < N; i++){
                blank += num[i];
            }

            System.out.println("#" + tc + " " + blank);
        }
    }
}
