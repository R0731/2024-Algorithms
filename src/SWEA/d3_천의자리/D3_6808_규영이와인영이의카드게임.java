package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_6808_규영이와인영이의카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int[] num = new int[19];

            //규영이의 카드
            int[] gyu_card = new int[9];

            for(int i = 0; i < 9; i++){
                gyu_card[i] = sc.nextInt();
                num[gyu_card[i]]++;
            }

            //인영이의 카드
            int[] in_card = new int[9];

            int in_num = 0;

            for(int i = 1; i < num.length; i++){
                if(num[i] == 0){
                    in_card[in_num] = i;
                    in_num++;
                }
            }

            gyuWin = 0;
            inWin = 0;

            permute(in_card, 0, gyu_card);

            System.out.println("#" + tc + " " + gyuWin + " " + inWin);
        }

    }

    static int gyuWin;
    static int inWin;

    //순열
    static int[] permute(int[] in_card, int start, int[]gyu_card) {
        if (start == in_card.length) {
            int result = compare(in_card, gyu_card);
            if(result == 1){
                inWin++;
            } else if (result == 2) {
                gyuWin++;
            }
        } else {
            for (int i = start; i < in_card.length; i++) {
                swap(in_card, start, i);
                permute(in_card, start + 1, gyu_card);
                swap(in_card, start, i);
            }
        }

        return in_card;
    }

    static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    static int compare(int[] permuted, int[] target){
        int peWin = 0;
        int taWin = 0;

        for(int i = 0; i < permuted.length; i++){
            if(permuted[i] > target[i]){
                peWin += permuted[i] + target[i];
            }else{
                taWin += permuted[i] + target[i];
            }
        }

        if(peWin > taWin){
            return 1;
        } else if (peWin == taWin) {
            return 0;
        }else{
            return 2;
        }
    }

}
