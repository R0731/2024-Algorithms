package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_6190_정곤이의단조증가하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[] nums = new int[N];//초기배열

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            int max = -1;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int a = nums[i] * nums[j];
                    if (danzo(a) && a > max)
                        max = a;
                }
            }

            System.out.println("#" + tc + " " + max);
        }

    }

        static boolean danzo(int num){
            int lastDigit = num % 10;
            num /= 10;

            while(num > 0){
                int nowDigit = num % 10;
                if(nowDigit > lastDigit){
                    return false;
                }

                lastDigit = nowDigit;
                num /= 10;
            }
            return true;

        }
}


