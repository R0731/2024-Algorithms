package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5215_햄버거다이어트 {
    static int N, L;
    static int[][] hamburger;
    static int max, taste, cal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
           StringTokenizer line = new StringTokenizer(br.readLine());

           N = Integer.parseInt(line.nextToken());
           L = Integer.parseInt(line.nextToken());
           max = 0;
           taste = 0;
           cal = 0;

           hamburger = new int[N][2];

           for(int i = 0; i < N; i++){
               StringTokenizer line2 = new StringTokenizer(br.readLine());
               hamburger[i][0] = Integer.parseInt(line2.nextToken());
               hamburger[i][1] = Integer.parseInt(line2.nextToken());
           }

           powerSet(0, taste, cal);

           System.out.println("#" + tc + " " + max);
        }
    }

    private static void powerSet(int idx, int currentTaste, int currentCal){
        //기저부분
        if(currentCal > L){
            return;
        }
        if(idx >= N){
            if(currentTaste > max){
                max = currentTaste;
            }
            return;
        }

        //재귀부분
        powerSet(idx + 1, currentTaste + hamburger[idx][0], currentCal + hamburger[idx][1]);

        powerSet(idx + 1, currentTaste, currentCal);

    }
}
