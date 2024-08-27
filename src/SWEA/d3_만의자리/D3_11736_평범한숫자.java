package SWEA.d3_만의자리;

import java.util.Scanner;

public class D3_11736_평범한숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int[] nums = new int[N];

            for(int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
            }

            int count = 0;

            for(int i = 1; i < N - 1; i++){
                if(nums[i] < Math.max(nums[i - 1], nums[i + 1]) && nums[i] > Math.min(nums[i - 1], nums[i + 1])){
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
