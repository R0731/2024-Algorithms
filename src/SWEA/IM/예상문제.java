package SWEA.IM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 예상문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int MIN = sc.nextInt();
            int MAX = sc.nextInt();

            int[] score = new int[N];

            int[] count = new int[101];

            for (int i = 0; i < score.length; i++) {
                score[i] = sc.nextInt();
            }

            Arrays.sort(score);

            List<Integer> number = new ArrayList<>();

            int numbercount = 0;

            for(int i = 0; i < score.length; i++){
                if(!number.contains(score[i])){
                    numbercount++;
                }
                number.add(score[i]);
            }

            int avg = numbercount / 3;

            int[] group = new int[3];

            int gnumber = 0;

            int n = 0;

            while(!number.isEmpty()){
                int a = number.remove(n);
                int b = number.get(n);



            }

//            for (int i = 0; i < score.length; i++) {
//                if(count[score[i]] == 0){
//                    numbercount++;
//                    count[score[i]]++;
//                }
//                count[score[i]]++;
//            }
//
//            int[] group = new int[3];
//
//            int gnumber = 0;
//
//            int number = 0;
//
//            int avg = numbercount / 3;
//
//            while (number < count.length && gnumber < 3) {
//                if (gnumber == 0 || gnumber == 1) {
//                    if ((group[gnumber] + count[number]) <= MAX && (group[gnumber] + count[number]) <= avg) {
//                        group[gnumber] += count[number];
//                    } else if (group[gnumber] + count[number] > MAX || (group[gnumber] + count[number]) > avg) {
//                        gnumber++;
//                        group[gnumber] += count[number];
//                    }
//                } else if (gnumber == 2) {
//                    if ((group[gnumber] + count[number]) <= MAX) {
//                        group[gnumber] += count[number];
//                    }
//                }
//                number++;
//            }
//
//            System.out.println(Arrays.toString(group));
//
//            int ans = -1;
//            int min = 100;
//            int max = 0;
//
//            for(int i = 0; i < group.length; i++){
//                if(group[i] < min){
//                    min = group[i];
//                }else if(group[i] > max){
//                    max = group[i];
//                }
//            }

//            System.out.println(max);
//            System.out.println(min);

//
//            if(max <= MAX && min >= MIN){
//                ans = max - min;
//            }
//
//
//            System.out.println("#" + tc + " " + ans);

        }
    }
}
