package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class D3_2806_NQueen {
    static int N;
    static int[] chessCol;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
//            N = sc.nextInt();
            N = Integer.parseInt(br.readLine());
            chessCol = new int[N];
            visited = new boolean[N];
            count = 0;

            perm(0);

            System.out.println("#" + tc + " " + count);
        }
    }

    private static boolean possible(int sidx, int i){
        for(int j = 0; j < sidx; j++){
            if(chessCol[j] == i){
//                System.out.println("불가");
                return false;
            }
            if(Math.abs(chessCol[j] - i) == Math.abs(j - sidx)){
//                System.out.println("불가");
                return false;
            }
        }

        return true;
    }

    private static void perm(int sidx){
        if(sidx == N){
//            System.out.println(Arrays.toString(chessCol));
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i] && possible(sidx, i)){
                visited[i] = true;
                chessCol[sidx] = i;
                perm(sidx + 1);
                visited[i] = false;
            }
        }
    }
}
