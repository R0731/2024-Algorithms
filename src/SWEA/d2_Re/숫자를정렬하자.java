package SWEA.d2_Re;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자를정렬하자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int[] numbers = new int[N];

            for(int i = 0; i < N; i++){
                numbers[i] = sc.nextInt();
            }

            Arrays.sort(numbers);

            System.out.print("#" + tc + " ");
            for(int n : numbers){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
