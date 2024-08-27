package SWEA.d3_만의자리;

import java.util.Scanner;

public class D3_11856_반반 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            String line = sc.next();

            char[] c = line.toCharArray();

            char[] arr = new char[2];
            arr[0] = c[0];

            int[] count = new int[2];

            for(int i = 1; i < c.length; i++){
                if(c[i] != c[0]) {
                    arr[1] = c[i];
                    break;
                }
            }

            for(int i = 0; i < c.length; i++){
                if(c[i] == arr[0]) {
                    count[0]++;
                }else if(c[i] == arr[1]){
                    count[1]++;
                }
            }

            boolean ans = false;

            if(count[0] == 2 && count[1] == 2){
                ans = true;
            }

            System.out.println("#" + tc + " " + (ans? "Yes": "No"));
        }
    }
}
