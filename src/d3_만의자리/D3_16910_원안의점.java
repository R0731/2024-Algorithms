package d3_만의자리;

import java.util.Scanner;

public class D3_16910_원안의점 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int count = 0;

            for(int i = -N; i <= N; i++) {
                for (int j = -N; j <= N; j++) {
                    if ((i * i) + (j * j) <= N * N)
                        count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
