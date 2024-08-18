package d2_Re;

import java.util.Scanner;

public class 최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int t = sc.nextInt();

            int[] score = new int[101];

            for(int i = 0; i < 1000; i++){
                int a = sc.nextInt();
                score[a]++;
            }

            int max = 0;
            int maxscore = -1;

            for(int i = 0; i < score.length; i++){
                if(score[i] >= max){
                    max = score[i];
                    maxscore = i;
                }
            }
            System.out.println("#" + t + " " + maxscore);
        }
    }
}
