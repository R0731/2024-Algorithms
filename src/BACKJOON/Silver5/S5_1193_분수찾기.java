package BACKJOON.Silver5;

import java.util.Scanner;

public class S5_1193_분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        //방향 이동
        int[] moveR = {0, 1, 1, -1};
        int[] moveC = {1, -1, 0, 1};
        int move = 0;

        int r = 1;
        int c = 1;

        int cnt = 1;

        while (cnt < X) {
            r += moveR[move];
            c += moveC[move];

            cnt++;
            if (r == 1 || c == 1){
                move = (move + 1) % 4;
            }
        }

        System.out.println(r + "/" + c);
    }
}
