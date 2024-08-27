package SWEA.d3_천의자리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D3_4676_늘어지는소리만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            String str = sc.next();
            char[] c = str.toCharArray();

            List<Character> ans = new ArrayList<>();

            for(int i = 0; i < c.length; i++){
                ans.add(c[i]);
            }


            int H = sc.nextInt();

            int[] number = new int[H];

            for(int i = 0; i < number.length; i++){
                number[i] = sc.nextInt();
            }

            Arrays.sort(number);

            for(int i = H - 1; i >= 0; i--){
                ans.add(number[i], '-');
            }

            System.out.print("#" + tc + " ");
            for(char a : ans){
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
