package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_3456_직사각형길이찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            int[] num = new int[3];

            int ans = 0;

            for(int i = 0; i < num.length; i++){
                num[i] = sc.nextInt();
            }

            if(num[1] == num[0]){
                ans = num[2];
            }else if(num[2] == num[0]){
                ans = num[1];
            }else{
                ans = num[0];
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
