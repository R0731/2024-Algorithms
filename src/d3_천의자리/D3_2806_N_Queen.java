package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_2806_N_Queen {

    static int N;
    static int[] chess;
    static int count;

    static void dfs(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            chess[depth] = i;
            if(possible(depth)){
                dfs(depth+1);
            }
        }
    }

    static boolean possible(int col){
        for(int i = 0; i < col; i++){
            if(chess[i] == chess[col]){
                return false;
            }else if(Math.abs(col - i) == Math.abs(chess[col] - chess[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            chess = new int[N];

            dfs(0);

            System.out.println("#" + tc + " " + count);
        }
    }
}
