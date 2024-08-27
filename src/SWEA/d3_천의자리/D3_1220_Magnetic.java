package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class D3_1220_Magnetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine());

            int[][] nemo = new int[N][N];

            //네모 만들기
            for(int r = 0; r < N; r++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    nemo[r][c] = Integer.parseInt(line.nextToken());
                }
            }

            int deadlock = 0;

            for(int c = 0; c < N; c++){
                Stack<Integer> stack = new Stack<>();
                for(int r = 0; r < N; r++){
                    if(nemo[r][c] != 0) {
                        stack.add(nemo[r][c]);
                    }
                }

                while(stack.size() > 1){
                    int a = stack.pop();
                    int b = stack.peek();

                    if(a == 2 && b == 1){
                        deadlock++;
                    }
                }
            }


            System.out.println("#" + tc + " " + deadlock);
        }
    }
}
