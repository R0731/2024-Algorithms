package d2_Re;

import java.util.Scanner;

public class 파리퇴치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] fly = new int[N][N];

            for(int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    fly[r][c] = sc.nextInt();
                }
            }

            int max = 0;

            for(int r = 0; r < N - M + 1; r++){
                for(int c = 0; c < N - M + 1; c++){
                    int flyCatch = 0;
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            flyCatch += fly[r + a][c + b];
                        }
                    }
                    if(flyCatch > max){
                        max = flyCatch;
                    }
                }
            }


            System.out.println("#" + tc + " " + max);
        }
    }
}
