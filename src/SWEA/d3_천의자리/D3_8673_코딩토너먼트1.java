package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class D3_8673_코딩토너먼트1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int N = (int)Math.pow(2, K); //참가자 수 계산

            Stack<Integer> player = new Stack<>();

            StringTokenizer line = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                int a = Integer.parseInt(line.nextToken());
                player.add(a);
            }

            int lazy = 0;


            while(N > 1) {
                Stack<Integer> winner = new Stack<>();
                    while(!player.isEmpty()){
                        int a = player.pop();
                        int b = player.pop();
                        lazy += Math.abs(a - b);
                        if(a > b){
                            winner.add(a);
                        }else{
                            winner.add(b);
                        }
                    }
                    player = winner;
                    N /= 2;
                }
            System.out.println("#" + tc + " " + lazy);

        }

    }
}
