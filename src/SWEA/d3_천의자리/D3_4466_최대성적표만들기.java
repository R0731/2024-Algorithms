package SWEA.d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_4466_최대성적표만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] num = new int[N];

            for (int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
            }

            Arrays.sort(num);

            int max = 0;

            for(int i = 0; i < K; i++){
                max += num[N-1-i];
            }

            System.out.println("#" + tc + " " + max);

        }

    }
}
