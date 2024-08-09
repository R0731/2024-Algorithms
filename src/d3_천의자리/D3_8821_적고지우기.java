package d3_천의자리;

import java.util.Scanner;

public class D3_8821_적고지우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            String str = sc.next();

            char[] c = str.toCharArray();

            int[] num = new int[10];

            for(int i = 0; i < c.length; i++){
                int a = c[i] - '0';
                num[a]++;
            }

            int count = 0;

            for(int i = 0; i < num.length; i++){
                if(num[i] != 0 && num[i] % 2 == 1){
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
