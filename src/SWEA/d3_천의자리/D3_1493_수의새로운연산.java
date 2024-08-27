package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_1493_수의새로운연산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            int count = 1;

            int maxR = 1;
            int r = 1;
            int c = 1;

            int a = 0;
            int b = 0;

            int big = 0;

            if (p > q) {
                big = p;
            } else {
                big = q;
            }

            while (count != (big + 1)) {
                if (count == p) {
                    a += r;
                    b += c;
                }

                if (count == q) {
                    a += r;
                    b += c;
                }

                if (r == 1) {
                    maxR++;
                    r = maxR;
                    c = 1;
                    count++;
                }

                r--;
                c++;
                count++;
            }


            count = 1;
            maxR = 1;
            r = 1;
            c = 1;

            while((a != r) || (b != c)){
                if(r == 1){
                    maxR++;
                    r = maxR;
                    c = 1;
                    count++;
                }
                r--;
                c++;
                count++;
            }

            int ans = count;

            System.out.println("#" + tc + " " + count);
        }

    }


}
