package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_규영이와인영이의카드게임2 {
    static int N;
    static int[] gyuCard;
    static int[] innCard;
    static boolean[] makeCard;
    static int gyuWin, gyuLose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        N = 9;

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            gyuCard = new int[N];
            innCard = new int[N];
            makeCard = new boolean[(N * 2) + 1];
            gyuWin = 0;
            gyuLose = 0;

            for(int i = 0; i < N; i++){
                int temp = Integer.parseInt(line.nextToken());
                gyuCard[i] = temp;
                makeCard[temp] = true;
            }



            for(int i = 1, idx = 0; i < makeCard.length; i++){
                if(!makeCard[i]) {
                    innCard[idx] = i;
                    idx++;
                }
            }

            perm(0);

            System.out.println("#" + tc + " " + gyuWin + " " + gyuLose);
        }
    }

    private static void perm(int sidx){
        if(sidx == N){
            cardGame();
            return;
        }

        for(int i = sidx; i < N; i++){
                swap(sidx, i);
                perm(sidx + 1);
                swap(sidx, i);
        }

    }

    private static void swap(int i, int j){
        int tmp = innCard[i];
        innCard[i] = innCard[j];
        innCard[j] = tmp;
    }

    private static void cardGame(){
        int gyuSum = 0;
        int innSum = 0;

        for(int i = 0; i < N; i++){
            if(gyuCard[i] > innCard[i]){
                gyuSum += gyuCard[i] + innCard[i];
            }else if(gyuCard[i] < innCard[i]) {
                innSum += gyuCard[i] + innCard[i];
            }
        }

        if(gyuSum > innSum){
            gyuWin++;
        }else{
            gyuLose++;
        }
    }
}
