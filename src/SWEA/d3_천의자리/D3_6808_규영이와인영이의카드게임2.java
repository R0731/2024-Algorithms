package SWEA.d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_6808_규영이와인영이의카드게임2 {
    static int N = 9;
    static int[]gyu;
    static boolean[] gyucard;
    static int[]inn;
    static int gyuWin, gyuLose;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            gyu = new int[N];
            gyucard = new boolean[N * 2 + 1];
            inn = new int[N];
            gyuWin = 0;
            gyuLose = 0;

            for(int i = 0; i < N; i++){
                gyu[i] = sc.nextInt();
                gyucard[gyu[i]] = true;
            }

            for(int i = 1, j = 0; i < gyucard.length; i++){
                if(!gyucard[i]){
                    inn[j] = i;
                    j++;
                }
            }

            perm(0);

            System.out.println("#" + tc + " " + gyuWin + " " + gyuLose);
        }
    }

    private static void perm(int idx){
        if(idx == N){
//            System.out.println(Arrays.toString(inn));
            sum(gyu, inn);
            return;
        }

        for(int i = idx; i < N; i++){
            swap(idx, i);
            perm(idx + 1);
            swap(idx, i);
        }
    }

    private static void swap(int i, int j){
        int tmp = inn[i];
        inn[i] = inn[j];
        inn[j] = tmp;
    }

    private static void sum(int[]gyu, int[]inn){
        int gyusum = 0;
        int innsum = 0;

        for(int i = 0; i < N; i++){
            if(gyu[i] > inn[i]){
                gyusum += gyu[i] + inn[i];
            }else{
                innsum += gyu[i] + inn[i];
            }
        }

        if(gyusum > innsum){
            gyuWin++;
        }else if(gyusum < innsum){
            gyuLose++;
        }
    }
}
