package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_5789_현주의상자바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int Q = sc.nextInt();

            int[] box = new int[N];

            for(int n = 1; n <= Q; n++){
                int L = sc.nextInt();
                int R = sc.nextInt();
                for(int i = L - 1; i < R; i++){
                    box[i] = n;
                }
            }

            System.out.print("#" + tc + " ");
            for(int b : box){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
