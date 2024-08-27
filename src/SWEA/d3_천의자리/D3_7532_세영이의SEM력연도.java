package SWEA.d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_7532_세영이의SEM력연도 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int[] sem = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

            int[] ans = new int[3];

            int count = 0;

            while(!Arrays.equals(sem, ans)){
                ans[0]++;
                ans[1]++;
                ans[2]++;
                count++;

                if(ans[0] > 365)
                    ans[0] -= 365;
                if(ans[1] > 24)
                    ans[1] -= 24;
                if(ans[2] > 29)
                    ans[2] -= 29;

            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
