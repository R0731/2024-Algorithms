package d3_천의자리;

import java.util.Scanner;

public class D3_1493_수의새로운연산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int p = sc.nextInt();
            int q = sc.nextInt();

            int count = 1;

            int maxR = 1;
            int r = 1;
            int c = 1;

            int[] new = 

            while((count != p) || (count != q)){
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

            int x = r;
            int y = c;

            count = 1;
            maxR = 1;
            r = 1;
            c = 1;

            while(count != q){
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

            int z = r;
            int w = c;

            int a = x + z;
            int b = y + w;

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
