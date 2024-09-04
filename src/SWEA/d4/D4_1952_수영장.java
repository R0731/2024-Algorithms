package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1952_수영장 {
    static int[] price;
    static int[] monthUse;
    static int[] month;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            price = new int[4];
            monthUse = new int[12];
            month = new int[12];

            StringTokenizer line = new StringTokenizer(br.readLine());

            for(int i = 0; i < 4; i++){
                price[i] = Integer.parseInt(line.nextToken());
            }

            min = price[3];

            StringTokenizer line2 = new StringTokenizer(br.readLine());
            for(int i = 0; i < 12; i++){
                monthUse[i] = Integer.parseInt(line2.nextToken());
            }

            perm(0);

            System.out.println("#" + tc + " " + min);
        }//tc

    }//main

    private static void perm(int sidx){
        if(sidx == 12){
            pay();
            return;
        }

        for (int i = 0; i < 3; i++) {
            month[sidx] = i;
            if(i == 2 && sidx < 10){
                sidx++;
                month[sidx] = i;
                sidx++;
                month[sidx] = i;
                return;
            }
            if(i == 2 && sidx >= 10){
                pay();
            }
            perm(sidx + 1);
        }
    }
//        for (int i = 0; i < 3; i++) {
//            month[sidx] = i;
//            if(i == 2 && sidx < 10){
//                month[sidx + 1] = i;
//                month[sidx + 2] = i;
//                perm(sidx + 3);
//                return;
//            }
//            perm(sidx + 1);
////                sidx++;
////                month[sidx] = i;
////                sidx++;
////                month[sidx] = i;
////            }
////            if(i == 2 && sidx >= 10) return;
//////            perm(sidx + 1);
//        }
//    }



    private static void pay(){
        int money = 0;

        for(int i = 0; i < 12; i++){
            if(month[i] == 0){
                money += monthUse[i] * price[0];
            }else if(month[i] == 1 && monthUse[i] != 0){
                money += price[1];
            }else if(month[i] == 2) {
                boolean use = false;
                for (int j = i; j <= i + 2 && j < 12; j++) {
                    if (monthUse[j] != 0) {
                        use = true;
                        break;
                    }
                }

                if(use){
                    money += price[2];
                }
                i += 2;
                continue;
            }
            System.out.println("현재 " + i);
        }
        if(money < min) min = money;
    }
}
