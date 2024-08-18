package d2_Re;

import java.util.Scanner;

public class 조교의성적매기기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] score = new int[N];

            for(int i = 0; i < N; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                score[i] = a * 35 + b * 45 + c * 20;
            }

            //K학생의 점수
            int scoreK = 0;

            //K학생의 등수 측정
            for(int i = 0; i < N; i++) {
                if(score[i] > score[K - 1]){
                    scoreK++;
                }
            }

            String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

            int num = scoreK / (N / 10);

            System.out.println("#" + tc + " " + grade[num]);
        }
    }
}
