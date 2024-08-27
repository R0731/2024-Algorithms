package SWEA.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1_2056_연월일달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {

            String line = br.readLine();

            char[] date2 = line.toCharArray();

            int[] date = new int[8];

            for(int i = 0; i < 8; i++) {
                date[i] = date2[i] - '0';
            }

            int[] month = new int[12];

            //월 비교 배열
            for(int i = 0; i < 12; i++){
                month[i] = i + 1;
            }

            //날짜 비교 배열
            int[] day = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int temp = 0;

            int mon = date[4] * 10 + date[5];

           if (mon < 1 || mon > 12 || (date[6] * 10 + date[7]) > day[mon-1] || (date[6] * 10 + date[7]) < 1){
                        temp = -1;
           }

            System.out.print("#" + tc + " ");
            if(temp == -1){
                System.out.print("-1");
            }else{
                for(int i = 0; i < 4; i++){
                    System.out.print(date[i]);
                }
                System.out.print("/");
                for(int i = 4; i < 6; i++){
                    System.out.print(date[i]);
                }
                System.out.print("/");
                for(int i = 6; i < 8; i++){
                    System.out.print(date[i]);
                }
            }
            System.out.println();
        }
    }
}
