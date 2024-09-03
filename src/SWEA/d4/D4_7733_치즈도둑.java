package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7733_치즈도둑 {
    static class cheese{
        int day;
        boolean eat;

        public cheese(int day, boolean eat) {
            this.day = day;
            this.eat = eat;
        }
    }

    static int N;
    static int[][] cheese;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){

            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    cheese[i][j] = Integer.parseInt(line.nextToken());
                }
            }

            for(int i = 0; )

            System.out.println("#" + tc + " ");
        }
    }//main
}
